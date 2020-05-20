package xyz.acrylicstyle.shared;

import util.CollectionList;
import util.reflect.Ref;
import util.reflect.RefClass;
import util.reflect.RefMethod;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.util.Handler;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OBCAPI implements Handler<Object> {
    private String obcClassName;

    /**
     * Set OBC (org.bukkit.craftbukkit) object. This does not call constructor and it doesn't check types.
     * @param o Object
     * @param obcClassName NMS Class name
     */
    protected OBCAPI(Object o, String obcClassName) {
        this.o = o;
        this.obcClassName = obcClassName;
    }

    /**
     * Constructs OBCAPI and calls OBC class's constructor.
     * @param obcClassName OBC class name (target)
     * @param o Constructor args
     */
    protected OBCAPI(String obcClassName, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            this.o = ReflectionUtil.getOBCClass(obcClassName)
                    .getConstructor(classes.toArray(new Class[0]))
                    .newInstance(o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static OBCAPI getEmptyOBCAPI(Object o, String obcClassName) { return new OBCAPI(o, obcClassName); }

    protected Object o;

    public Object getOBCClass() {
        try {
            if (o.getClass().getCanonicalName().equalsIgnoreCase(ReflectionUtil.getOBCClass(obcClassName).getCanonicalName())) return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getHandle() { return getOBCClass(); }

    public Object getField(String field) {
        return RefClass
                .forName(xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil.getCraftBukkitPackage() + "." + obcClassName)
                .getField(field)
                .get(getOBCClass());
    }

    public void setField(String field, Object value) {
        try {
            Field f = ReflectionUtil.getOBCClass(obcClassName).getDeclaredField(field);
            f.setAccessible(true);
            f.set(getOBCClass(), value);
        } catch (NoSuchFieldException e) {
            try {
                Field f = ReflectionUtil.getOBCClass(obcClassName).getSuperclass().getDeclaredField(field);
                f.setAccessible(true);
                f.set(getOBCClass(), value);
            } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object invoke(String method) {
        try {
            Method m = ReflectionUtil.getOBCClass(obcClassName).getDeclaredMethod(method);
            m.setAccessible(true);
            return m.invoke(getOBCClass());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public RefMethod<?> method(String method, Class<?>... classes) { return Ref.getMethod(getClassWithoutException(obcClassName), method, classes); }

    public Object invoke(String method, Object... o) {
        try {
            return invoke0(obcClassName, method, o).invoke(getOBCClass(), o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private static <S> RefMethod<S> invoke0(String clazz, String method, Object[] o) throws ClassNotFoundException {
        CollectionList<Class<?>> classes = new CollectionList<>();
        for (Object o1 : o) classes.add(o1.getClass());
        return Ref.getMethod((Class<S>) ReflectionUtil.getOBCClass(clazz), method, classes.toArray(new Class[0])).accessible(true);
    }

    public static Class<?> getClassWithoutException(String clazz) {
        try {
            return ReflectionUtil.getOBCClass(clazz);
        } catch (ClassNotFoundException e) { throw new ExceptionInInitializerError(e); }
    }
}

