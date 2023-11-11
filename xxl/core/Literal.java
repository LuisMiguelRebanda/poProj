package xxl.core;

import xxl.core.exception.IntegerNotStringException;
import xxl.core.exception.StringNotIntegerException;

public abstract class Literal extends Content {
    @Override
    Literal value() {
        return this;
    }

    @Override
    public abstract String asString() throws IntegerNotStringException;

    @Override
    public abstract int asInt() throws StringNotIntegerException;

    @Override
    abstract Literal copyContent();


}