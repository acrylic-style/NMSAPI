package xyz.acrylicstyle.craftbukkit.v1_8_R3.entity;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.CraftServer;
import xyz.acrylicstyle.minecraft.v1_8_R1.Entity;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Placeholder class(for now) to make easier to get nms instance
 */
public class CraftEntity extends xyz.acrylicstyle.nmsapi.abstracts.craftbukkit.entity.CraftEntity implements org.bukkit.entity.Entity {
    public static final Class<?> CLASS = getClassWithoutException("entity.CraftEntity");

    @Override
    @Contract(value = "-> new", pure = true)
    public Entity getHandle() {
        return new Entity(super.getOBCClass());
    }

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
    public boolean isOnGround() {
        return entity.isOnGround();
    }

    @Override
    public @NotNull World getWorld() {
        return entity.getWorld();
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
    public @NotNull CraftServer getServer() {
        return new CraftServer(entity.getServer());
    }

    @Override
    public @NotNull String getName() {
        return entity.getName();
    }

    @Override
    public CraftEntity getPassenger() {
        return new CraftEntity(entity.getPassenger());
    }

    @Override
    public boolean setPassenger(org.bukkit.entity.@NotNull Entity passenger) {
        return entity.setPassenger(passenger);
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
}
