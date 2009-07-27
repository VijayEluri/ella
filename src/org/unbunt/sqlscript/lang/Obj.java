package org.unbunt.sqlscript.lang;

import org.unbunt.sqlscript.support.Context;

import java.util.Map;

public interface Obj {
    int getObjectID();

    Obj setSlot(Context ctx, Obj key, Obj value);

    Obj getSlot(Context ctx, Obj key);

    Obj removeSlot(Context ctx, Obj key);

    Map<Obj, Obj> getSlots();

    void setSlots(Map<Obj, Obj> slots);

    Object toJavaObject();
}
