package org.unbunt.sqlscript.statement;

import org.unbunt.sqlscript.lang.NNum;
import org.unbunt.sqlscript.lang.Obj;
import org.unbunt.sqlscript.support.ExpressionVisitor;
import org.unbunt.sqlscript.support.Scope;

public class IntegerLiteralExpression implements Expression {
    protected String literal;
    protected NNum value;

    public IntegerLiteralExpression(String literal) {
        this.literal = literal;
        this.value = new NNum(Long.valueOf(literal));
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
