package xyz.acrylicstyle.nmsapi.abstracts.minecraft;

import org.apache.commons.lang.Validate;
import org.bukkit.entity.HumanEntity;
import org.jetbrains.annotations.NotNull;
import util.reflect.Ref;
import xyz.acrylicstyle.nmsapi.abstracts.utils.CraftUtils;
import xyz.acrylicstyle.shared.NMSAPI;

public interface EntityHuman extends EntityLiving {
    /**
     * Obtain the instance of EntityHuman.
     * @param entity the entity
     * @return the instance of EntityHuman.
     */
    @NotNull
    static EntityHuman getInstance(@NotNull HumanEntity entity) {
        Validate.notNull(entity, "entity cannot be null");
        return (EntityHuman) Ref.forName(NMSAPI.getClassPrefix() + "EntityHuman").getConstructor(Object.class).newInstance(CraftUtils.getHandle(entity));
    }
}
