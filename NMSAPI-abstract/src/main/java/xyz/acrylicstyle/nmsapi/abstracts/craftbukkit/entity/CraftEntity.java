package xyz.acrylicstyle.nmsapi.abstracts.craftbukkit.entity;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pose;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.shared.OBCAPI;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CraftEntity extends OBCAPI implements org.bukkit.entity.Entity {
    public static final Class<?> CLASS = getClassWithoutException("entity.CraftEntity");

    /*
    @Override
    @Contract(value = "-> new", pure = true)
    public Entity getHandle() {
        return new Entity(super.getOBCClass());
    }*/

    private org.bukkit.entity.Entity entity;

    /**
     * Constructs CraftEntity.
     * @param o Object. Compatible types:
     *          <ul>
     *          <li>obc.CraftEntity</li>
     *          <li>org.bukkit.entity.Entity</li>
     *          </ul>
     */
    public CraftEntity(@NotNull Object o) {
        super(o, "entity.CraftEntity");
        this.entity = (org.bukkit.entity.Entity) o;
    }

    protected CraftEntity(Object o, String clazz) {
        super(o, clazz);
    }

    @Override
    public @NotNull Location getLocation() {
        return entity.getLocation();
    }

    @Override
    public Location getLocation(Location loc) {
        return entity.getLocation(loc);
    }

    @Override
    public void setVelocity(@NotNull Vector velocity) {
        entity.setVelocity(velocity);
    }

    @Override
    public @NotNull Vector getVelocity() {
        return entity.getVelocity();
    }

    @Override
    public double getHeight() {
        return entity.getHeight();
    }

    @Override
    public double getWidth() {
        return entity.getWidth();
    }

    @Override
    public @NotNull BoundingBox getBoundingBox() {
        return entity.getBoundingBox();
    }

    @Override
    public boolean isOnGround() {
        return entity.isOnGround();
    }

    @Override
    public @NotNull World getWorld() {
        return entity.getWorld();
    }

    @Override
    public void setRotation(float v, float v1) {
        entity.setRotation(v, v1);
    }

    @Override
    public boolean teleport(@NotNull Location location) {
        return entity.teleport(location);
    }

    @Override
    public boolean teleport(@NotNull Location location, PlayerTeleportEvent.@NotNull TeleportCause cause) {
        return entity.teleport(location, cause);
    }

    @Override
    public boolean teleport(org.bukkit.entity.@NotNull Entity destination) {
        return entity.teleport(destination);
    }

    @Override
    public boolean teleport(org.bukkit.entity.@NotNull Entity destination, PlayerTeleportEvent.@NotNull TeleportCause cause) {
        return entity.teleport(destination, cause);
    }

    @Override
    public @NotNull List<org.bukkit.entity.Entity> getNearbyEntities(double x, double y, double z) {
        return entity.getNearbyEntities(x, y, z);
    }

    @Override
    public int getEntityId() {
        return entity.getEntityId();
    }

    @Override
    public int getFireTicks() {
        return entity.getFireTicks();
    }

    @Override
    public int getMaxFireTicks() {
        return entity.getMaxFireTicks();
    }

    @Override
    public void setFireTicks(int ticks) {
        entity.setFireTicks(ticks);
    }

    @Override
    public void remove() {
        entity.remove();
    }

    @Override
    public boolean isDead() {
        return entity.isDead();
    }

    @Override
    public boolean isValid() {
        return entity.isValid();
    }

    @Override
    public void sendMessage(@NotNull String message) {
        entity.sendMessage(message);
    }

    @Override
    public void sendMessage(String[] messages) {
        entity.sendMessage(messages);
    }

    @Override
    public @NotNull Server getServer() {
        return entity.getServer();
    }

    @Deprecated
    @Override
    public boolean isPersistent() {
        return entity.isPersistent();
    }

    @Deprecated
    @Override
    public void setPersistent(boolean b) {
        entity.setPersistent(b);
    }

    @Override
    public @NotNull String getName() {
        return entity.getName();
    }

    /**
     * @deprecated entity can have multiple passengers
     */
    @Deprecated
    @Override
    public org.bukkit.entity.Entity getPassenger() {
        return entity.getPassenger();
    }

    /**
     * @deprecated entity can have multiple passengers
     */
    @Deprecated
    @Override
    public boolean setPassenger(org.bukkit.entity.@NotNull Entity passenger) {
        return entity.setPassenger(passenger);
    }

    @Override
    public @NotNull List<org.bukkit.entity.Entity> getPassengers() {
        return entity.getPassengers();
    }

    @Override
    public boolean addPassenger(org.bukkit.entity.@NotNull Entity passenger) {
        return entity.addPassenger(passenger);
    }

    @Override
    public boolean removePassenger(org.bukkit.entity.@NotNull Entity passenger) {
        return entity.removePassenger(passenger);
    }

    @Override
    public boolean isEmpty() {
        return entity.isEmpty();
    }

    @Override
    public boolean eject() {
        return entity.eject();
    }

    @Override
    public float getFallDistance() {
        return entity.getFallDistance();
    }

    @Override
    public void setFallDistance(float distance) {
        entity.setFallDistance(distance);
    }

    @Override
    public void setLastDamageCause(EntityDamageEvent event) {
        entity.setLastDamageCause(event);
    }

    @Override
    public EntityDamageEvent getLastDamageCause() {
        return entity.getLastDamageCause();
    }

    @Override
    public @NotNull UUID getUniqueId() {
        return entity.getUniqueId();
    }

    @Override
    public int getTicksLived() {
        return entity.getTicksLived();
    }

    @Override
    public void setTicksLived(int value) {
        entity.setTicksLived(value);
    }

    @Override
    public void playEffect(@NotNull EntityEffect type) {
        entity.playEffect(type);
    }

    @Override
    public @NotNull EntityType getType() {
        return entity.getType();
    }

    @Override
    public boolean isInsideVehicle() {
        return entity.isInsideVehicle();
    }

    @Override
    public boolean leaveVehicle() {
        return entity.leaveVehicle();
    }

    @Override
    public org.bukkit.entity.Entity getVehicle() {
        return entity.getVehicle();
    }

    @Override
    public void setCustomName(String name) {
        entity.setCustomName(name);
    }

    @Override
    public String getCustomName() {
        return entity.getCustomName();
    }

    @Override
    public void setCustomNameVisible(boolean flag) {
        entity.setCustomNameVisible(flag);
    }

    @Override
    public boolean isCustomNameVisible() {
        return entity.isCustomNameVisible();
    }

    /**
     * @since Minecraft 1.9
     */
    @Override
    public void setGlowing(boolean flag) {
        entity.setGlowing(flag);
    }

    /**
     * @since Minecraft 1.9
     */
    @Override
    public boolean isGlowing() {
        return entity.isGlowing();
    }

    @Override
    public void setInvulnerable(boolean flag) {
        entity.setInvulnerable(flag);
    }

    @Override
    public boolean isInvulnerable() {
        return entity.isInvulnerable();
    }

    @Override
    public boolean isSilent() {
        return entity.isSilent();
    }

    @Override
    public void setSilent(boolean flag) {
        entity.setSilent(flag);
    }

    @Override
    public boolean hasGravity() {
        return entity.hasGravity();
    }

    @Override
    public void setGravity(boolean gravity) {
        entity.setGravity(gravity);
    }

    @Override
    public int getPortalCooldown() {
        return entity.getPortalCooldown();
    }

    @Override
    public void setPortalCooldown(int cooldown) {
        entity.setPortalCooldown(cooldown);
    }

    /**
     * @since Minecraft 1.13
     */
    @Override
    public @NotNull Set<String> getScoreboardTags() {
        return entity.getScoreboardTags();
    }

    /**
     * @since Minecraft 1.13
     */
    @Override
    public boolean addScoreboardTag(@NotNull String tag) {
        return entity.addScoreboardTag(tag);
    }

    /**
     * @since Minecraft 1.13
     */
    @Override
    public boolean removeScoreboardTag(@NotNull String tag) {
        return entity.removeScoreboardTag(tag);
    }

    @Override
    public @NotNull PistonMoveReaction getPistonMoveReaction() {
        return entity.getPistonMoveReaction();
    }

    @Override
    public @NotNull BlockFace getFacing() {
        return entity.getFacing();
    }

    @Override
    public @NotNull Pose getPose() {
        return entity.getPose();
    }

    @Override
    public @NotNull Spigot spigot() {
        return entity.spigot();
    }

    @Override
    public void setMetadata(@NotNull String metadataKey, @NotNull MetadataValue newMetadataValue) {
        entity.setMetadata(metadataKey, newMetadataValue);
    }

    @Override
    public @NotNull List<MetadataValue> getMetadata(@NotNull String metadataKey) {
        return entity.getMetadata(metadataKey);
    }

    @Override
    public boolean hasMetadata(@NotNull String metadataKey) {
        return entity.hasMetadata(metadataKey);
    }

    @Override
    public void removeMetadata(@NotNull String metadataKey, @NotNull Plugin owningPlugin) {
        entity.removeMetadata(metadataKey, owningPlugin);
    }

    @Override
    public boolean isPermissionSet(@NotNull String name) {
        return entity.isPermissionSet(name);
    }

    @Override
    public boolean isPermissionSet(@NotNull Permission perm) {
        return entity.isPermissionSet(perm);
    }

    @Override
    public boolean hasPermission(@NotNull String name) {
        return entity.hasPermission(name);
    }

    @Override
    public boolean hasPermission(@NotNull Permission perm) {
        return entity.hasPermission(perm);
    }

    @Override
    public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value) {
        return entity.addAttachment(plugin, name, value);
    }

    @Override
    public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin) {
        return entity.addAttachment(plugin);
    }

    @Override
    public PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value, int ticks) {
        return entity.addAttachment(plugin, name, value, ticks);
    }

    @Override
    public PermissionAttachment addAttachment(@NotNull Plugin plugin, int ticks) {
        return entity.addAttachment(plugin, ticks);
    }

    @Override
    public void removeAttachment(@NotNull PermissionAttachment attachment) {
        entity.removeAttachment(attachment);
    }

    @Override
    public void recalculatePermissions() {
        entity.recalculatePermissions();
    }

    @Override
    public @NotNull Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return entity.getEffectivePermissions();
    }

    @Override
    public boolean isOp() {
        return entity.isOp();
    }

    @Override
    public void setOp(boolean value) {
        entity.setOp(value);
    }

    @Override
    public @NotNull PersistentDataContainer getPersistentDataContainer() {
        return entity.getPersistentDataContainer();
    }
}
