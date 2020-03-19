package xyz.acrylicstyle.minecraft;

import org.jetbrains.annotations.NotNull;
import util.CollectionList;
import util.ICollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BaseBlockPosition implements Comparable<BaseBlockPosition> {
    public static final BaseBlockPosition ZERO = new BaseBlockPosition(0, 0, 0);

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object o) {
        return (boolean) invoke("equals", o);
    }

    public int hashCode() {
        return (int) invoke("hashCode");
    }

    public int g(BaseBlockPosition baseBlockPosition) {
        return (int) invoke("g", baseBlockPosition.getNMSClass());
    }

    public int getX() {
        return (int) getField("a");
    }

    public int getY() {
        return (int) getField("c");
    }

    public int getZ() {
        return (int) getField("d");
    }

    public BaseBlockPosition d(BaseBlockPosition baseBlockPosition) {
        return new BaseBlockPosition(invoke("d", baseBlockPosition.getNMSClass()));
    }

    public double c(double d1, double d2, double d3) {
        return (double) invoke("c", d1, d2, d3);
    }

    public double d(double d1, double d2, double d3) {
        return (double) invoke("d", d1, d2, d3);
    }

    public double i(BaseBlockPosition baseBlockPosition) {
        return c(baseBlockPosition.getX(), baseBlockPosition.getY(), baseBlockPosition.getZ());
    }

    public double h(int i1, int i2, int i3) {
        return (double) invoke("h", i1, i2, i3);
    }

    public double distanceSquared(double x, double y, double z) {
        return (double) invoke("distanceSquared", x, y, z);
    }

    public double g(double x, double y, double z) {
        return (double) invoke("g", x, y, z);
    }

    public double n(BaseBlockPosition baseBlockPosition) {
        return distanceSquared(baseBlockPosition.getX(), baseBlockPosition.getY(), baseBlockPosition.getZ());
    }

    public String toString() {
        return (String) invoke("toString");
    }

    // NMSAPI start
    private Object o;

    public BaseBlockPosition(Object o) {
        this.o = o;
    }

    public BaseBlockPosition(int i1, int i2, int i3) {
        try {
            this.o = ReflectionUtil.getNMSClass("BaseBlockPosition")
                    .getConstructor(int.class, int.class, int.class)
                    .newInstance(i1, i2, i3);
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public BaseBlockPosition(double double1, double double2, double double3) {
        try {
            this.o = ReflectionUtil.getNMSClass("BaseBlockPosition")
                    .getConstructor(double.class, double.class, double.class)
                    .newInstance(double1, double2, double3);
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getNMSClass() {
        try {
            if (o.getClass().getCanonicalName().equals(ReflectionUtil.getNMSClass("BaseBlockPosition").getCanonicalName())) return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("BaseBlockPosition"), getNMSClass(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("BaseBlockPosition")
                    .getMethod(method)
                    .invoke(getNMSClass());
        } catch (NoSuchMethodException e) {
            try {
                return ReflectionUtil.getNMSClass("BaseBlockPosition")
                        .getSuperclass()
                        .getMethod(method)
                        .invoke(getNMSClass());
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
            return ReflectionUtil.getNMSClass("BaseBlockPosition")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getNMSClass(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setField(String field, Object value) {
        try {
            Field f = ReflectionUtil.getNMSClass("BaseBlockPosition").getDeclaredField(field);
            f.setAccessible(true);
            f.set(getNMSClass(), value);
        } catch (NoSuchFieldException e) {
            try {
                Field f = ReflectionUtil.getNMSClass("BaseBlockPosition").getSuperclass().getDeclaredField(field);
                f.setAccessible(true);
                f.set(getNMSClass(), value);
            } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(@NotNull BaseBlockPosition o) {
        return g(o);
    }
    // NMSAPI end
}
