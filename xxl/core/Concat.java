package xxl.core;

import xxl.core.exception.EmptyCellException;
import xxl.core.exception.IntegerNotStringException;

import java.util.List;

public class Concat extends IntervalFunction {
    public Concat(Range range) {
        super(range, "CONCAT");
    }
    @Override
    protected Literal compute(){;
        String aux ="";
        List<Cell> auxList= this.getCells();
        for(Cell c : auxList) {
            try {
                aux = aux.concat(c.value().asString());
            }
            catch (IntegerNotStringException|EmptyCellException e) {
                continue;
            }
        }

        aux = aux.replaceAll("\'", "");
        aux = "\'" + aux;

        return new LiteralString(aux);
    }
    @Override
    Concat copyContent() {
        return new Concat(this.getRange());
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