package xyz.acrylicstyle.nmsapi.minecraft.v1_8_8.entity;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.reflect.RefClass;
import util.reflector.FieldGetter;
import util.reflector.FieldSetter;
import xyz.acrylicstyle.nmsapi.craftbukkit.v1_8_8.entity.CraftPlayer;
import xyz.acrylicstyle.nmsapi.shared.NMSAPI;

public interface EntityPlayer {
    RefClass<?> CLASS = NMSAPI.getRefClass(NMSAPI.Type.NMS, "EntityPlayer");

    @NotNull
    static EntityPlayer getInstance(@NotNull Player player) { return CraftPlayer.getInstance(player).getHandle(); }

    /**
     * Get ping of this player.
     * @return the ping
     */
    @Contract(pure = true)
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
}
