package xyz.acrylicstyle.nmsapi.shared.minecraft.entity;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.reflector.ForwardMethod;
import xyz.acrylicstyle.mcutil.lang.MCVersion;
import xyz.acrylicstyle.mcutil.mojang.GameProfile;
import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;
import xyz.acrylicstyle.nmsapi.shared.NMSAPIClassLocator;
import xyz.acrylicstyle.nmsapi.shared.VersionMap;
import xyz.acrylicstyle.nmsapi.shared.authlib.AbstractGameProfile;
import xyz.acrylicstyle.nmsapi.shared.minecraft.network.PlayerConnection;

public interface EntityPlayer {
    NMSAPIClassLocator<EntityPlayer> CLASS_LOCATOR = new NMSAPIClassLocator<>("minecraft.entity.EntityPlayer");
    VersionMap<EntityPlayer> VERSION_MAP = VersionMap.getInstance(EntityPlayer.class)
            .defaultsTo(CLASS_LOCATOR.get("v1_8_8"))
            .register(MCVersion.v1_8_8, CLASS_LOCATOR.get("v1_8_8"))
            .register(MCVersion.UNKNOWN, CLASS_LOCATOR.get("v1_8_8"));

    static EntityPlayer getInstance(@NotNull Player player) {
        return VERSION_MAP.getInstance(AbstractNMSAPI.VERSION, player);
    }

    /**
     * Get ping of this player.
     * @return the ping
     */
    @Contract(pure = true)
    int getPing();

    /**
     * Returns the current game profile
     * @return the current profile
     */
    @NotNull
    GameProfile getProfile();

    /**
     * Sets the game profile to the provided profile.
     * @param profile the profile
     */
    void setProfile(@NotNull @ForwardMethod("toNMS") AbstractGameProfile profile);

    @Contract(pure = true)
    @NotNull
    PlayerConnection getPlayerConnection();
}
