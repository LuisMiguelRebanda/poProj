package xxl.core;

import xxl.core.exception.EmptyCellException;
import xxl.core.exception.IntegerNotStringException;
import xxl.core.exception.StringNotIntegerException;

public abstract class Function extends Content {
    private final String _name;
    private Literal _value;

    public Function(String name) {
        _name = name;
    }

    public void setValue(Literal literal) {
        _value = literal;
    }

    public String getName() {
        return _name;
    }

    protected abstract Literal compute();

    public String asString() throws IntegerNotStringException {
        return _value.asString();
    }

    public int asInt() throws StringNotIntegerException {
        return _value.asInt();
    }
    @Override
    public Literal value() throws EmptyCellException {
        if(_value == null)
            throw new EmptyCellException();
        return _value;
    }

    protected void setLiteral(Literal v) {
        _value = v;
    }
    @Override
    abstract Function copyContent();

    public void update() {
        this.setValue(this.compute());
    }
    public abstract void unsubscribe();
    @Override
    public String accept(Visitor v) {
        return v.visitFunction(this);
    }
}
