package xyz.acrylicstyle.nmsapi.v1_8_8.craftbukkit.entity;

import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import util.reflector.Reflector;
import util.reflector.ReflectorHandler;

public interface CraftEntity extends xyz.acrylicstyle.nmsapi.shared.craftbukkit.entity.CraftEntity, xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.entity.Entity {
    @NotNull
    static CraftEntity getInstance(@NotNull Entity entity) {
        return Reflector.newReflector(null, CraftEntity.class, new ReflectorHandler(xyz.acrylicstyle.nmsapi.shared.craftbukkit.entity.CraftEntity.CLASS.getClazz(), entity));
    }
}
