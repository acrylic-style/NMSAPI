package xyz.acrylicstyle.minecraft.v1_12_R1;

import xyz.acrylicstyle.shared.NMSAPI;

public abstract class PathfinderGoal extends NMSAPI {
    protected PathfinderGoal(Object o, String clazz) {
        super(o, clazz);
    }

    protected PathfinderGoal(String clazz, Object... args) {
        super(clazz, args);
    }

    public abstract boolean a();

    public boolean b() {
        return a();
    }

    public boolean g() {
        return true;
    }

    public void c() {}

    public void d() {}

    public void e() {}

    public void a(int paramInt) {
        invoke("a", paramInt);
    }

    public int h() { return field("a"); }
}
