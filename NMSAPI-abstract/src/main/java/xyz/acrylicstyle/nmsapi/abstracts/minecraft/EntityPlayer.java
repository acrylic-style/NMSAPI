package xyz.acrylicstyle.nmsapi.abstracts.minecraft;

import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.reflect.Ref;
import xyz.acrylicstyle.authlib.GameProfile;
import xyz.acrylicstyle.nmsapi.abstracts.craftbukkit.entity.CraftPlayer;
import xyz.acrylicstyle.nmsapi.abstracts.utils.CraftUtils;
import xyz.acrylicstyle.shared.NMSAPI;

public interface EntityPlayer extends EntityHuman {
    Class<?> CLASS = NMSAPI.getClassWithoutException("EntityPlayer");

    /**
     * Obtain the instance of EntityPlayer.
     * @param player the player
     * @return the instance of EntityPlayer.
     */
    @NotNull
    static EntityPlayer getInstance(@NotNull Player player) {
        Validate.notNull(player, "player cannot be null");
        return (EntityPlayer) Ref.forName(NMSAPI.getClassPrefix() + "EntityPlayer").getConstructor(Object.class).newInstance(CraftUtils.getHandle(player));
    }

    /**
     * Kills player.
     */
    void die();

    /**
     * {@inheritDoc}
     * @deprecated unsafe operation (may causes inconsistent state)
     */
    @Deprecated
    @Override
    void remove();

    /**
     * Get the ping of this player
     * @return the ping
     */
    int getPing();

    /**
     * Set the ping of this player
     * @param ping the ping
     */
    void setPing(int ping);

    /**
     * Get the locale of this player
     * @return the locale, like en_US or en_us
     */
    @NotNull
    String getLocale();

    /**
     * Get the player profile, contains skin data etc.
     * @return the profile
     */
    @NotNull
    GameProfile getProfile();

    /**
     * Set the player profile, sets the skin data etc.
     * @param profile the profile
     */
    void setProfile(@NotNull GameProfile profile);

    /**
     * Get the object representation in nms.
     * @return the nms object
     */
    @NotNull
    Object getHandle();

    /**
     * Returns the entity in bukkit.
     * @return the entity
     */
    @NotNull
    CraftPlayer getBukkitEntity();

    /**
     * Returns the name of this player
     * @return the name
     */
    @NotNull
    String getName();

    /**
     * Returns the display name of this player
     * @return the display name of the player
     */
    @NotNull
    String getDisplayName();

    /**
     * Set the display name of this player
     * @param displayName the name displays for players
     */
    void setDisplayName(@NotNull String displayName);

    /**
     * Get the target of compass
     * @return the target of compass
     */
    @Nullable
    Location getCompassTarget();

    /**
     * Set the target of compass
     * @param location the target of compass
     */
    void setCompassTarget(@Nullable Location location);

    /**
     * Get the invulnerable ticks, the ticks when the entity is invulnerable
     * @return the ticks (20 ticks = 1 second)
     */
    int getInvulnerableTicks();

    /**
     * Set the invulnerable ticks, the ticks when the entity is invulnerable
     * @param ticks the ticks (20 ticks = 1 second)
     */
    void setInvulnerableTicks(int ticks);

    /**
     * Resets everything into the initial state.
     */
    void reset();

    /**
     * Returns whether the player is frozen or not
     * @return frozen state
     */
    boolean isFrozen();

    /**
     * Updates the weather locally to this player.
     * @param oldRain
     * @param newRain
     * @param oldThunder
     * @param newThunder
     */
    void updateWeather(float oldRain, float newRain, float oldThunder, float newThunder);

    /**
     * Called when server ticks entity.
     */
    void tick();

    /**
     * Called when server ticks player.
     */
    void playerTick();

    /**
     * @return whether player is allowed to pvp or not
     */
    boolean canPvP();

    /**
     * Closes the inventory that is currently open.
     */
    void closeInventory();

    /**
     * Forces player to update their abilities. (e.g. walk speed)
     */
    void updateAbilities();

    /**
     * @return whether player is spectator or not
     */
    boolean isSpectator();

    /**
     * Returns the IP address of this player
     * @return the IP address
     */
    @NotNull
    String getIP();

    /**
     * Sends the resource pack to the player.
     * @param url the URL of the resource pack
     * @param hash the hash of the resource pack (string length should be <= 40)
     */
    void setResourcePack(String url, String hash);

    /**
     * Resets timer used to feature that will kick player if player is idling.
     */
    void resetIdleTimer();

    /**
     * Returns the time when the player become active. Also known as Idle timer.
     */
    long getLastActiveTime();

    /**
     * Returns the time that is specific to this player.
     * @return the time
     */
    long getPlayerTime();

    /**
     * Get the player weather that is the weather specific to this player.
     * @return the weather
     */
    @Nullable
    WeatherType getPlayerWeather();

    /**
     * Set the player weather
     * @param type the weather that is specific to this player
     * @param plugin whether called by plugin or not (if the weather is not null and plugin is false, it will not work.)
     */
    void setPlayerWeather(@Nullable WeatherType type, boolean plugin);

    /**
     * Resets the player weather that was set previously.
     */
    void resetPlayerWeather();

    /**
     * Updates the weather
     */
    void tickWeather();

    /**
     * Attacks entity.
     * @param entity the entity who will be attacked
     */
    void attack(Entity entity);

    @NotNull
    PlayerConnection getPlayerConnection();
}
