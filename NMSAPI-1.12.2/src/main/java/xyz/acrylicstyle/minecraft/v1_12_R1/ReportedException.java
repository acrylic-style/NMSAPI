package xyz.acrylicstyle.minecraft.v1_12_R1;

import util.CollectionList;
import util.ICollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReportedException extends RuntimeException {
    // NMSAPI start
    private Object o;

    public ReportedException(Object o) {
        this.o = o;
    }

    public ReportedException(CrashReport crashReport) {
        try {
            this.o = ReflectionUtil.getNMSClass("ReportedException").getConstructor(ReflectionUtil.getNMSClass("CrashReport")).newInstance(crashReport.getHandle());
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public CrashReport a() {
        return new CrashReport(invoke("a"));
    }

    public CrashReport getCrashReport() { return a(); }

    public Throwable getCause() {
        return (Throwable) invoke("getCause");
    }

    public String getMessage() {
        return (String) invoke("getMessage");
    }

    public RuntimeException toNMSClass() {
        try {
            if (o.getClass().getCanonicalName().equals(ReflectionUtil.getNMSClass("ReportedException").getCanonicalName())) return (RuntimeException) o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("ReportedException"), toNMSClass(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("ReportedException")
                    .getMethod(method)
                    .invoke(toNMSClass());
        } catch (NoSuchMethodException e) {
            try {
                return ReflectionUtil.getNMSClass("ReportedException")
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
            return ReflectionUtil.getNMSClass("ReportedException")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(toNMSClass(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setField(String field, Object value) {
        try {
            Field f = ReflectionUtil.getNMSClass("ReportedException").getDeclaredField(field);
            f.setAccessible(true);
            f.set(toNMSClass(), value);
        } catch (NoSuchFieldException e) {
            try {
                Field f = ReflectionUtil.getNMSClass("ReportedException").getSuperclass().getDeclaredField(field);
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
