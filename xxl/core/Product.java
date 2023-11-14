package xxl.core;

import java.util.List;

import xxl.core.exception.EmptyCellException;
import xxl.core.exception.StringNotIntegerException;

public class Product extends IntervalFunction {

    public Product(Range range) {
        super(range, "PRODUCT");
    }

    @Override
    protected Literal compute(){;
        int aux = 1;
        List<Cell> auxList= this.getCells();
        for(Cell c : auxList) {
            try {
                aux *= (c.value().asInt());
            }
            catch(StringNotIntegerException | EmptyCellException e) {
                return new LiteralString("#VALUE");
            }
        }
        return new LiteralInteger(aux);
    }

    @Override
    Product copyContent() {
        return new Product(this.getRange());
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