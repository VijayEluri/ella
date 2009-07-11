package org.unbunt.sqlscript.statement;

import org.unbunt.sqlscript.lang.NReal;
import org.unbunt.sqlscript.lang.Obj;
import org.unbunt.sqlscript.support.ExpressionVisitor;
import org.unbunt.sqlscript.support.Scope;

public class FloatingPointLiteralExpression implements Expression {
    protected String literal;
    protected NReal value;

    public FloatingPointLiteralExpression(String literal) {
        this.literal = literal;
        this.value = new NReal(Double.valueOf(literal));
    }

    public Obj getValue() {
        return value;
    }

    public Scope getScope() {
        return null;
    }

    public void setScope(Scope scope) {
    }

    public void accept(ExpressionVisitor visitor) {
        visitor.processExpression(this);
    }
}