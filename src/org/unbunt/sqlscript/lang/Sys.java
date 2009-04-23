package org.unbunt.sqlscript.lang;

import org.unbunt.sqlscript.SQLScriptEngine;
import org.unbunt.sqlscript.support.DynamicEnv;
import org.unbunt.sqlscript.support.DynamicVariableResolver;
import org.unbunt.sqlscript.exception.ClosureTerminatedException;
import org.unbunt.utils.StringUtils;

public class Sys extends Obj {
    protected static final Native nativePrint = new Native() {
        public Obj call(SQLScriptEngine engine, Obj context, Obj[] args) throws ClosureTerminatedException {
            System.out.println(StringUtils.join(" ", (Object[]) args));
            return Null.instance;
        }
    };

    protected static final Native nativeImportPackage = new Native() {
        public Obj call(SQLScriptEngine engine, Obj context, Obj[] args) throws ClosureTerminatedException {
            final String pkgPrefix = args[0].toString() + ".";
            final ClassLoader loader = engine.getClass().getClassLoader();
            DynamicEnv newEnv = new DynamicEnv(engine.getEnv(), new DynamicVariableResolver() {
                public Obj resolve(String name) {
                    Class cls;
                    try {
                        cls = loader.loadClass(pkgPrefix + name);
                    } catch (ClassNotFoundException e) {
                        return null;
                    }
                    return new JClass(cls);
                }
            });
            engine.setEnv(newEnv);
            return Null.instance;
        }
    };

    public static final Sys instance = new Sys();

    public Sys() {
        slots.put(Str.Sym.parent.str, Base.instance);
        slots.put(Str.Sym.print.str, nativePrint);
        slots.put(Str.Sym.importPackage.str, nativeImportPackage);
    }
}
