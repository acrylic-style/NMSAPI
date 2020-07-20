package xyz.acrylicstyle.minecraft.v1_12_R1;

public class EntityHuman extends EntityLiving implements xyz.acrylicstyle.nmsapi.abstracts.minecraft.EntityHuman {
    public EntityHuman(Object o) {
        this(o, "EntityHuman");
    }

    protected EntityHuman(Object o, String clazz) {
        super(o, clazz);
    }

    protected EntityHuman(String clazz, Object... args) {
        super(clazz, args);
    }
}
