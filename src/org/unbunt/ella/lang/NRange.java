package org.unbunt.ella.lang;

import org.unbunt.ella.exception.ClosureTerminatedException;
import org.unbunt.ella.exception.LoopBreakException;
import org.unbunt.ella.exception.LoopContinueException;
import org.unbunt.ella.lang.NativeWrapper;
import org.unbunt.ella.engine.corelang.*;
import static org.unbunt.ella.engine.corelang.ObjUtils.ensureType;
import org.unbunt.ella.engine.context.Context;

/**
 * User: tweiss
 * Date: 14.07.2009
 * Time: 07:46:28
 * <p/>
 * Copyright: (c) 2007 marketoolz GmbH
 */
public class NRange extends AbstractObj {
    public static final int OBJECT_ID = ProtoRegistry.generateObjectID();

    protected final long start;
    protected final long stop;

    public NRange(long start, long stop) {
        this.start = start;
        this.stop = stop;
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

        NRange nRange = (NRange) o;

        return start == nRange.start && stop == nRange.stop;
    }

    public int hashCode() {
        int result;
        result = (int) (start ^ (start >>> 32));
        result = 31 * result + (int) (stop ^ (stop >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Range[" + start + ", " + stop + "]";
    }

    public static void registerInContext(Context ctx) {
        NRangeProto.registerInContext(ctx);
        ctx.registerProto(OBJECT_ID, NRangeProto.OBJECT_ID);
    }

    public static final class NRangeProto extends AbstractObj implements NativeObj {
        public static final int OBJECT_ID = ProtoRegistry.generateObjectID();

        protected static final NativeCall NATIVE_CONSTRUCTOR = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                NNumeric start = ensureType(NNumeric.class, args[0]);
                NNumeric stop = ensureType(NNumeric.class, args[1]);

                return new NRange(start.longValue(), stop.longValue());
            }
        };

        protected static final NativeCall nativeEach = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                NRange thiz = ensureType(NRange.class, context);
                Obj closure = args[0];

                long start = thiz.start;
                long stop  = thiz.stop;
                long step  = start < stop ? 1 : -1;

                long i = start;

                Null _null = engine.getObjNull();
                try {
                    engine.invokeInLoop(closure, _null, NativeWrapper.wrap(i));
                } catch (LoopBreakException e) {
                    return null;
                } catch (LoopContinueException e) {
                    // nothing to do here just proceed to next iteration
                }

                while (i != stop) {
                    try {
                        i += step;
                        engine.invokeInLoop(closure, _null, NativeWrapper.wrap(i));
                    } catch (LoopBreakException e) {
                        return null;
                    } catch (LoopContinueException e) {
                        // nothing to do here just proceed to next iteration
                    }
                }

                return null;
            }
        };

        protected static final NativeCall nativeStart = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                NRange thiz = ensureType(NRange.class, context);
                return new NNum(thiz.start);
            }
        };

        protected static final NativeCall nativeStop = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                NRange thiz = ensureType(NRange.class, context);
                return new NNum(thiz.stop);
            }
        };

        private NRangeProto() {
            slots.put(Str.SYM_each, nativeEach);
            slots.put(Str.SYM_start, nativeStart);
            slots.put(Str.SYM_stop, nativeStop);
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
            ctx.registerObject(new NRangeProto());
        }
    }
}