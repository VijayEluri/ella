package org.unbunt.ella.engine.environment;

import org.unbunt.ella.engine.corelang.Obj;
import org.unbunt.ella.engine.environment.Env;
import org.unbunt.ella.compiler.support.Variable;

public abstract class AbstractEnv implements Env {
    protected Env parent;

    protected AbstractEnv() {
        this.parent = null;
    }

    protected AbstractEnv(Env parent) {
        this.parent = parent;
    }

    public Obj get(Variable var) {
        return get(var, var.address);
    }

    public void set(Variable var, Obj value) {
        set(var, var.address, value);
    }
}