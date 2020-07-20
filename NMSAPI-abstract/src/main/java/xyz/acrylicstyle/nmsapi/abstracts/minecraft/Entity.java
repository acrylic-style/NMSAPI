package xyz.acrylicstyle.nmsapi.abstracts.minecraft;

import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.reflect.Ref;
import xyz.acrylicstyle.nmsapi.abstracts.craftbukkit.entity.CraftEntity;
import xyz.acrylicstyle.nmsapi.abstracts.utils.CraftUtils;
import xyz.acrylicstyle.shared.NMSAPI;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public interface Entity extends ICommandListener {
    Class<?> CLASS = NMSAPI.getClassWithoutException("Entity");

    /**
     * Obtain the instance of Entity.
     * @param entity the entity
     * @return the instance of Entity.
     */
    @NotNull
    static Entity getInstance(@NotNull Entity entity) {
        Validate.notNull(entity, "entity cannot be null");
        return (Entity) Ref.forName(NMSAPI.getClassPrefix() + "Entity").getConstructor(Object.class).newInstance(CraftUtils.getHandle(entity));
    }

    /**
     * Returns the entity id
     * @return the id
     */
    int getId();

    /**
     * Returns the passenger of this entity.<br />
     * May be null if entity has no passenger.<br />
     * This method might throw NoSuchElementException if
     * the running minecraft version does not support this feature.<br />
     * In this case, use {@link #getPassengers()}.
     * @return the passenger
     */
    @Nullable
    Entity getPassenger() throws NoSuchElementException;

    @NotNull
    List<Entity> getPassengers();

    /**
     * Returns the vehicle that this entity is riding on.
     * @return the vehicle
     */
    @Nullable
    Entity getVehicle();

    /**
     * @return whether this entity is attached to the player
     */
    boolean isAttachedToPlayer();

    /**
     * Get the last X position of the player.
     * @return the last X position
     */
    double getLastX();

    /**
     * Get the last Y position of the player.
     * @return the last Y position
     */
    double getLastY();

    /**
     * Get the last Z position of the player.
     * @return the last Z position
     */
    double getLastZ();

    /**
     * Get the last yaw.
     * @return the last yaw
     */
    float getLastYaw();

    /**
     * Get the last pitch
     * @return the last pitch
     */
    float getLastPitch();

    /**
     * Get the last location of the player.
     * @return the last location
     */
    @NotNull
    default Location getLastLocation() {
        return new Location(getBukkitWorld(), getLastX(), getLastY(), getLastZ(), getLastYaw(), getLastPitch());
    }

    /**
     * Get the current X position of the player.
     * @return the current X position
     */
    double getX();

    /**
     * Get the current Y position of the player.
     * @return the current Y position
     */
    double getY();

    /**
     * Get the current Z position of the player.
     * @return the current Z position
     */
    double getZ();

    /**
     * Get the current yaw.
     * @return the current yaw
     */
    float getYaw();

    /**
     * Get the current pitch
     * @return the current pitch
     */
    float getPitch();

    /**
     * Get the current location of the player.
     * @return the current location
     */
    @NotNull
    default Location getLocation() {
        return new Location(getBukkitWorld(), getX(), getY(), getZ(), getYaw(), getPitch());
    }

    /**
     * Get the X motion.
     * @return the X motion
     */
    double getMotionX();

    /**
     * Get the Y motion.
     * @return the Y motion
     */
    double getMotionY();

    /**
     * Get the Z motion.
     * @return the Z motion
     */
    double getMotionZ();

    /**
     * Get the velocity (motion) of the player.
     * @return the velocity
     */
    @NotNull
    default Vector getVelocity() {
        return new Vector(getMotionX(), getMotionY(), getMotionZ());
    }

    /**
     * @return whether the entity is on the ground or not
     */
    boolean isOnGround();

    /**
     * Get the current fall distance.
     * @return the fall distance
     */
    float getFallDistance();

    /**
     * Get the width of this entity.
     * @return the width, 0 if not supported
     */
    float getWidth();

    /**
     * Get the length (height) of this entity.
     * @return the height, 0 if not supported
     */
    float getLength();

    /**
     * Get the ticks lived after the entity was spawned.
     * @return the ticks
     */
    int getTicksLived();

    /**
     * Set athe ticks lived after the entity was spawned.
     * @param ticksLived the ticks
     */
    void setTicksLived(int ticksLived);

    /**
     * Get the max fire ticks.
     * @return the max fire ticks
     */
    int getMaxFireTicks();

    /**
     * Set the max fire ticks.
     * @param ticks ticks
     * @throws UnsupportedOperationException if current environment does not support this feature
     */
    void setMaxFireTicks(int ticks) throws UnsupportedOperationException;

    /**
     * Get the current fire ticks.
     * @return the current fire ticks
     */
    int getFireTicks();

    /**
     * Set the fire ticks.
     * @param fireTicks ticks
     */
    void setFireTicks(int fireTicks);

    /**
     * @return whether the entity is in water or not
     */
    boolean isInWater();

    /**
     * Get the current no damage (invulnerable) ticks.
     * @return the no damage ticks
     */
    int getNoDamageTicks();

    /**
     * @return whether the entity is fireproof (immune to the fire)
     */
    boolean isFireProof();

    /**
     * Get the portal cooldown ticks.
     * @return the ticks
     */
    int getPortalCooldown();

    /**
     * Get the dimension that entity is located at.
     * @return the dimension (0 = overworld, 1 = nether, -1 = the end)
     */
    int getDimension();

    /**
     * @return whether the entity is invulnerable
     */
    boolean isInvulnerable();

    /**
     * Get the unique ID of this entity.
     * @return the unique ID
     */
    @NotNull
    UUID getUniqueId();

    /**
     * @return whether this entity is valid
     */
    boolean isValid();

    /**
     * @return whether added to chunk (spawned) or not, or always false if current environment does not support this feature
     */
    boolean isAddedToChunk();

    /**
     * @return whether this entity was spawned from the mob spawner, or always false if current environment does not support this feature
     */
    boolean isFromMobSpawner();

    /**
     * Get the entity count that is colliding with this entity.
     * @return the entity count that is colliding, can be 0 if current environment does not support this feature
     */
    int getCollisions();

    /**
     * Kills entity, and mark entity for removal.
     */
    void die();

    /**
     * Set entity on fire for the specified ticks.
     * @param ticks fire ticks
     */
    void setOnFire(int ticks);

    /**
     * Set fire ticks to 0.
     */
    void extinguish();

    /**
     * Mark entity for removal.
     */
    void remove();

    /**
     * Move entity to the specified location.
     * @param x the x location
     * @param y the y location
     * @param z the z location
     */
    void move(double x, double y, double z);

    /**
     * Get the sound that will be played when the entity swims.
     * @throws UnsupportedOperationException if this method is not supported on current environment
     * @return the swim sound
     */
    @NotNull
    String getSwimSound() throws UnsupportedOperationException;

    /**
     * Plays sound with specified sound, volume, and pitch
     * @param sound the sound that will be played
     * @param volume the volume
     * @param pitch the pitch
     * @throws UnsupportedOperationException if this method is not supported on current environment
     */
    void makeSound(@NotNull String sound, float volume, float pitch) throws UnsupportedOperationException;

    /**
     * Burns entity with specified damage, if entity isn't fireproof.
     * @param damage the damage that will be deal'd
     */
    void burn(float damage);

    /**
     * Set the location of this entity
     * @param x the x location
     * @param y the y location
     * @param z the z location
     * @param yaw the yaw
     * @param pitch the pitch
     */
    void setLocation(double x, double y, double z, float yaw, float pitch);

    /**
     * Set the location of this entity
     * @param x the x location
     * @param y the y location
     * @param z the z location
     * @param yaw the yaw
     * @param pitch the pitch
     */
    void setPositionRotation(double x, double y, double z, float yaw, float pitch);

    /**
     * Returns the distance between the specified location.<br />
     * Returns wrong value if measuring between different world.
     * @param x the x location
     * @param y the y location
     * @param z the z location
     * @return the distance between specified location
     */
    default double distance(double x, double y, double z) {
        double d3 = this.getX() - x;
        double d4 = this.getY() - y;
        double d5 = this.getZ() - z;
        return Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
    }

    /**
     * Returns the squared distance between another entity.
     * @param entity the another entity
     * @return the squared distance
     */
    double distanceSquared(@NotNull Entity entity);

    void collide(@NotNull Entity entity);

    /**
     * Damages entity with specified damage source and damage value.
     * @param damageSource the damage source
     * @param damage the damage that will be dealed to the entity
     * @return whether succeeded or not
     */
    boolean damageEntity(DamageSource damageSource, float damage);

    /**
     * @return whether the entity is alive (not dead)
     */
    boolean isAlive();

    /**
     * Get the entity represented in bukkit.
     * @return the bukkit entity
     */
    @NotNull
    CraftEntity getBukkitEntity();

    /**
     * Mount (ride) to specified entity.
     * @param entity the vehicle, null to remove
     */
    void mount(@Nullable Entity entity);

    /**
     * @return whether burning or not
     */
    boolean isBurning();

    /**
     * @return whether this entity has vehicle or not
     */
    boolean hasVehicle();

    /**
     * @return whether this entity is sneaking
     */
    boolean isSneaking();

    /**
     * Set whether entity is sneaking or not
     * @param flag whether sneaking or not
     */
    void setSneaking(boolean flag);

    /**
     * @return whether this entity is sprinting
     */
    boolean isSprinting();

    /**
     * Set whether entity is sprinting or not
     * @param flag whether sprinting or not
     */
    void setSprinting(boolean flag);

    /**
     * @return whether this entity is invisible
     */
    boolean isInvisible();

    /**
     * Set whether entity is invisible or not
     * @param flag whether invisible or not
     */
    void setInvisible(boolean flag);

    /**
     * Get the air ticks
     * @return the air ticks
     */
    int getAirTicks();

    /**
     * Set the air ticks
     * @param ticks air ticks
     */
    void setAirTicks(int ticks);

    /**
     * Returns whether player is invulnerable to the specified damage source or not (takes damage or not)
     * @param damageSource the damage source
     * @return whether player is invulnerable to this damage source or not
     */
    boolean isInvulnerable(@NotNull DamageSource damageSource);

    /**
     * Teleports to specified location.
     * @param location the location
     * @param portal whether portal or not
     */
    void teleportTo(@Nullable Location location, boolean portal);

    /**
     * Set custom name of the entity
     * @param customName the custom name
     */
    void setCustomName(@Nullable String customName);

    /**
     * Get the custom name of the entity
     * @return the custom name
     */
    @Nullable
    String getCustomName();

    /**
     * @return whether the entity has custom name or not
     */
    boolean hasCustomName();

    /**
     * Set the flag whether custom name is visible or not
     * @param flag whether custom name is visible or not
     */
    void setCustomNameVisible(boolean flag);

    /**
     * Get the flag whether custom name is visible or not
     * @return whether custom name is visible or not
     */
    boolean getCustomNameVisible();

    /**
     * Get the height of the head.
     * @return the height of the head
     */
    float getHeadHeight();

    /**
     * Returns reference for this entity.
     * @return the entity
     */
    @NotNull
    Entity getEntity();

    /**
     * Called by the server to tick entity when the entity is active.
     */
    void tick();

    /**
     * Get the nms object.
     * @return raw object
     */
    @NotNull
    Object getHandle();

    /**
     * Get the bukkit world.
     * @return the world
     */
    @NotNull
    World getBukkitWorld();

    /**
     * @return whether the entity is glowing or not
     * @throws UnsupportedOperationException if the current environment does not support this feature
     */
    boolean isGlowing() throws UnsupportedOperationException;

    /**
     * Set the glowing flag.
     * @param flag whether the entity is glowing or not
     * @throws UnsupportedOperationException if the current environment does not support this feature
     */
    void setGlowing(boolean flag) throws UnsupportedOperationException;
}
