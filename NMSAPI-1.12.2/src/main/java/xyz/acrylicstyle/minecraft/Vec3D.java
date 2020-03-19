package xyz.acrylicstyle.minecraft;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.shared.NMSAPI;

public class Vec3D extends NMSAPI {
    public static final Vec3D a = new Vec3D(0.0D, 0.0D, 0.0D);
    public static final Vec3D ZERO = a; // NMSAPI

    public Vec3D(@NotNull Object o) {
        super(o, "Vec3D");
    }

    public Vec3D(double paramDouble1, double paramDouble2, double paramDouble3) {
        super("Vec3D", paramDouble1, paramDouble2, paramDouble3);
    }

    public Vec3D(@NotNull BaseBlockPosition paramBaseBlockPosition) {
        this(paramBaseBlockPosition.getX(), paramBaseBlockPosition.getY(), paramBaseBlockPosition.getZ());
    }

    public Vec3D a(@NotNull Vec3D paramVec3D) {
        return new Vec3D(invoke("a", paramVec3D.getNMSClass()));
    }

    public double b(@NotNull Vec3D paramVec3D) {
        return (double) invoke("b", paramVec3D.getNMSClass());
    }

    public Vec3D d(Vec3D paramVec3D) {
        return new Vec3D(invoke("d", paramVec3D.getNMSClass()));
    }

    public Vec3D a(double paramDouble1, double paramDouble2, double paramDouble3) {
        return add(-paramDouble1, -paramDouble2, -paramDouble3);
    }

    public Vec3D e(@NotNull Vec3D paramVec3D) {
        return add(paramVec3D.getX(), paramVec3D.getY(), paramVec3D.getZ());
    }

    public Vec3D add(double paramDouble1, double paramDouble2, double paramDouble3) {
        return new Vec3D(invoke("add", paramDouble1, paramDouble2, paramDouble3));
    }

    public double f(Vec3D paramVec3D) {
        return (double) invoke("f", paramVec3D.getNMSClass());
    }

    public double distanceSquared(Vec3D vec3D) {
        return (double) invoke("distanceSquared", vec3D.getNMSClass());
    }

    public double c(double double1, double double2, double double3) {
        return (double) invoke("c", double1, double2, double3);
    }

    public Vec3D a(double paramDouble) {
        return new Vec3D(invoke("a", paramDouble));
    }

    public Vec3D multiply(double paramDouble) { return a(paramDouble); }

    public double b() {
        return (double) invoke("b");
    }

    @Nullable
    public Vec3D a(@NotNull Vec3D paramVec3D, double paramDouble) {
        return new Vec3D(invoke("a", paramVec3D.getNMSClass(), paramDouble));
    }

    @Nullable
    public Vec3D b(@NotNull Vec3D paramVec3D, double paramDouble) {
        return new Vec3D(invoke("b", paramVec3D.getNMSClass(), paramDouble));
    }

    @Nullable
    public Vec3D c(@NotNull Vec3D paramVec3D, double paramDouble) {
        return new Vec3D(invoke("c", paramVec3D.getNMSClass(), paramDouble));
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object paramObject) {
        return (boolean) invoke("equals", paramObject);
    }

    public int hashCode() {
        return (int) invoke("hashCode");
    }

    public String toString() {
        return (String) invoke("toString");
    }

    public Vec3D a(float paramFloat) {
        return new Vec3D(invoke("a", paramFloat));
    }

    public Vec3D b(float paramFloat) {
        return new Vec3D(invoke("b", paramFloat));
    }

    public double getX() { return (double) getField("x"); }

    public double getY() { return (double) getField("y"); }

    public double getZ() { return (double) getField("z"); }
}
