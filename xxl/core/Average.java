package xxl.core;

import java.util.List;

import xxl.core.exception.EmptyCellException;
import xxl.core.exception.StringNotIntegerException;

public class Average extends IntervalFunction {
    public Average(Range range) {
        super(range, "AVERAGE");
        this.setValue(compute());
    }
    @Override
    protected Literal compute(){
        int aux = 0;
        int nrCells = 0;
        List<Cell> auxList = this.getCells();
        for(Cell c : auxList) {
            nrCells++;
            try {
                aux += (c.value().asInt());
            }
            catch(StringNotIntegerException | EmptyCellException e) {
                return new LiteralString("#VALUE");
            }
        }
        return new LiteralInteger(aux/nrCells);
    }
    @Override
    Average copyContent() {
        return new Average(this.getRange());
    }
    @Override
    public Range getRange() {
        return super.getRange();
    }

    @Override
    public List<Cell> getCells() {
        return super.getRange().getCells();
    }
}