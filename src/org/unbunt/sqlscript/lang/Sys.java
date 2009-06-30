package org.unbunt.sqlscript.lang;

import org.unbunt.sqlscript.SQLScriptEngine;
import org.unbunt.sqlscript.support.DynamicEnv;
import org.unbunt.sqlscript.support.DynamicVariableResolver;
import org.unbunt.sqlscript.support.Variable;
import org.unbunt.sqlscript.support.CachingVariableResolver;
import org.unbunt.sqlscript.exception.ClosureTerminatedException;
import org.unbunt.sqlscript.exception.LoopContinueException;
import org.unbunt.sqlscript.exception.LoopBreakException;
import org.unbunt.sqlscript.exception.ScriptClientException;
import org.unbunt.utils.StringUtils;

public class Sys extends PlainObj {
    protected static final NativeCall nativePrint = new NativeCall() {
        public Obj call(SQLScriptEngine engine, Obj context, Obj[] args) throws ClosureTerminatedException {
            System.out.println(StringUtils.join(" ", (Object[]) args));
            return Null.instance;
        }
    };

    protected static final NativeCall nativeImportPackage = new NativeCall() {
        public Obj call(SQLScriptEngine engine, Obj context, Obj[] args) throws ClosureTerminatedException {
            final String pkgPrefix = args[0].toString() + ".";
            final ClassLoader loader = engine.getClass().getClassLoader();
            DynamicEnv newEnv = new DynamicEnv(engine.getEnv(), new CachingVariableResolver(
                    new DynamicVariableResolver() {
                        public Obj resolve(Variable var) {
                            Class cls;
                            try {
                                cls = loader.loadClass(pkgPrefix + var.name);
                            } catch (ClassNotFoundException e) {
                                return null;
                            }
                            return new JClass(cls);
                        }
                    }));
            engine.setEnv(newEnv);
            return Null.instance;
        }
    };

    protected static final NativeCall nativeIfThen = new NativeCall() {
        public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
            Obj condVal = engine.invoke(args[0], Null.instance);
            boolean condSatisfied = engine.toBoolean(condVal);
            if (condSatisfied) {
                engine.trigger(args[1], context);
            }
            return null;
        }
    };

    protected static final NativeCall nativeLoop = new NativeCall() {
        public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
            engine.invoke(PrimitiveCall.Type.LOOP.primitive, Null.instance);
            while (true) {
                try {
                    engine.invoke(args[0], Null.instance);
                } catch (LoopContinueException e) {
                    continue;
                } catch (LoopBreakException e) {
                    break;
                }
            }
            return null;
        }
    };

    protected static final NativeCall nativeThrow = new NativeCall() {
        public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
            throw new ScriptClientException(args[0]);
        }
    };

    protected static final NativeCall nativeTryCatch = new NativeCall() {
        public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
            SQLScriptEngine.EngineState state = engine.getState();
            try {
                engine.invoke(args[0], Null.instance);
            } catch (ScriptClientException e) {
                engine.invoke(args[1], Null.instance, e.getException());
            }
            engine.setState(state);
            return null;
        }
    };

    protected static final NativeCall nativeTryFinally = new NativeCall() {
        public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
            SQLScriptEngine.EngineState state = engine.getState();
            try {
                engine.invoke(args[0], Null.instance);
            } finally {
                Obj savedVal = null;
                try {
                    if (engine.isClosureReturnInProgress()) {
                        savedVal = engine.getVal();
                    }
                    engine.invoke(args[2], Null.instance);
                } finally {
                    if (savedVal != null) {
                        engine.setVal(savedVal);
                    }
                }
            }
            engine.setState(state);
            return null;
        }
    };

    protected static final NativeCall nativeTryCatchFinally = new NativeCall() {
        public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
            SQLScriptEngine.EngineState state = engine.getState();
            try {
                engine.invoke(args[0], Null.instance);
            } catch (ScriptClientException e) {
                engine.invoke(args[1], Null.instance, e.getException());
            } finally {
                Obj savedVal = null;
                try {
                    if (engine.isClosureReturnInProgress()) {
                        savedVal = engine.getVal();
                    }
                    engine.invoke(args[2], Null.instance);
                } finally {
                    if (savedVal != null) {
                        engine.setVal(savedVal);
                    }
                }
            }
            engine.setState(state);
            return null;
        }
    };

    protected static final NativeCall nativeNoop = new NativeCall() {
        public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
            return Null.instance;
        }
    };

    public static final Sys instance = new Sys();

    public Sys() {
        slots.put(Str.SYM_parent, Base.instance);
        slots.put(Str.SYM_print, nativePrint);
        slots.put(Str.SYM_importPackage, nativeImportPackage);
        slots.put(Str.SYM_loop, nativeLoop);
        slots.put(Str.SYM_break, PrimitiveCall.Type.LOOP_BREAK.primitive);
        slots.put(Str.SYM_continue, PrimitiveCall.Type.LOOP_CONTINUE.primitive);
        slots.put(Str.SYM_ifThen, nativeIfThen);
        slots.put(Str.SYM_throw, nativeThrow);
        slots.put(Str.SYM_raise, nativeThrow);
        slots.put(Str.SYM_tryCatch, nativeTryCatch);
        slots.put(Str.SYM_tryCatchFinally, nativeTryCatchFinally);
        slots.put(Str.SYM_tryFinally, nativeTryFinally);
        slots.put(Str.SYM_noop, nativeNoop);
    }
}
