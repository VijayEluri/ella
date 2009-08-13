package org.unbunt.ella.engine.continuations;

import org.unbunt.ella.compiler.stmtbase.Statement;
import org.unbunt.ella.compiler.support.Callable;
import org.unbunt.ella.engine.continuations.ContinuationVisitor;
import org.unbunt.ella.engine.environment.Env;

public class CallArgCont implements Continuation {
    protected Callable callable;

    protected Env funcEnv;
    protected Env savedEnv;

    protected boolean tailCall;

    public CallArgCont(Callable callable, Env funcEnv, Env savedEnv) {
        this.callable = callable;
        this.funcEnv = funcEnv;
        this.savedEnv = savedEnv;
        this.tailCall = false;
    }

    public CallArgCont(Callable callable, Env funcEnv, Env savedEnv, boolean tailCall) {
        this.callable = callable;
        this.funcEnv = funcEnv;
        this.savedEnv = savedEnv;
        this.tailCall = tailCall;
    }

    public Callable getCallable() {
        return callable;
    }

    public Env getCallEnv() {
        return funcEnv;
    }

    public Env getSavedEnv() {
        return savedEnv;
    }

    public boolean isTailCall() {
        return tailCall;
    }

    public Statement getBody() {
        return callable.getBody();
    }

    public void accept(ContinuationVisitor visitor) {
        visitor.processContinuation(this);
    }
}
