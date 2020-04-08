package xyz.acrylicstyle.minecraft;

import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.shared.NMSAPI;

public class Vec3D extends NMSAPI {
    public final double x;
    public final double y;
    public final double z;

    public Vec3D(double d1, double d2, double d3) {
        super("Vec3D", d1, d2, d3);
        this.x = (double) getField("a");
        this.y = (double) getField("b");
        this.z = (double) getField("c");
    }

    public Vec3D(BaseBlockPosition baseBlockPosition) {
        super("Vec3D", baseBlockPosition.getNMSClass());
        this.x = (double) getField("a");
        this.y = (double) getField("b");
        this.z = (double) getField("c");
    }

    public Vec3D(Object o) {
        super(o, "Vec3D");
        this.x = (double) getField("a");
        this.y = (double) getField("b");
        this.z = (double) getField("c");
    }

    public static Vec3D newInstance(@Nullable Object o) {
        return o == null ? new Vec3D(0, 0, 0) : new Vec3D(o);
    }

    public Vec3D a() {
        return new Vec3D(invoke("a"));
    }

    public double b(Vec3D vec3D) {
        return (double) invoke("b", vec3D.getNMSClass());
    }

    public Vec3D d(Vec3D vec3D) {
        return new Vec3D(invoke("d", vec3D.getNMSClass()));
    }

    public Vec3D a(double d1, double d2, double d3) {
        return new Vec3D(invoke("a", d1, d2, d3));
    }

    public Vec3D e(Vec3D vec3D) {
        return new Vec3D(invoke("e", vec3D.getNMSClass()));
    }

    public Vec3D add(double d1, double d2, double d3) {
        return new Vec3D(invoke("add", d1, d2, d3));
    }

    public double distanceSquared(Vec3D vec3D) {
        return (double) invoke("distanceSquared", vec3D.getNMSClass());
    }

    public double b() {
        return (double) invoke("b");
    }

    public Vec3D a(Vec3D vec3D, double d) {
        return new Vec3D(invoke("a", vec3D.getNMSClass(), d));
    }

    public Vec3D b(Vec3D vec3D, double d) {
        return new Vec3D(invoke("b", vec3D.getNMSClass(), d));
    }

    public Vec3D c(Vec3D vec3D, double d) {
        return new Vec3D(invoke("c", vec3D.getNMSClass(), d));
    }

    @Override
    public String toString() {
        return (String) invoke("toString");
    }

    public Vec3D a(float f) {
        return new Vec3D(invoke("a", f));
    }

    public Vec3D b(float f) {
        return new Vec3D(invoke("b", f));
    }
}
