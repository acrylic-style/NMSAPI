package xyz.acrylicstyle.minecraft.v1_12_R1;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.ICollectionList;
import util.ReflectionHelper;
import util.reflect.Ref;
import xyz.acrylicstyle.nmsapi.abstracts.craftbukkit.entity.CraftEntity;
import xyz.acrylicstyle.nmsapi.abstracts.minecraft.DamageSource;
import xyz.acrylicstyle.shared.NMSAPI;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@SuppressWarnings({"unused", "Convert2MethodRef"})
public class Entity extends NMSAPI implements ICommandListener, xyz.acrylicstyle.nmsapi.abstracts.minecraft.Entity {
    public static final Class<?> CLASS = getClassWithoutException("Entity");

    protected Entity(Object o, String clazz) { super(o, clazz); }

    protected Entity(String clazz, Object... args) { super(clazz, args); }

    public Entity(@NotNull Object o) {
        super(o, "Entity");
    }

    public static boolean isLevelAtLeast(NBTTagCompound tag, int level) {
        return (tag.hasKey("Bukkit.updateLevel") && tag.getInt("Bukkit.updateLevel") >= level);
    }

    public void inactiveTick() {}

    public float getBukkitYaw() {
        return (float) getField("yaw");
    }

    // public Entity(World world) {}

    public int getId() {
        return (int) getField("id");
    }

    @Deprecated
    @Override
    public xyz.acrylicstyle.nmsapi.abstracts.minecraft.@Nullable Entity getPassenger() throws NoSuchElementException {
        if (ReflectionHelper.findField(CLASS, "passenger") != null) {
            Object e = getField("passenger");
            return e == null ? null : new Entity(e);
        }
        return getPassengers().get(0);
    }

    @Override
    public @NotNull List<xyz.acrylicstyle.nmsapi.abstracts.minecraft.Entity> getPassengers() {
        if (ReflectionHelper.findField(CLASS, "passenger") != null) {
            Object e = getField("passenger");
            return e == null ? new ArrayList<>() : Arrays.asList(new Entity[] { new Entity(e) });
        }
        return ICollectionList.asList((List<?>) getField("passengers")).map(o -> new Entity(o));
    }

    public void h(int i) {
        setField("id", i);
    }

    public void setId(int i) { h(i); }

    @SuppressWarnings("unchecked")
    public Set<String> getScoreboardTags() {
        return (Set<String>) getField("aH");
    }

    public boolean addScoreboardTag(String s) {
        return (boolean) invoke("addScoreboardTag");
    }

    public boolean removeScoreboardTag(String s) {
        return (boolean) invoke("removeScoreboardTag");
    }

    public void killEntity() {
        die();
    }

    public void die() {
        invoke("die");
    }

    // public DataWatcher getDataWatcher() {}

    public boolean equals(Object o) {
        return (o instanceof Entity) && (((((Entity) o).getId() == this.getId())));
    }

    public int hashCode() { return getId(); }

    public void b(boolean flag) {}

    public void setSize(float f, float f1) {
        invoke("setSize", f, f1);
    }

    public void setYawPitch(float yaw, float pitch) {
        invoke("setYawPitch", yaw, pitch);
    }

    public void setPosition(double x, double y, double z) {
        invoke("setPosition", x, y, z);
    }

    public void B_() {
        invoke("B_");
    }

    public void postTick() {
        invoke("postTick");
    }

    public void Y() {
        invoke("Y");
    }

    public void I() {
        invoke("I");
    }

    public void burnFromLava() {
        invoke("burnFromLava");
    }

    public void setOnFire(int i) {
        invoke("setOnFire", i);
    }

    public void extinguish() {
        invoke("extinguish");
    }

    @Override
    public void remove() {
        invoke("remove");
    }

    @Override
    public void move(double x, double y, double z) {
        invoke("move", x, y, z);
    }

    @Override
    public @NotNull String getSwimSound() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void makeSound(@NotNull String sound, float volume, float pitch) {
        throw new UnsupportedOperationException("Unsupported on current environment (needs SoundEffect to be implemented)");
    }

    public void ac() { die(); }

    public boolean c(double d0, double d1, double d2) {
        return (boolean) invoke("c", d0, d1, d2);
    }

    // public boolean b(AxisAlignedBB axisAlignedBB) {}

    public void move(EnumMoveType enumMoveType, double d0, double d1, double d2) {
        invoke("move", enumMoveType.toNMSEnum(), d0, d1, d2);
    }

    public void recalcPosition() {
        invoke("recalcPosition");
    }

    // public SoundEffect ae() {}

    // public SoundEffect af() {}

    public void checkBlockCollisions() {
        invoke("checkBlockCollisions");
    }

    // public void a(IBlockData iBlockData) {}

    // public void a(BlockPosition blockPosition, Block block)

    public float d(float f) {
        return (float) invoke("d", f);
    }

    public boolean ah() {
        return (boolean) invoke("ah");
    }

    // public void a(SoundEffect soundEffect, float f, float f1) {}

    public boolean isSilent() {
        return (boolean) invoke("isSilent");
    }

    public void setSilent(boolean flag) {
        invoke("setSilent", flag);
    }

    public boolean isNoGravity() {
        return (boolean) invoke("isNoGravity");
    }

    public void setNoGravity(boolean flag) {
        invoke("setNoGravity", flag);
    }

    public boolean playStepSound() {
        return (boolean) invoke("playStepSound");
    }

    // public void a(double d0, boolean flag, IBlockData iBlockData, BlockPosition blockPosition) {}

    @Nullable
    public AxisAlignedBB al() {
        return null;
    }

    public void burn(float i) {
        invoke("burn", i);
    }

    public boolean isFireProof() {
        return (boolean) getField("fireProof");
    }

    @Override
    public int getPortalCooldown() {
        return field("portalCooldown");
    }

    @Override
    public int getDimension() {
        return field("dimension");
    }

    public void e(float f, float f1) {
        invoke("e", f, f1);
    }

    public boolean an() {
        return (boolean) invoke("an");
    }

    public boolean isInWater() {
        return (boolean) getField("inWater");
    }

    @Override
    public int getNoDamageTicks() {
        return field("noDamageTicks");
    }

    public boolean ap() {
        return (boolean) invoke("ap");
    }

    public boolean aq() {
        return (boolean) invoke("aq");
    }

    public void ar() {
        invoke("ar");
    }

    public void as() {
        invoke("as");
    }

    public void at() {
        invoke("at");
    }

    // public boolean a(Material material) {}

    public boolean au() {
        return (boolean) invoke("au");
    }

    public void b(float f, float f1, float f2, float f3) {
        invoke("b", f, f1, f2, f3);
    }

    public float aw() {
        return (float) invoke("aw");
    }

    // public void spawnIn(World world) {}

    @Override
    public void setLocation(double x, double y, double z, float yaw, float pitch) {
        invoke("setLocation", x, y, z, yaw, pitch);
    }

    public void setPositionRotation(BlockPosition blockPosition, float f, float f1) {
        invoke("setPositionRotation", blockPosition.getNMSClass(), f, f1);
    }

    @Override
    public void setPositionRotation(double x, double y, double z, float yaw, float pitch) {
        invoke("setPositionRotation", x, y, z, yaw, pitch);
    }

    @Override
    public double distanceSquared(xyz.acrylicstyle.nmsapi.abstracts.minecraft.@NotNull Entity entity) {
        return (double) invoke("h", entity.getHandle());
    }

    @Override
    public void collide(xyz.acrylicstyle.nmsapi.abstracts.minecraft.@NotNull Entity entity) {
        invoke("collide", entity.getHandle());
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean damageEntity(DamageSource damageSource, float damage) {
        return (boolean) Ref.getClass(CLASS)
                .getMethod("damageEntity", getClassWithoutException("DamageSource"), float.class)
                .invokeObj(this.getHandle(), damageSource, damage);
    }

    public float g(Entity entity) {
        return (float) invoke("g", entity.getNMSClass());
    }

    public double d(double x, double y, double z) {
        return (double) invoke("d", x, y, z);
    }

    public double getX() {
        return (double) getField("locX");
    }

    public double getY() {
        return (double) getField("locY");
    }

    public double getZ() {
        return (double) getField("locZ");
    }

    @Override
    public float getYaw() {
        return field("yaw");
    }

    @Override
    public float getPitch() {
        return field("pitch");
    }

    @Override
    public double getMotionX() {
        return field("motX");
    }

    @Override
    public double getMotionY() {
        return field("motY");
    }

    @Override
    public double getMotionZ() {
        return field("motZ");
    }

    @Override
    public boolean isOnGround() {
        return field("onGround");
    }

    @Override
    public float getFallDistance() {
        return field("fallDistance");
    }

    @Override
    public float getWidth() {
        return field("width");
    }

    @Override
    public float getLength() {
        return field("length");
    }

    @Override
    public int getTicksLived() {
        return field("ticksLived");
    }

    @Override
    public void setTicksLived(int ticksLived) {
        setField("ticksLived", ticksLived);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull World getBukkitWorld() {
        Object world = Ref.getClass(CLASS).getDeclaredField("world").getObj(this.getHandle());
        return (World) Ref.getClass(getClassWithoutException("World")).getMethod("getWorld").invokeObj(world);
    }

    @Override
    public boolean isGlowing() throws UnsupportedOperationException {
        return field("glowing");
    }

    @Override
    public void setGlowing(boolean flag) throws UnsupportedOperationException {
        setField("glowing", flag);
    }

    public double c(BlockPosition blockPosition) {
        return blockPosition.distanceSquared(getX(), getY(), getZ());
    }

    public double d(BlockPosition blockPosition) {
        return blockPosition.g(getX(), getY(), getZ());
    }

    public double e(double x, double y, double z) {
        return (double) invoke("e", x, y, z);
    }

    public double h(Entity entity) {
        return (double) invoke("h", entity.getNMSClass());
    }

    // public void d(EntityHuman entityHuman) {}

    public void collide(Entity entity) {
        invoke("collide", entity.getNMSClass());
    }

    public void f(double x, double y, double z) {
        invoke("f", x, y, z);
    }

    public void ax() {
        setField("velocityChanged", true);
    }

    // public boolean damageEntity(DamageSource damageSource, float f) {}

    public Vec3D e(float f) {
        return new Vec3D(invoke("e", f));
    }

    public Vec3D f(float f, float f1) {
        return new Vec3D(invoke("f", f, f1));
    }

    public Vec3D f(float f) {
        return new Vec3D(invoke("f", f));
    }

    public boolean isInteractable() {
        return (boolean) invoke("isInteractable");
    }

    public boolean isCollidable() {
        return (boolean) invoke("isCollidable");
    }

    // public void a(Entity entity, int i, DamageSource damageSource) {}

    public boolean c(NBTTagCompound nbtTagCompound) {
        return (boolean) invoke("c", nbtTagCompound.getHandle());
    }

    public boolean d(NBTTagCompound nbtTagCompound) {
        return (boolean) invoke("d", nbtTagCompound.getHandle());
    }

    // public static void d(DataConverterManager dataConverterManager) {}

    public NBTTagCompound save(NBTTagCompound nbtTagCompound) {
        return new NBTTagCompound(invoke("save", nbtTagCompound.getHandle()));
    }

    public void f(NBTTagCompound nbtTagCompound) {
        invoke("f", nbtTagCompound.getHandle());
    }

    public boolean aA() {
        return (boolean) invoke("aA");
    }

    public String getSaveID() {
        return (String) invoke("getSaveID");
    }

    @SuppressWarnings("RedundantCast")
    public NBTTagList a(double... aDouble) {
        return new NBTTagList(invoke("a", (Object) aDouble));
    }

    // public EntityItem a(Item item, int i) {}

    // public EntityItem a(Item item, int i, float f) {}

    // public EntityItem a(ItemStack itemStack, float f) {}

    public boolean isAlive() {
        return (boolean) invoke("isAlive");
    }

    @Override
    public @NotNull CraftEntity getBukkitEntity() {
        return new CraftEntity(invoke("getBukkitEntity"));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void mount(xyz.acrylicstyle.nmsapi.abstracts.minecraft.@Nullable Entity entity) {
        Ref.getClass(CLASS)
                .getMethod("mount", xyz.acrylicstyle.nmsapi.abstracts.minecraft.Entity.CLASS)
                .invokeObj(this.getHandle(), entity == null ? null : entity.getHandle());
    }

    public boolean inBlock() {
        return (boolean) invoke("inBlock");
    }

    // public boolean b(EntityHuman entityHuman, EnumHand enumHand) {}

    @Nullable
    public AxisAlignedBB j(Entity entity) {
        return null;
    }

    public void aE() {
        invoke("aE");
    }

    public void k(Entity entity) {
        invoke("k", entity.getNMSClass());
    }

    public double aF() {
        return (double) invoke("aF");
    }

    public double aG() {
        return (double) invoke("aG");
    }

    public boolean startRiding(Entity entity) {
        return a(entity, false);
    }

    public boolean a(Entity entity, boolean flag) {
        return (boolean) invoke("a", entity.getNMSClass(), flag);
    }

    public boolean n(Entity entity) {
        return (boolean) invoke("n", entity.getNMSClass());
    }

    public void ejectPassengers() {
        invoke("ejectPassengers");
    }

    public void stopRiding() {
        invoke("stopRiding");
    }

    public void o(Entity entity) {
        invoke("o", entity.getNMSClass());
    }

    public void p(Entity entity) {
        invoke("p", entity.getNMSClass());
    }

    public boolean q(Entity entity) {
        return (boolean) invoke("q", entity.getNMSClass());
    }

    public float aI() {
        return (float) invoke("aI");
    }

    public Vec3D aJ() {
        return new Vec3D(invoke("aJ"));
    }

    public void e(BlockPosition blockPosition) {
        invoke("e", blockPosition.getNMSClass());
    }

    public int aM() {
        return (int) invoke("aM");
    }

    @SuppressWarnings("unchecked")
    public Iterable<ItemStack> aO() {
        return (Iterable<ItemStack>) getField("b");
    }

    @SuppressWarnings("unchecked")
    public Iterable<ItemStack> getArmorItems() {
        return (Iterable<ItemStack>) getField("b");
    }

    public Iterable<ItemStack> aQ() {
        return Iterables.concat(aO(), getArmorItems());
    }

    // public void setEquipment(EnumItemSlot enumItemSlot, ItemStack itemStack) {}

    public boolean isBurning() {
        return (boolean) invoke("isBurning");
    }

    @Override
    public boolean hasVehicle() {
        return getVehicle() != null;
    }

    public boolean isPassenger() {
        return (boolean) invoke("isPassenger");
    }

    public boolean isVehicle() {
        return (boolean) invoke("isVehicle");
    }

    public boolean isSneaking() {
        return (boolean) invoke("isSneaking");
    }

    public void setSneaking(boolean flag) {
        invoke("setSneaking", flag);
    }

    public boolean isSprinting() {
        return (boolean) invoke("isSprinting");
    }

    public void setSprinting(boolean flag) {
        invoke("setSprinting", flag);
    }

    public boolean aW() {
        return (boolean) invoke("aW");
    }

    public void g(boolean flag) {
        invoke("g", flag);
    }

    public boolean isInvisible() {
        return (boolean) invoke("isInvisible");
    }

    // @Nullable
    // public ScoreboardTeamBase aY() {}

    public boolean r(Entity entity) {
        return (boolean) invoke("r", entity.getNMSClass());
    }

    // public boolean a(ScoreboardTeamBase scoreboardTeamBase) {}

    public void setInvisible(boolean flag) {
        invoke("setInvisible", flag);
    }

    public boolean getFlag(int i) {
        return (boolean) invoke("getFlag", i);
    }

    public void setFlag(int i, boolean flag) {
        invoke("setFlag", i, flag);
    }

    public int getAirTicks() {
        return (int) invoke("getAirTicks");
    }

    public void setAirTicks(int i) {
        invoke("setAirTicks", i);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isInvulnerable(@NotNull DamageSource damageSource) {
        return (boolean) Ref.getClass(CLASS)
                .getMethod("isInvulnerable", getClassWithoutException("DamageSource"))
                .invokeObj(this.getHandle(), damageSource.getHandle());
    }

    // public void onLightningStrike(EntityLightning entityLightning) {}

    // public void b(EntityLiving entityLiving) {}

    public boolean i(double x, double y, double z) {
        return (boolean) invoke("i", x, y, z);
    }

    public void ba() {
        invoke("ba");
    }

    @NotNull
    public String getName() {
        return (String) invoke("getName");
    }

    @SuppressWarnings("deprecation")
    @Override
    public void sendMessage(xyz.acrylicstyle.nmsapi.abstracts.minecraft.@NotNull IChatBaseComponent iChatBaseComponent) {
        Ref.getClass(CLASS)
                .getMethod("sendMessage", getClassWithoutException("IChatBaseComponent"))
                .invokeObj(this.getHandle(), iChatBaseComponent.getHandle());
    }

    @Nullable
    public Entity[] bb() {
        return null;
    }

    public boolean s(Entity entity) {
        return (this == entity);
    }

    public float getHeadRotation() {
        return (float) invoke("getHeadRotation");
    }

    public void setHeadRotation(float f) {
        invoke("setHeadRotation", f);
    }

    public void h(float f) {
        invoke("h", f);
    }

    public boolean bd() {
        return (boolean) invoke("bd");
    }

    public boolean t(Entity entity) {
        return (boolean) invoke("t", entity.getNMSClass());
    }

    @Override
    public String toString() {
        return (String) invoke("toString");
    }

    public boolean be() {
        return (boolean) invoke("be");
    }

    @Override
    public boolean isInvulnerable() { return be(); }

    public void setInvulnerable(boolean flag) {
        invoke("setInvulnerable", flag);
    }

    public void u(Entity entity) {
        invoke("u", entity.getNMSClass());
    }

    public void a(Entity entity) {
        invoke("a", entity.getNMSClass());
    }

    @Nullable
    public Entity b(int i) {
        return new Entity(invoke("b", i));
    }

    public void teleportTo(Location exit, boolean portal) {
        invoke("teleportTo", exit, portal);
    }

    public boolean bf() {
        return (boolean) invoke("bf");
    }

    // public float a(Explosion explosion, World world, BlockPosition blockPosition, IBlockData iBlockData) {}

    // public boolean a(Explosion explosion, World world, BlockPosition blockPosition, IBlockData iBlockData, float f) {}

    public int bg() {
        return (int) invoke("bg");
    }

    public Vec3D getPortalOffset() {
        return new Vec3D(invoke("getPortalOffset"));
    }

    public EnumDirection getPortalDirection() {
        return EnumDirection.valueOf(((Enum<?>) getField("ap")).name());
    }

    public boolean isIgnoreBlockTrigger() {
        return (boolean) invoke("isIgnoreBlockTrigger");
    }

    public void appendEntityCrashDetails(CrashReportSystemDetails crashReportSystemDetails) {
        invoke("appendEntityCrashDetails", crashReportSystemDetails.getNMSClass());
    }

    public void a(UUID uuid) {
        invoke("a", uuid);
    }

    public @NotNull UUID getUniqueId() {
        return field("uniqueID");
    }

    @Override
    public boolean isValid() {
        return field("valid");
    }

    @Override
    public boolean isAddedToChunk() {
        return false;
    }

    @Override
    public boolean isFromMobSpawner() {
        return false;
    }

    @Override
    public int getCollisions() {
        return 0;
    }

    public String bn() {
        return field("ar");
    }

    public boolean bo() {
        return (boolean) invoke("bo");
    }

    public IChatBaseComponent getScoreboardDisplayName() {
        return new ChatComponentText(invoke("getScoreboardDisplayName"));
    }

    @Override
    public void setCustomName(String s) {
        invoke("setCustomName", s);
    }

    @Override
    public String getCustomName() {
        return (String) invoke("getCustomName");
    }

    @Override
    public boolean hasCustomName() {
        return (boolean) invoke("hasCustomName");
    }

    public void setCustomNameVisible(boolean flag) {
        invoke("setCustomNameVisible", flag);
    }

    @Override
    public boolean getCustomNameVisible() {
        return (boolean) invoke("getCustomNameVisible");
    }

    public void enderTeleportTo(double x, double y, double z) {
        invoke("enderTeleportTo", x, y, z);
    }

    // public void a(DataWatcherObject<?> dataWatcherObject) {}

    public EnumDirection getDirection() {
        return EnumDirection.valueOf(((Enum<?>) invoke("getDirection")).name());
    }

    public EnumDirection bu() {
        return getDirection();
    }

    // public ChatHoverable bv() {}

    public boolean a(EntityPlayer entityPlayer) {
        return (boolean) invoke("a", entityPlayer.getHandle());
    }

    public AxisAlignedBB getBoundingBox() {
        return new AxisAlignedBB(invoke("getBoundingBox"));
    }

    public void a(AxisAlignedBB axisAlignedBB) {
        invoke("a", axisAlignedBB.getNMSClass());
    }

    @Override
    public float getHeadHeight() {
        return (float) invoke("getHeadHeight");
    }

    @Override
    public xyz.acrylicstyle.nmsapi.abstracts.minecraft.@NotNull Entity getEntity() {
        return this;
    }

    @Override
    public void tick() {
        invoke("Y");
    }

    public boolean bz() {
        return (boolean) getField("aw");
    }

    public void k(boolean flag) {
        setField("aw", flag);
    }

    public boolean c(int i, ItemStack itemStack) {
        return (boolean) invoke("c", i, itemStack.getNMSClass());
    }

    public void sendMessage(IChatBaseComponent iChatBaseComponent) {
        invoke("sendMessage", iChatBaseComponent.getIChatBaseComponent());
    }

    public boolean a(int i, String s) {
        return (boolean) invoke("a", i, s);
    }

    public BlockPosition getChunkCoordinates() {
        return new BlockPosition(invoke("getChunkCoordinates"));
    }

    public Vec3D d() {
        return new Vec3D(invoke("d"));
    }

    // public World getWorld() {}

    public Entity f() {
        return this;
    }

    public boolean getSendCommandFeedback() {
        return (boolean) invoke("getSendCommandFeedback");
    }

    // public void a(CommandObjectiveExecutor.EnumCommandResult commandResult, int i) {}

    @Nullable
    public MinecraftServer C_() {
        try {
            return new MinecraftServer(getField("world").getClass().getMethod("getMinecraftServer").invoke(getField("world")));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    // public CommandObjectiveExecutor bA() {}

    public void v(Entity entity) {
        invoke("v", entity.getNMSClass());
    }

    // public EnumInteractionResult a(EntityHuman entityHuman, Vec3D vec3D, EnumHand enumHand) {}

    public boolean bB() {
        return (boolean) invoke("bB");
    }

    // public void a(EntityLiving entityLiving, Entity entity) {}

    public void b(EntityPlayer entityPlayer) {
        invoke("b", entityPlayer.getHandle());
    }

    public void c(EntityPlayer entityPlayer) {
        invoke("c", entityPlayer.getHandle());
    }

    // public float a(EnumBlockRotation enumBlockRotation) {}

    // public float a(EnumBlockMirror enumBlockMirror) {}

    public boolean bC() {
        return (boolean) invoke("bC");
    }

    public boolean bD() {
        return (boolean) invoke("bD");
    }

    @Nullable
    public Entity bE() {
        return null;
    }

    public List<Entity> bF() {
        return ICollectionList.asList((List<?>) invoke("bF")).map(o -> new Entity(o));
    }

    public boolean w(Entity entity) {
        return (boolean) invoke("w", entity.getNMSClass());
    }

    public Collection<Entity> bG() {
        return ICollectionList.asList((List<?>) invoke("bG")).map(o -> new Entity(o));
    }

    public <T extends Entity> Collection<T> b(Class<T> oClass) {
        HashSet<T> hashSet = Sets.newHashSet();
        a(oClass, hashSet);
        return hashSet;
    }

    @SuppressWarnings("unchecked")
    public <T extends Entity> void a(Class<T> oClass, Set<T> set) {
        for (Iterator<Entity> iterator = bF().iterator(); iterator.hasNext(); this.a(oClass, set)) {
            Entity entity = iterator.next();
            if (oClass.isAssignableFrom(entity.getClass()))
                set.add((T) entity);
        }
    }

    public Entity getVehicle() {
        return new Entity(invoke("getVehicle"));
    }

    @Override
    public boolean isAttachedToPlayer() {
        return field("attachedToPlayer");
    }

    @Override
    public double getLastX() {
        return field("lastX");
    }

    @Override
    public double getLastY() {
        return field("lastY");
    }

    @Override
    public double getLastZ() {
        return field("lastZ");
    }

    @Override
    public float getLastYaw() {
        return field("lastYaw");
    }

    @Override
    public float getLastPitch() {
        return field("lastPitch");
    }

    public boolean x(Entity entity) {
        return (boolean) invoke("x", entity.getNMSClass());
    }

    public boolean y(Entity entity) {
        return (boolean) invoke("y", entity.getNMSClass());
    }

    public boolean bI() {
        return (boolean) invoke("bI");
    }

    @Nullable
    public Entity bJ() {
        return new Entity(getField("au"));
    }

    // public EnumPistonReaction getPushReaction() {}

    // public SoundCategory bK() {}

    public int getMaxFireTicks() {
        return (int) invoke("getMaxFireTicks");
    }

    @Override
    public void setMaxFireTicks(int ticks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getFireTicks() {
        return field("fireTicks");
    }

    @Override
    public void setFireTicks(int fireTicks) {
        setField("fireTicks", fireTicks);
    }

    // these methods are abstract and needs to be overridden

    public void i() {}

    public void a(NBTTagCompound nbtTagCompound) {}

    public void b(NBTTagCompound nbtTagCompound) {}
}
