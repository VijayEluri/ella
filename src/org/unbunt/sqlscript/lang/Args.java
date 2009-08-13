package org.unbunt.ella.lang;

import org.unbunt.ella.exception.ClosureTerminatedException;
import org.unbunt.ella.exception.EllaRuntimeException;
import org.unbunt.ella.engine.*;
import org.unbunt.ella.engine.corelang.Obj;
import org.unbunt.ella.engine.corelang.AbstractObj;
import org.unbunt.ella.engine.corelang.NativeCall;
import org.unbunt.ella.engine.corelang.ProtoRegistry;
import static org.unbunt.ella.engine.corelang.ObjUtils.ensureType;
import org.unbunt.ella.engine.context.Context;

public class Args extends AbstractObj {
    public final Obj[] args;

    public static final Args emptyArgs = new Args(new Obj[0]);

    public Args(Obj[] args) {
        this.args = args;
    }

    public static final int OBJECT_ID = ProtoRegistry.generateObjectID();

    @Override
    public int getObjectID() {
        return OBJECT_ID;
    }

    public static void registerInContext(Context ctx) {
        ArgsProto.registerInContext(ctx);
        ctx.registerProto(OBJECT_ID, ArgsProto.OBJECT_ID);
    }

    protected static class ArgsProto extends AbstractObj {
        protected static final NativeCall nativeGet = new NativeCall() {
            public Obj call(Engine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Args thiz = ensureType(Args.class, context);
                NNumeric idxObj = ensureType(NNumeric.class, args[0]);
                int idx = idxObj.intValue(); // TODO: maybe throw exception if value doesn't fit in int
                try {
                    return thiz.args[idx];
                } catch (IndexOutOfBoundsException e) {
                    throw new EllaRuntimeException(e);
                }
            }
        };

        private ArgsProto() {
            slots.put(Str.SYM_get, nativeGet);
        }

        public static final int OBJECT_ID = ProtoRegistry.generateObjectID();

        @Override
        public int getObjectID() {
            return OBJECT_ID;
        }

        public static void registerInContext(Context ctx) {
            Base.registerInContext(ctx);
            ctx.registerProto(OBJECT_ID, Base.OBJECT_ID);
            ctx.registerObject(new ArgsProto());
        }
    }
}
