package org.unbunt.ella.lang;

import org.unbunt.ella.engine.corelang.ProtoRegistry;
import org.unbunt.ella.engine.corelang.*;
import org.unbunt.ella.exception.ClosureTerminatedException;
import org.unbunt.ella.compiler.support.Function;
import org.unbunt.ella.engine.context.Context;

/**
 * Represents a default implementation of the EllaScript core object <code>Func</code>.
 */
public class FuncImpl extends AbstractObj implements Func {
    protected Function function;

    /**
     * Creates a new Func wrapping the given function.
     *
     * @param function the function to wrap.
     */
    public FuncImpl(Function function) {
        this.function = function;
    }

    public static final int OBJECT_ID = ProtoRegistry.generateObjectID();

    public int getObjectID() {
        return OBJECT_ID;
    }

    /**
     * Registers this EllaScript object within the given execution context.
     *
     * @param ctx the execution context to register this object in.
     */
    public static void registerInContext(Context ctx) {
        FuncProto.registerInContext(ctx);
        ctx.registerProto(OBJECT_ID, FuncProto.OBJECT_ID);
    }

    public Obj call(Engine engine, Obj context, Obj[] args) throws ClosureTerminatedException {
        return engine.invoke(this, context, null, args);
    }

    public Obj call(Engine engine, Obj context, Obj receiver, Obj... args) throws ClosureTerminatedException {
        return engine.invoke(this, context, receiver, args);
    }

    public void trigger(Engine engine, Obj context, Obj... args) {
        engine.trigger(this, context, args);
    }

    public Function getFunction() {
        return function;
    }

    /**
     * Represents the implicit parent object for Func objects.
     */
    public static class FuncProto extends AbstractObj {
        public static NativeCall nativeCall = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Obj[] callArgs = new Obj[args.length - 1];
                System.arraycopy(args, 1, callArgs, 0, callArgs.length);
                return engine.invoke(context, args[0], callArgs);
            }
        };

        private FuncProto() {
            slots.put(Str.SYM_call, nativeCall);
        }

        public static final int OBJECT_ID = ProtoRegistry.generateObjectID();

        public int getObjectID() {
            return OBJECT_ID;
        }

        /**
         * Registers this EllaScript object within the given execution context.
         *
         * @param ctx the execution context to register this object in.
         */
        public static void registerInContext(Context ctx) {
            Base.registerInContext(ctx);
            ctx.registerProto(OBJECT_ID, Base.OBJECT_ID);
            if (!ctx.hasObject(OBJECT_ID)) {
                ctx.registerObject(new FuncProto());
            }
        }
    }
}
