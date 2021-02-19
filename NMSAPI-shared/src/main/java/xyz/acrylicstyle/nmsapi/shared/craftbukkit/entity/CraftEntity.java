package xyz.acrylicstyle.nmsapi.shared.craftbukkit.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.reflect.RefClass;
import util.reflector.CastTo;
import util.reflector.ForwardMethod;
import util.reflector.ReflectorOption;
import xyz.acrylicstyle.mcutil.lang.MCVersion;
import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;
import xyz.acrylicstyle.nmsapi.shared.NMSAPIClassLocator;
import xyz.acrylicstyle.nmsapi.shared.VersionMap;
import xyz.acrylicstyle.nmsapi.shared.minecraft.entity.Entity;

import java.util.Set;

public interface CraftEntity extends org.bukkit.entity.Entity {
    RefClass<?> CLASS = AbstractNMSAPI.bukkit("entity.CraftEntity");
    NMSAPIClassLocator<CraftEntity> CLASS_LOCATOR = new NMSAPIClassLocator<>("craftbukkit.entity.CraftEntity");
    VersionMap<CraftEntity> VERSION_MAP = VersionMap.getInstance(CraftEntity.class)
            .defaultsTo(CLASS_LOCATOR.get("v1_8_8"))
            .register(MCVersion.v1_8_8, CLASS_LOCATOR.get("v1_8_8"))
            .register(MCVersion.UNKNOWN, CLASS_LOCATOR.get("v1_8_8"));

    static CraftEntity getInstance(@NotNull org.bukkit.entity.Entity entity) {
        return VERSION_MAP.getInstance(AbstractNMSAPI.VERSION, entity);
    }

    /**
     * Returns a scoreboard tags for this entity.
     * @return tags, null if your bukkit version is < 1.10.2
     */
    @Nullable
    @ReflectorOption(errorOption = ReflectorOption.ErrorOption.RETURN_NULL)
    Set<String> getScoreboardTags();

    @ForwardMethod("getHandle")
    @NotNull
    @CastTo(Entity.class)
    Entity getHandle();
}
