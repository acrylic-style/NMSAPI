package xyz.acrylicstyle.minecraft.v1_8_R1;

public class EntityHuman extends EntityLiving implements xyz.acrylicstyle.nmsapi.abstracts.minecraft.EntityHuman {
    public EntityHuman(Object o) { this(o, "EntityHuman"); }

    public EntityHuman(String clazz) {
        super(clazz);
    }

    public EntityHuman(Object o, String clazz) {
        super(o, clazz);
    }

    public EntityHuman(String clazz, Object... args) {
        super(clazz, args);
    }
}
