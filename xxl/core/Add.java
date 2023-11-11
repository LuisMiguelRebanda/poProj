package xxl.core;

import xxl.core.exception.EmptyCellException;
import xxl.core.exception.StringNotIntegerException;

public class Add extends BinaryFunction {

    public Add(Content one, Content two) {
        super("ADD", one, two);
    }
    @Override
    protected Literal compute() {
        LiteralInteger result = new LiteralInteger();
        try { int r = this.getFirstContent().value().asInt() + this.getSecondContent().value().asInt();
            result.setValue(r);
        } catch (StringNotIntegerException | EmptyCellException e) {
            return new LiteralString("#VALUE");
        }
        return result;
    }
    @Override
    Add copyContent() {
        return new Add(this.getFirstContent(), this.getSecondContent());
    }
}
