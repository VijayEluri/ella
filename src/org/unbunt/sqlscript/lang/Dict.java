package org.unbunt.sqlscript.lang;

import org.unbunt.sqlscript.engine.*;
import org.unbunt.sqlscript.engine.natives.ObjUtils;
import org.unbunt.sqlscript.engine.natives.*;
import static org.unbunt.sqlscript.engine.natives.ObjUtils.ensureType;
import org.unbunt.sqlscript.exception.ClosureTerminatedException;
import org.unbunt.sqlscript.exception.LoopContinueException;
import org.unbunt.sqlscript.exception.LoopBreakException;
import org.unbunt.sqlscript.engine.context.Context;

import java.util.Map;

/**
 * User: tweiss
 * Date: 14.07.2009
 * Time: 08:24:02
 * <p/>
 * Copyright: (c) 2007 marketoolz GmbH
 */
public class Dict extends AbstractObj {
    public static final int OBJECT_ID = ProtoRegistry.generateObjectID();

    protected final Obj value;

    public Dict(Obj value) {
        this.value = value;
    }

    @Override
    public int getObjectID() {
        return OBJECT_ID;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Dict dict = (Dict) o;

        return value.equals(dict.value);
    }

    public int hashCode() {
        return value.hashCode();
    }

    public static void registerInContext(Context ctx) {
        DictProto.registerInContext(ctx);
        ctx.registerProto(OBJECT_ID, DictProto.OBJECT_ID);
    }

    public static class DictProto extends AbstractObj implements NativeObj {
        public static final int OBJECT_ID = ProtoRegistry.generateObjectID();

        protected static final NativeCall NATIVE_CONSTRUCTOR = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                return new Dict(args[0]);
            }
        };

        protected static final NativeCall nativeEach = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Dict thiz = ensureType(Dict.class, context);
                Obj closure = args[0];
                Obj _null = engine.getObjNull();

                Map<Obj,Obj> slots = thiz.value.getSlots();
                for (Map.Entry<Obj, Obj> entry : slots.entrySet()) {
                    try {
                        engine.invokeInLoop(closure, _null, entry.getKey(), entry.getValue());
                    } catch (LoopContinueException e) {
                        continue;
                    } catch (LoopBreakException e) {
                        break;
                    }
                }

                return null;
            }
        };

        protected static final NativeCall nativeGet = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Dict thiz = ensureType(Dict.class, context);
                Obj slot = args[0];
                return thiz.value.getSlot(engine.getContext(), slot);
            }
        };

        protected static final NativeCall nativeSet = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Dict thiz = ensureType(Dict.class, context);
                Obj slot = args[0];
                Obj value = args[1];
                thiz.value.setSlot(engine.getContext(), slot, value);
                return thiz;
            }
        };

        protected static final NativeCall nativeHas = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Dict thiz = ensureType(Dict.class, context);
                return thiz.value.getSlot(engine.getContext(), args[0]) == null
                        ? engine.getObjFalse() : engine.getObjTrue();
            }
        };

        protected static final NativeCall nativeRemove = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Dict thiz = ensureType(Dict.class, context);
                Obj removedSlot = thiz.value.removeSlot(engine.getContext(), args[0]);
                return removedSlot == null ? engine.getObjNull() : removedSlot;
            }
        };

        // NOTE: this is added to Base, not DictProto
        protected static final NativeCall nativeToDict = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                return new Dict(context);
            }
        };

        private DictProto() {
            slots.put(Str.SYM_each, nativeEach);
            slots.put(Str.SYM_get, nativeGet);
            slots.put(Str.SYM_set, nativeSet);
            slots.put(Str.SYM_has, nativeHas);
            slots.put(Str.SYM_remove, nativeRemove);
        }

        public Call getNativeConstructor() {
            return NATIVE_CONSTRUCTOR;
        }

        @Override
        public int getObjectID() {
            return OBJECT_ID;
        }

        public static void registerInContext(Context ctx) {
            Base.registerInContext(ctx);
            ctx.registerProto(OBJECT_ID, Base.OBJECT_ID);
            DictProto proto = new DictProto();
            ctx.registerObject(proto);
            // NOTE: toDict() method added to Base here, not in Base itself, to avoid circular dependency
            Base base = ObjUtils.ensureType(Base.class, ctx.getObjectProto(proto));
            base.setSlot(ctx, Str.SYM_toDict, nativeToDict);
        }
    }
}
