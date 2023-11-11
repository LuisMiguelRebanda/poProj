package xxl.core;

import xxl.core.exception.EmptyCellException;
import xxl.core.exception.StringNotIntegerException;

public class Sub extends BinaryFunction {
    public Sub(Content one, Content two) {
        super("SUB", one, two);
    }
    @Override
    protected Literal compute() {
        LiteralInteger result = new LiteralInteger();
        try { int r = this.getFirstContent().value().asInt() - this.getSecondContent().value().asInt();
            result.setValue(r);
        } catch (StringNotIntegerException | EmptyCellException e) {
            return new LiteralString("#VALUE");
        }
        return result;
    }
    @Override
    Sub copyContent() {
        return new Sub(this.getFirstContent(), this.getSecondContent());
    }
}
