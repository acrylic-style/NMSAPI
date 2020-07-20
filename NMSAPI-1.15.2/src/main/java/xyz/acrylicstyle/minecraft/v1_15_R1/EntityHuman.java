package xyz.acrylicstyle.minecraft.v1_15_R1;

public class EntityHuman extends EntityLiving implements xyz.acrylicstyle.nmsapi.abstracts.minecraft.EntityHuman {
    public EntityHuman(String clazz) {
        super(clazz);
    }

    public EntityHuman(Object o, String clazz) {
        super(o, clazz);
    }

    public EntityHuman(String clazz, Object... args) {
        super(clazz, args);
    }

    public EntityHuman(Object o) {
        super(o, "EntityHuman");
    }
}
