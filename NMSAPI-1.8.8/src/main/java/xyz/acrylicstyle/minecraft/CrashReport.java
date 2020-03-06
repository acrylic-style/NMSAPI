package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ICollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CrashReport {
    public void h() {
        invoke("h");
    }

    public String a() {
        return (String) getField("b");
    }

    public String getMessage() { return a(); }

    public Throwable b() {
        return (Throwable) getField("c");
    }

    public Throwable getThrowable() { return b(); }

    public void a(StringBuilder stringBuilder) {
        invoke("a" ,stringBuilder);
    }

    public String d() {
        return (String) invoke("d");
    }

    public String e() {
        return (String) invoke("e");
    }

    public boolean a(File file) {
        return (boolean) invoke("a", file);
    }

    public boolean saveCrashReport(File file) {
        return a(file);
    }

    public static String i() {
        try {
            Method method = ReflectionUtil.getNMSClass("CrashReport").getDeclaredMethod("i");
            method.setAccessible(true);
            return (String) method.invoke(null);
        } catch(ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getRandomMessage() { return i(); }

    public static CrashReport a(Throwable throwable, String s) {
        CrashReport crashReport;
        if (throwable instanceof ReportedException) {
            crashReport = ((ReportedException) throwable).getCrashReport();
        } else crashReport = new CrashReport(s, throwable);
        return crashReport;
    }

    public static CrashReport getCrashReport(Throwable throwable, String s) {
        return a(throwable, s);
    }

    public CrashReportSystemDetails g() {
        return new CrashReportSystemDetails(getField("d"));
    }

    public CrashReportSystemDetails a(String s) {
        return a(s, 1);
    }

    public CrashReportSystemDetails a(String s, int i) {
        return new CrashReportSystemDetails(invoke("a", s, i));
    }

    // NMSAPI start
    private Object o;

    public CrashReport(Object o) {
        this.o = o;
    }

    public CrashReport(String s, Throwable throwable) {
        try {
            this.o = ReflectionUtil.getNMSClass("CrashReport").getConstructor(String.class, Throwable.class).newInstance(s, throwable);
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Object toNMSClass() {
        try {
            if (o.getClass().getCanonicalName().equals(ReflectionUtil.getNMSClass("CrashReport").getCanonicalName())) return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("CrashReport"), toNMSClass(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("CrashReport")
                    .getMethod(method)
                    .invoke(toNMSClass());
        } catch (NoSuchMethodException e) {
            try {
                return ReflectionUtil.getNMSClass("CrashReport")
                        .getSuperclass()
                        .getMethod(method)
                        .invoke(toNMSClass());
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = ICollectionList.asList(o).map(Object::getClass);
            return ReflectionUtil.getNMSClass("CrashReport")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(toNMSClass(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setField(String field, Object value) {
        try {
            Field f = ReflectionUtil.getNMSClass("CrashReport").getDeclaredField(field);
            f.setAccessible(true);
            f.set(toNMSClass(), value);
        } catch (NoSuchFieldException e) {
            try {
                Field f = ReflectionUtil.getNMSClass("CrashReport").getSuperclass().getDeclaredField(field);
                f.setAccessible(true);
                f.set(toNMSClass(), value);
            } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    // NMSAPI end
}
