package xxl.core;

import xxl.core.exception.StringNotIntegerException;

public class LiteralString extends Literal {
    private String _value;

    public LiteralString(String s) {
        _value = s;
    }

    @Override
    public String toString() { return _value; }

    @Override
    public String asString() { return _value; }

    @Override
    public int asInt() throws StringNotIntegerException {
        throw new StringNotIntegerException();
    }
    @Override
    LiteralString copyContent() {
        return new LiteralString(_value);
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(object == null || getClass() != object.getClass()) {
            return false;
        }
        LiteralString literalString = (LiteralString) object;

        return _value.equals(literalString.asString());
    }

    @Override
    public String accept(Visitor v) {
        return v.visitLiteralString(this);
    }
}
