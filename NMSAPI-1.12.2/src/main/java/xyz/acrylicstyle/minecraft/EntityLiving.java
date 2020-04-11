package xyz.acrylicstyle.minecraft;

public class EntityLiving extends Entity {
    public EntityLiving(Object o) {
        super(o);
    }

    protected EntityLiving(Object o, String clazz) { super(o, clazz); }

    protected EntityLiving(String clazz, Object... args) { super(clazz, args); }
}
