package xyz.acrylicstyle.nmsapi.shared.craftbukkit.entity;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.reflector.CastTo;
import xyz.acrylicstyle.mcutil.lang.MCVersion;
import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;
import xyz.acrylicstyle.nmsapi.shared.NMSAPIClassLocator;
import xyz.acrylicstyle.nmsapi.shared.VersionMap;
import xyz.acrylicstyle.nmsapi.shared.minecraft.entity.EntityPlayer;

public interface CraftPlayer extends Player {
    NMSAPIClassLocator<CraftPlayer> CLASS_LOCATOR = new NMSAPIClassLocator<>("craftbukkit.entity.CraftPlayer");
    VersionMap<CraftPlayer> VERSION_MAP = VersionMap.getInstance(CraftPlayer.class)
            .defaultsTo(CLASS_LOCATOR.get("v1_8_8"))
            .register(MCVersion.v1_8_8, CLASS_LOCATOR.get("v1_8_8"))
            .register(MCVersion.UNKNOWN, CLASS_LOCATOR.get("v1_8_8"));

    static CraftPlayer getInstance(@NotNull Player player) {
        return VERSION_MAP.getInstance(AbstractNMSAPI.VERSION, player);
    }

    @Contract(pure = true)
    @NotNull
    @CastTo(EntityPlayer.class)
    EntityPlayer getHandle();
}
