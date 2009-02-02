package org.unbunt.sqlscript.continuations;

import org.unbunt.sqlscript.statement.Block;
import org.unbunt.sqlscript.support.Env;

public class BlockCont implements Continuation {
    protected Block block;
    protected Env env;
    protected int curStmt;

    public BlockCont(Block block, Env env) {
        this.block = block;
        this.env = env;
        curStmt = 0;
    }

    public Block getBlock() {
        return block;
    }

    public Env getEnv() {
        return env;
    }

    public int getCurStmt() {
        return curStmt;
    }

    public void setCurStmt(int curStmt) {
        this.curStmt = curStmt;
    }
}