package xyz.acrylicstyle.shared;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.CollectionList;
import util.ICollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class NMSAPI {
    public static final Map<Class<?>, Class<?>> PRIMITIVES = new HashMap<>();
    private static final Logger LOGGER = Logger.getLogger("NMSAPI");
    protected final String nmsClassName;

    static {
        PRIMITIVES.put(Integer.class, int.class);
        PRIMITIVES.put(Double.class, double.class);
        PRIMITIVES.put(Float.class, float.class);
        PRIMITIVES.put(Character.class, char.class);
        PRIMITIVES.put(Boolean.class, boolean.class);
        PRIMITIVES.put(Byte.class, byte.class);
        PRIMITIVES.put(Short.class, short.class);
        PRIMITIVES.put(Object.class, Object.class);
    }

    /**
     * Set NMS object. This does not call constructor and it doesn't check types.
     * @param o Object
     * @param nmsClassName NMS Class name
     */
    @Contract("null, _ -> fail; !null, null -> fail")
    protected NMSAPI(Object o, String nmsClassName) {
        if (o == null) throw new IllegalArgumentException("Object is null!");
        if (nmsClassName == null) throw new IllegalArgumentException("NMS Class name cannot be null");
        this.o = o;
        this.nmsClassName = nmsClassName;
    }

    /**
     * Constructs NMSAPI and calls NMS class's constructor.
     * @param nmsClassName NMS class name (target)
     * @param o Constructor args
     */
    protected NMSAPI(@NotNull String nmsClassName, Object... o) {
        this.nmsClassName = nmsClassName;
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(PRIMITIVES.containsKey(o1.getClass()) ? PRIMITIVES.get(o1.getClass()) : o1.getClass());
            this.o = ReflectionUtil.getNMSClass(nmsClassName)
                    .getConstructor(classes.toArray(new Class[0]))
                    .newInstance(o);
        } catch (Exception e) {
            try {
                CollectionList<Class<?>> classes = new CollectionList<>();
                for (Object o1 : o) classes.add(PRIMITIVES.containsKey(o1.getClass()) ? PRIMITIVES.get(o1.getClass()) : o1.getClass().getSuperclass());
                this.o = ReflectionUtil.getNMSClass(nmsClassName)
                        .getConstructor(classes.toArray(new Class[0]))
                        .newInstance(o);
            } catch (Exception ex2) {
                e.printStackTrace();
                ex2.printStackTrace();
            }
        }
    }

    protected Object o;

    public Object getNMSClass() {
        try {
            if (o == null) {
                LOGGER.severe("Object is null! Dumping a thread stack");
                Thread.dumpStack();
                return true;
            }
            if (o.getClass().getCanonicalName().equalsIgnoreCase(ReflectionUtil.getNMSClass(nmsClassName).getCanonicalName())) return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final Object getHandle() { return getNMSClass(); }

    public Object getField(String field) {
        if (checkState()) return null;
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass(nmsClassName), getNMSClass(), field);
        } catch (Exception e) {
            LOGGER.severe("An error occurred while getting a field: " + field);
            e.printStackTrace();
            return null;
        }
    }

    protected boolean checkState() {
        if (nmsClassName == null) {
            LOGGER.severe("NMS class name is null! Dumping a thread stack");
            Thread.dumpStack();
            return true;
        }
        if (o == null) {
            LOGGER.severe("Object is null! Dumping a thread stack");
            Thread.dumpStack();
            return true;
        }
        if (getNMSClass() == null) {
            LOGGER.severe("NMS object is null! Dumping a thread stack");
            Thread.dumpStack();
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public final <T> T field(String f) {
        return (T) getField(f);
    }

    public void setField(String field, Object value) {
        if (checkState()) return;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object invoke(String method) {
        if (checkState()) return null;
        try {
            Method m = ReflectionUtil.getNMSClass(nmsClassName).getMethod(method);
            m.setAccessible(true);
            return m.invoke(getNMSClass());
        } catch (Exception e) {
            LOGGER.severe("An error occurred while invoking a method: " + method);
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        if (checkState()) return null;
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(PRIMITIVES.containsKey(o1.getClass()) ? PRIMITIVES.get(o1.getClass()) : o1.getClass());
            Method m = ReflectionUtil.getNMSClass(nmsClassName).getMethod(method, classes.toArray(new Class[0]));
            m.setAccessible(true);
            return m.invoke(getNMSClass(), o);
        } catch (Exception e) {
            LOGGER.severe("An error occurred while invoking a method: " + method);
            LOGGER.severe("With signature: " + ICollectionList.asList(o).map(Object::getClass).map(Class::getCanonicalName).join(", "));
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke1(String method, Class<?> clazz, Object o) {
        return invoke10(method, o, clazz);
    }

    public Object invoke1(String method, String sClazz, Object o) {
        Class<?> clazz = getClassWithoutException(sClazz);
        return invoke10(method, o, clazz);
    }

    private Object invoke10(String method, Object o, Class<?> clazz) {
        if (checkState()) return null;
        try {
            Method m = ReflectionUtil.getNMSClass(nmsClassName).getMethod(method, clazz);
            m.setAccessible(true);
            return m.invoke(getNMSClass(), o);
        } catch (Exception e) {
            LOGGER.severe("An error occurred while invoking a method: " + method);
            LOGGER.severe("With signature: " + clazz.getCanonicalName());
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke1(String method, String sClazz1, String sClazz2, Object o1, Object o2) {
        Class<?> clazz1 = getClassWithoutException(sClazz1);
        Class<?> clazz2 = getClassWithoutException(sClazz2);
        return invoke11(method, o1, o2, clazz1, clazz2);
    }

    private Object invoke11(String method, Object o1, Object o2, Class<?> clazz1, Class<?> clazz2) {
        if (checkState()) return null;
        try {
            Method m = ReflectionUtil.getNMSClass(nmsClassName).getMethod(method, clazz1, clazz2);
            m.setAccessible(true);
            return m.invoke(getNMSClass(), o1, o2);
        } catch (Exception e) {
            LOGGER.severe("An error occurred while invoking a method: " + method);
            LOGGER.severe("With signature: " + clazz1.getCanonicalName() + ", " + clazz2.getCanonicalName());
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke1(String method, Class<?> clazz1, Class<?> clazz2, Object o1, Object o2) {
        return invoke11(method, o1, o2, clazz1, clazz2);
    }

    public static Class<?> getClassWithoutException(String clazz) {
        try {
            return ReflectionUtil.getNMSClass(clazz);
        } catch (ClassNotFoundException e) { throw new ExceptionInInitializerError(e); }
    }
}
