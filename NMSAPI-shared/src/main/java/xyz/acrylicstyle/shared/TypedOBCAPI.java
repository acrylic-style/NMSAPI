package xyz.acrylicstyle.shared;

import org.jetbrains.annotations.Nullable;
import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.util.Handler;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Added type parameter to the {@link OBCAPI}, so it's easier to delegate.
 */
public class TypedOBCAPI<T> implements Handler<NMSAPI> {
    private String obcClassName;

    /**
     * Set OBC (org.bukkit.craftbukkit) object. This does not call constructor and it doesn't check types.
     * @param t Object
     * @param obcClassName NMS Class name
     */
    protected TypedOBCAPI(T t, String obcClassName) {
        this.t = t;
        this.obcClassName = obcClassName;
    }

    /**
     * Constructs OBCAPI and calls OBC class's constructor.
     * @param obcClassName OBC class name (target)
     * @param o Constructor args
     */
    @SuppressWarnings("unchecked")
    protected TypedOBCAPI(String obcClassName, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            this.t = (T) ReflectionUtil.getOBCClass(obcClassName)
                    .getConstructor(classes.toArray(new Class[0]))
                    .newInstance(o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static <T> TypedOBCAPI<T> getEmptyTypedOBCAPI(T t, String obcClassName) { return new TypedOBCAPI<>(t, obcClassName); }

    public static <T> TypedOBCAPI<T> getEmptyTypedOBCAPI(String obcClassName, Object... o) { return new TypedOBCAPI<>(obcClassName, o); }

    protected T t;

    public T getOBCClass() {
        return t;
    }

    public NMSAPI getHandle() {
        String o = obcClassName.replaceAll("Craft", "");
        o = o.replaceAll("(.*\\.|)(.*)", "$2");
        return NMSAPI.getEmptyNMSAPI(invoke("getHandle"), o);
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getOBCClass(obcClassName), getOBCClass(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
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

    public static Object invokeStatic(String clazz, Object object, String method) {
        return invoke0(clazz, object, method);
    }

    @Nullable
    static Object invoke0(String clazz, Object object, String method) {
        try {
            Method m = ReflectionUtil.getOBCClass(clazz).getDeclaredMethod(method);
            m.setAccessible(true);
            return m.invoke(object);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            return invoke0(obcClassName, method, o).invoke(getOBCClass(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invokeStatic(String clazz, Object object, String method, Object... o) {
        try {
            return invoke0(clazz, method, o).invoke(object, o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Method invoke0(String clazz, String method, Object[] o) throws NoSuchMethodException, ClassNotFoundException {
        CollectionList<Class<?>> classes = new CollectionList<>();
        for (Object o1 : o) classes.add(o1.getClass());
        Method m = ReflectionUtil.getOBCClass(clazz).getMethod(method, classes.toArray(new Class[0]));
        m.setAccessible(true);
        return m;
    }

    public static Class<?> getClassWithoutException(String clazz) {
        try {
            return ReflectionUtil.getOBCClass(clazz);
        } catch (ClassNotFoundException e) { throw new ExceptionInInitializerError(e); }
    }
}

