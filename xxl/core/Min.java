package xxl.core;
import java.util.List;
import xxl.core.exception.EmptyCellException;
import xxl.core.exception.StringNotIntegerException;

public class Min extends IntervalFunction {
    public Min(Range range) {
        super(range, "MAX");
        this.setValue(compute());
    }

    @Override
    protected Literal compute() {
        int counter = 0;
        int auxInt = 0;
        List<Cell> auxList = this.getCells();
        for (Cell c : auxList) {
            try {
                if (counter == 0) {
                    auxInt = c.value().asInt();
                    counter++;
                }
                if (c.value().asInt() < auxInt) {

                    auxInt = c.value().asInt();
                    counter++;
                }
            }
            catch (StringNotIntegerException | EmptyCellException e) {
                continue;
            }
        }
        if (counter == 0)
            return new LiteralString("#VALUE");
        else
            return new LiteralInteger(auxInt);
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