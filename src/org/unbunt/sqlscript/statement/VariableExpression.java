package org.unbunt.sqlscript.statement;

import org.unbunt.sqlscript.ScriptProcessor;
import org.unbunt.sqlscript.lang.Obj;
import org.unbunt.sqlscript.support.Variable;
import org.unbunt.sqlscript.support.Env;

public class VariableExpression extends AbstractStatement implements Expression {
    protected String name;
    protected Variable variable;

    public VariableExpression(String name) {
        this.name = name;
    }

    public Obj getValue() {
        return variable.getValue();
    }

    public String getName() {
        return name;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public void accept(ScriptProcessor processor, Env env) {
        processor.process(env, this);
    }
}