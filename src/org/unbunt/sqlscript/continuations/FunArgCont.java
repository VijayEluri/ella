package org.unbunt.sqlscript.continuations;

import org.unbunt.sqlscript.statement.Expression;
import org.unbunt.sqlscript.statement.Statement;
import org.unbunt.sqlscript.support.Function;
import org.unbunt.sqlscript.support.Env;

import java.util.Map;
import java.util.Iterator;

public class FunArgCont implements Continuation {
    protected Function func;

    protected Map<String, Expression> args;
    protected Iterator<Map.Entry<String,Expression>> iterator;

    protected Env funcEnv;
    protected Env savedEnv;

    public FunArgCont(Function func, Map<String, Expression> args, Env savedEnv) {
        this.func = func;
        this.args = args;
        this.iterator = args == null ? null : args.entrySet().iterator();
        this.funcEnv = func.getEnv().clone();
        this.savedEnv = savedEnv;
    }

    public FunArgCont(Function func, Map<String, Expression> args, Env funcEnv, Env savedEnv) {
        this.func = func;
        this.args = args;
        this.iterator = args == null ? null : args.entrySet().iterator();
        this.funcEnv = funcEnv;
        this.savedEnv = savedEnv;
    }

    public Function getFunc() {
        return func;
    }

    public boolean hasNext() {
        return iterator != null && iterator.hasNext();
    }

    public Map.Entry<String, Expression> next() {
        return iterator.next();
    }

    public Env getFuncEnv() {
        return funcEnv;
    }

    public Env getSavedEnv() {
        return savedEnv;
    }

    public Statement getBody() {
        return func.getBody();
    }
}