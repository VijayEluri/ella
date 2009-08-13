package org.unbunt.ella.engine.continuations;

import org.unbunt.ella.engine.environment.Env;
import org.unbunt.ella.engine.continuations.ContinuationVisitor;

public class FunRetCont implements Continuation {
    protected Env savedEnv;

    public FunRetCont(Env savedEnv) {
        this.savedEnv = savedEnv;
    }

    public Env getSavedEnv() {
        return savedEnv;
    }

    public void accept(ContinuationVisitor visitor) {
        visitor.processContinuation(this);
    }
}