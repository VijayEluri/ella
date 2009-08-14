package org.unbunt.ella.compiler.statement;

import org.unbunt.ella.compiler.statement.ExpressionVisitor;
import org.unbunt.ella.compiler.support.SQLParseMode;
import org.unbunt.ella.compiler.stmtbase.Expression;

import java.util.LinkedList;
import java.util.List;

public class SQLLiteralExpression implements Expression {
    protected SQLParseMode parseMode = null;
    protected List<Object> parts = new LinkedList<Object>();

    public SQLParseMode getParseMode() {
        return parseMode;
    }

    public void setParseMode(SQLParseMode parseMode) {
        this.parseMode = parseMode;
    }

    public List<Object> getParts() {
        return parts;
    }

    public void setParts(List<Object> parts) {
        this.parts = parts;
    }

    public void addPart(Object part) {
        this.parts.add(part);
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (Object part : parts) {
            buf.append(part);
        }
        return buf.toString();
    }

    public void accept(ExpressionVisitor visitor) {
        visitor.processExpression(this);
    }
}