package xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.entity;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.reflect.RefClass;
import util.reflector.CastTo;
import util.reflector.FieldGetter;
import util.reflector.FieldSetter;
import util.reflector.ForwardMethod;
import util.reflector.TransformParam;
import xyz.acrylicstyle.mcutil.mojang.GameProfile;
import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;
import xyz.acrylicstyle.nmsapi.shared.authlib.AbstractGameProfile;
import xyz.acrylicstyle.nmsapi.shared.authlib.ComplexGameProfile;
import xyz.acrylicstyle.nmsapi.v1_8_8.craftbukkit.entity.CraftPlayer;
import xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.network.PlayerConnection;

public interface EntityPlayer extends xyz.acrylicstyle.nmsapi.shared.minecraft.entity.EntityPlayer {
    RefClass<?> CLASS = AbstractNMSAPI.nms("EntityPlayer");

    @NotNull
    static EntityPlayer getInstance(@NotNull Player player) { return CraftPlayer.getInstance(player).getHandle(); }

    @Contract(pure = true)
    @Override
    int getPing();

    /**
     * Set ping of this player. Please note that value change that was made with this method is temporary.
     * @param ping the ping
     */
    void setPing(int ping);

    /**
     * Get the locale that is using currently.
     * @return the locale
     */
    @Nullable
    String getLocale();

    @FieldGetter("viewingCredits")
    boolean isViewingCredits();

    /**
     * Get the display name of this player. Might return null. (not tested yet)
     * @return the display name
     */
    @Nullable
    String getDisplayName();

    /**
     * Set the display name of this player.
     * @param name the display name
     */
    void setDisplayName(@Nullable String name);

    /**
     * Get the current target of the compass.
     * @return the location
     */
    @Nullable
    Location getCompassTarget();

    @FieldGetter("invulnerableTicks")
    int getInvulnerableTicks();

    @FieldSetter("invulnerableTicks")
    void setInvulnerableTicks(int invulnerableTicks);

    @FieldGetter("bT")
    long getIdleTimer();

    @FieldSetter("bT")
    void setIdleTimer(long idleTimer);

    @CastTo(value = ComplexGameProfile.class, createInstance = true)
    @FieldGetter("bH")
    @NotNull
    @Override
    GameProfile getProfile();

    @FieldSetter("bH")
    @Override
    void setProfile(@NotNull @ForwardMethod("toNMS") AbstractGameProfile profile);

    /**
     * Sets the game profile to the provided profile.
     * @param profile the profile
     */
    @FieldSetter("bH")
    void setProfile(@NotNull @TransformParam ComplexGameProfile.Refl profile);

    @FieldGetter("playerConnection")
    @CastTo(PlayerConnection.class)
    @Contract(pure = true)
    @NotNull
    @Override
    PlayerConnection getPlayerConnection();
}
