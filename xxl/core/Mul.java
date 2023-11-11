package xxl.core;

import xxl.core.exception.EmptyCellException;
import xxl.core.exception.StringNotIntegerException;

public class Mul extends BinaryFunction {
    public Mul(Content one, Content two) {
        super("MUL", one, two);
    }
    @Override
    protected Literal compute() {
        LiteralInteger result = new LiteralInteger();
        try { int r = this.getFirstContent().value().asInt() * this.getSecondContent().value().asInt();
            result.setValue(r);
        } catch (StringNotIntegerException | EmptyCellException e) {
            return new LiteralString("#VALUE");
        }
        return result;
    }
    @Override
    Mul copyContent() {
        return new Mul(this.getFirstContent(), this.getSecondContent());
    }
}
