package xyz.acrylicstyle.nmsapi.shared.minecraft.entity;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.reflect.RefClass;
import util.reflector.ForwardMethod;
import xyz.acrylicstyle.mcutil.mojang.GameProfile;
import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;
import xyz.acrylicstyle.nmsapi.shared.authlib.AbstractGameProfile;
import xyz.acrylicstyle.nmsapi.shared.craftbukkit.entity.CraftPlayer;
import xyz.acrylicstyle.nmsapi.shared.minecraft.network.PlayerConnection;

public interface EntityPlayer extends Entity {
    RefClass<?> CLASS = AbstractNMSAPI.nms("EntityPlayer");

    @NotNull
    static EntityPlayer getInstance(@NotNull Player player) {
        return CraftPlayer.getInstance(player).getHandle();
    }

    /**
     * Get ping of this player.
     * @return the ping
     */
    @Contract(pure = true)
    int getPing();

    /**
     * Get the locale that the player is using currently.
     * @return the locale
     */
    @Nullable
    String getLocale();

    /**
     * Returns whether the player is currently watching the end poem.
     * @return true if player is viewing credits currently
     */
    boolean isViewingCredits();

    /**
     * Returns the display name for this player.
     * @return the name
     */
    @Nullable
    String getDisplayName();

    /**
     * Set the display name of this player.
     * @param name the display name
     */
    void setDisplayName(@Nullable String name);

    int getInvulnerableTicks();

    long getIdleTimer();

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
