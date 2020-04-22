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
import xyz.acrylicstyle.minecraft.Entity;
import xyz.acrylicstyle.shared.OBCAPI;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Placeholder class(for now) to make easier to get nms instance
 */
public class CraftEntity extends OBCAPI implements org.bukkit.entity.Entity {
    public static final Class<?> CLASS = getClassWithoutException("entity.CraftEntity");

    @Override
    @Contract(value = "-> new", pure = true)
    public Entity getHandle() {
        return new xyz.acrylicstyle.minecraft.Entity(super.getOBCClass());
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
    public Location getLocation() {
        return entity.getLocation();
    }

    @Override
    public Location getLocation(Location loc) {
        return entity.getLocation(loc);
    }

    @Override
    public void setVelocity(Vector velocity) {
        entity.setVelocity(velocity);
    }

    @Override
    public Vector getVelocity() {
        return entity.getVelocity();
    }

    @Override
    public boolean isOnGround() {
        return entity.isOnGround();
    }

    @Override
    public World getWorld() {
        return entity.getWorld();
    }

    @Override
    public boolean teleport(Location location) {
        return entity.teleport(location);
    }

    @Override
    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
        return entity.teleport(location, cause);
    }

    @Override
    public boolean teleport(org.bukkit.entity.Entity destination) {
        return entity.teleport(destination);
    }

    @Override
    public boolean teleport(org.bukkit.entity.Entity destination, PlayerTeleportEvent.TeleportCause cause) {
        return entity.teleport(destination, cause);
    }

    @Override
    public List<org.bukkit.entity.Entity> getNearbyEntities(double x, double y, double z) {
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
    public void sendMessage(String message) {
        entity.sendMessage(message);
    }

    @Override
    public void sendMessage(String[] messages) {
        entity.sendMessage(messages);
    }

    @Override
    public CraftServer getServer() {
        return new CraftServer(entity.getServer());
    }

    @Override
    public String getName() {
        return entity.getName();
    }

    @Override
    public CraftEntity getPassenger() {
        return new CraftEntity(entity.getPassenger());
    }

    @Override
    public boolean setPassenger(org.bukkit.entity.Entity passenger) {
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
    public UUID getUniqueId() {
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
    public void playEffect(EntityEffect type) {
        entity.playEffect(type);
    }

    @Override
    public EntityType getType() {
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
    public Spigot spigot() {
        return entity.spigot();
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        entity.setMetadata(metadataKey, newMetadataValue);
    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        return entity.getMetadata(metadataKey);
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        return entity.hasMetadata(metadataKey);
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        entity.removeMetadata(metadataKey, owningPlugin);
    }

    @Override
    public boolean isPermissionSet(String name) {
        return entity.isPermissionSet(name);
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return entity.isPermissionSet(perm);
    }

    @Override
    public boolean hasPermission(String name) {
        return entity.hasPermission(name);
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return entity.hasPermission(perm);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return entity.addAttachment(plugin, name, value);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return entity.addAttachment(plugin);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return entity.addAttachment(plugin, name, value, ticks);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return entity.addAttachment(plugin, ticks);
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        entity.removeAttachment(attachment);
    }

    @Override
    public void recalculatePermissions() {
        entity.recalculatePermissions();
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
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
