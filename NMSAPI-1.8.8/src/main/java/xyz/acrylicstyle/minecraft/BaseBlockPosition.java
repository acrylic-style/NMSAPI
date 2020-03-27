package xyz.acrylicstyle.minecraft;

import org.jetbrains.annotations.NotNull;
import util.CollectionList;
import util.ICollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BaseBlockPosition extends NMSAPI implements Comparable<BaseBlockPosition> {
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

    public String toString() {
        return (String) invoke("toString");
    }

    protected BaseBlockPosition(String clazz, Object... params) {
        super(clazz, params);
    }

    protected BaseBlockPosition(Object instance, String clazz) {
        super(instance, clazz);
    }

    public BaseBlockPosition(Object o) {
        super(o, "BaseBlockPosition");
    }

    public BaseBlockPosition(int i1, int i2, int i3) {
        super("BaseBlockPosition", i1, i2, i3);
    }

    public BaseBlockPosition(double double1, double double2, double double3) {
        super("BaseBlockPosition", double1, double2, double3);
    }

    @Override
    public int compareTo(@NotNull BaseBlockPosition o) {
        return g(o);
    }
}
