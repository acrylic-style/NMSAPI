package xyz.acrylicstyle.minecraft.v1_12_R1;

import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

public class MovingObjectPosition extends NMSAPI {
    public MovingObjectPosition() {
        super("MovingObjectPosition");
    }

    public MovingObjectPosition(Object o) {
        super(o, "MovingObjectPosition");
    }

    public enum EnumMovingObjectType {
        MISS, BLOCK, ENTITY;

        @SuppressWarnings({"rawtypes", "unchecked"})
        public Enum getNMSClass() {
            try {
                return Enum.valueOf((Class<Enum>) ReflectionUtil.getNMSClass("MovingObjectPosition.EnumMovingObjectType"), this.name());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public MovingObjectPosition(Vec3D vec3D, EnumDirection enumDirection, BlockPosition blockPosition) {
        super("MovingObjectPosition", vec3D.getNMSClass(), enumDirection.toNMSEnum(), blockPosition.getNMSClass());
    }

    public MovingObjectPosition(Entity entity) {
        super("MovingObjectPosition", entity.getNMSClass());
    }

    public MovingObjectPosition(EnumMovingObjectType enumMovingObjectType, Vec3D vec3D, EnumDirection enumDirection, BlockPosition blockPosition) {
        super("MovingObjectPosition", enumMovingObjectType.getNMSClass(), vec3D.getNMSClass(), enumDirection.toNMSEnum(), blockPosition.getNMSClass());
    }

    public MovingObjectPosition(Entity entity, Vec3D vec3D) {
        super("MovingObjectPosition", entity.getNMSClass(), vec3D.getNMSClass());
    }

    public BlockPosition a() { return (BlockPosition) invoke("a"); }

    public String toString() {
        return (String) invoke("toString");
    }
}
