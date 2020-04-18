package xyz.acrylicstyle.shared;

import util.CollectionList;
import util.ICollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class NMSAPI {
    private static final Logger LOGGER = Logger.getLogger("NMSAPI");
    protected final String nmsClassName;

    /**
     * Set NMS object. This does not call constructor and it doesn't check types.
     * @param o Object
     * @param nmsClassName NMS Class name
     */
    protected NMSAPI(Object o, String nmsClassName) {
        this.o = o;
        this.nmsClassName = nmsClassName;
    }

    /**
     * Constructs NMSAPI and calls NMS class's constructor.
     * @param nmsClassName NMS class name (target)
     * @param o Constructor args
     */
    protected NMSAPI(String nmsClassName, Object... o) {
        this.nmsClassName = nmsClassName;
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            this.o = ReflectionUtil.getNMSClass(nmsClassName)
                    .getConstructor(classes.toArray(new Class[0]))
                    .newInstance(o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    protected Object o;

    public Object getNMSClass() {
        try {
            if (o == null) {
                LOGGER.severe("Object is null!");
            }
            if (o.getClass().getCanonicalName().equalsIgnoreCase(ReflectionUtil.getNMSClass(nmsClassName).getCanonicalName())) return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final Object getHandle() { return getNMSClass(); }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass(nmsClassName), getNMSClass(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            LOGGER.severe("An error occurred while getting a field: " + field);
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public final <T> T field(String f) {
        return (T) getField(f);
    }

    public void setField(String field, Object value) {
        try {
            Field f = ReflectionUtil.getNMSClass(nmsClassName).getDeclaredField(field);
            f.setAccessible(true);
            f.set(getNMSClass(), value);
        } catch (NoSuchFieldException e) {
            try {
                Field f = ReflectionUtil.getNMSClass(nmsClassName).getSuperclass().getDeclaredField(field);
                f.setAccessible(true);
                f.set(getNMSClass(), value);
            } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object invoke(String method) {
        try {
            Method m = ReflectionUtil.getNMSClass(nmsClassName).getMethod(method);
            m.setAccessible(true);
            return m.invoke(getNMSClass());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            LOGGER.severe("An error occurred while invoking a method: " + method);
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            Method m = ReflectionUtil.getNMSClass(nmsClassName).getMethod(method, classes.toArray(new Class[0]));
            m.setAccessible(true);
            return m.invoke(getNMSClass(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            LOGGER.severe("An error occurred while invoking a method: " + method);
            LOGGER.severe("With signature: " + ICollectionList.asList(o).map(Object::getClass).map(Class::getCanonicalName).join(", "));
            e.printStackTrace();
            return null;
        }
    }

    public static Class<?> getClassWithoutException(String clazz) {
        try {
            return ReflectionUtil.getNMSClass(clazz);
        } catch (ClassNotFoundException e) { throw new ExceptionInInitializerError(e); }
    }
}
