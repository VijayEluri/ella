package org.unbunt.ella.compiler.statement;

import org.unbunt.ella.compiler.support.BlockClosure;
import org.unbunt.ella.compiler.statement.ExpressionVisitor;
import org.unbunt.ella.compiler.stmtbase.Expression;
import org.unbunt.ella.compiler.stmtbase.Statement;
import org.unbunt.ella.compiler.stmtbase.StatementContainer;

public class BlockClosureExpression implements Expression, StatementContainer {
    protected BlockClosure blockClosure;

    public BlockClosureExpression(BlockClosure blockClosure) {
        this.blockClosure = blockClosure;
    }

    public BlockClosure getBlockClosure() {
        return blockClosure;
    }

    public void setBlockClosure(BlockClosure blockClosure) {
        this.blockClosure = blockClosure;
    }

    public void addStatement(Statement statement) {
        blockClosure.setBody(statement);
    }

    public void addStatement(Expression expression) {
        blockClosure.setBody(expression);
    }

    public void accept(ExpressionVisitor visitor) {
        visitor.processExpression(this);
    }
}