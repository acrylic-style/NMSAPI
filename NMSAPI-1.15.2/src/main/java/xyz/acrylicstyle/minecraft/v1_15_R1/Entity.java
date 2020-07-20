package xyz.acrylicstyle.minecraft.v1_15_R1;

import org.bukkit.Location;
import org.bukkit.projectiles.ProjectileSource;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spigotmc.CustomTimingsHandler;
import util.ICollectionList;
import util.reflect.Ref;
import xyz.acrylicstyle.nmsapi.abstracts.craftbukkit.entity.CraftEntity;
import xyz.acrylicstyle.nmsapi.abstracts.minecraft.DamageSource;
import xyz.acrylicstyle.shared.NMSAPI;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.UUID;
import java.util.function.Function;

@SuppressWarnings("unused")
public class Entity extends NMSAPI implements xyz.acrylicstyle.nmsapi.abstracts.minecraft.Entity {
    public static final Class<?> CLASS = getClassWithoutException("Entity");

    public Entity(String clazz) {
        super(clazz);
    }

    public Entity(Object o, String clazz) {
        super(o, clazz);
    }

    public Entity(String clazz, Object... args) {
        super(clazz, args);
    }

    public Entity(Object o) {
        super(o, "Entity");
    }

    public static boolean isLevelAtLeast(NBTTagCompound tag, int level) {
        return (tag.hasKey("Bukkit.updateLevel") && tag.getInt("Bukkit.updateLevel") >= level);
    }

    public static final int CURRENT_LEVEL = 2;

    private int id() { return field("id"); }
    private double j() { return field("j"); }
    private boolean k() { return field("k"); }
    private Entity passenger() { return new Entity(getField("passenger")); }
    private Entity vehicle() { return getField("vehicle") != null ? new Entity(getField("vehicle")) : null; }
    private boolean attachedToPlayer() { return field("attachedToPlayer"); }
    private World world() { return World.newInstance(getField("world")); }
    private double lastX() { return field("lastX"); }
    private double lastY() { return field("lastY"); }
    private double lastZ() { return field("lastZ"); }
    private double locX() { return field("locX"); }
    private double locY() { return field("locY"); }
    private double locZ() { return field("locZ"); }
    private double motX() { return field("motX"); }
    private double motY() { return field("motY"); }
    private double motZ() { return field("motZ"); }
    private float yaw() { return field("yaw"); }
    private float pitch() { return field("pitch"); }
    private float lastYaw() { return field("lastYaw"); }
    private float lastPitch() { return field("lastPitch"); }
    private boolean onGround() { return field("onGround"); }
    private boolean positionChanged() { return field("positionChanged"); }
    private boolean E() { return field("E"); }
    private boolean F() { return field("F"); }
    private boolean velocityChanged() { return field("velocityChanged"); }
    private boolean H() { return field("H"); }
    private boolean g() { return field("g"); }
    private boolean dead() { return field("dead"); }
    private float getL() { return field("L"); }
    private float M() { return field("M"); }
    private float N() { return field("N"); }
    private float fallDistance() { return field("fallDistance"); }
    private int getH() { return field("h"); }
    private double getP() { return field("P"); }
    private double getQ() { return field("Q"); }
    private double getR() { return field("R"); }
    private float S() { return field("S"); }
    private boolean noclip() { return field("noclip"); }
    private float getU() { return field("U"); }
    private Random random() { return field("random"); }
    private int ticksLived() { return field("ticksLived"); }
    private int fireTicks() { return field("fireTicks"); }
    private boolean inWater() { return field("inWater"); }
    private int noDamageTicks() { return field("noDamageTicks"); }
    private boolean justCreated() { return field("justCreated"); }
    private boolean fireProof() { return field("fireProof"); }
    private double ar() { return field("ar"); }
    private double as() { return field("as"); }
    private boolean isAd() { return field("ad"); }
    private int getAe() { return field("ae"); }
    private int getAf() { return field("af"); }
    private int getAg() { return field("ag"); }
    private boolean getAh() { return field("ah"); }
    private boolean ai() { return field("ai"); }
    private int portalCooldown() { return field("portalCooldown"); }
    private boolean isAk() { return field("ak"); }
    private int getAl() { return field("al"); }
    private int dimension() { return field("dimension"); }
    private xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition getAn() { return new xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition(getField("an")); }
    private Vec3D getAo() { return new Vec3D(getField("ao")); }
    private EnumDirection getAp() { return EnumDirection.valueOf(((Enum<?>) getField("ap")).name()); }
    private boolean invulnerable() { return field("invulnerable"); }
    private UUID uniqueID() { return field("uniqueID"); }
    private boolean valid() { return field("valid"); }
    private ProjectileSource projectileSource() { return field("projectileSource"); }
    private boolean forceExplosionKnockback() { return field("forceExplosionKnockback"); }

    @Override
    public boolean isAddedToChunk() {
        return field("inChunk");
    }

    @Override
    public boolean isFromMobSpawner() {
        return false;
    }

    @Override
    public int getCollisions() {
        return 0;
    }

    public CustomTimingsHandler tickTimer() { return field("tickTimer"); }
    public final byte activationType() { return field("activationType"); }
    public final boolean defaultActivationState() { return field("defaultActivationState"); }
    public long activatedTick() { return field("activatedTick"); }

    public void inactiveTick() { invoke("inactiveTick"); }

    public int getId() {
        return this.id();
    }

    @Override
    public xyz.acrylicstyle.nmsapi.abstracts.minecraft.@Nullable Entity getPassenger() throws NoSuchElementException {
        return getPassengers().get(0);
    }

    @SuppressWarnings({ "Convert2MethodRef" })
    @Override
    public @NotNull List<xyz.acrylicstyle.nmsapi.abstracts.minecraft.Entity> getPassengers() {
        return ICollectionList.asList((List<?>) getField("passengers")).map(o -> new Entity(o));
    }

    @Override
    public xyz.acrylicstyle.nmsapi.abstracts.minecraft.@Nullable Entity getVehicle() {
        return vehicle();
    }

    @Override
    public boolean isAttachedToPlayer() {
        return attachedToPlayer();
    }

    @Override
    public double getLastX() {
        return lastX();
    }

    @Override
    public double getLastY() {
        return lastY();
    }

    @Override
    public double getLastZ() {
        return lastZ();
    }

    @Override
    public float getLastYaw() {
        return lastYaw();
    }

    @Override
    public float getLastPitch() {
        return lastPitch();
    }

    @Override
    public double getX() {
        return locX();
    }

    @Override
    public double getY() {
        return locY();
    }

    @Override
    public double getZ() {
        return locZ();
    }

    @Override
    public float getYaw() {
        return yaw();
    }

    @Override
    public float getPitch() {
        return pitch();
    }

    @Override
    public double getMotionX() {
        return motX();
    }

    @Override
    public double getMotionY() {
        return motY();
    }

    @Override
    public double getMotionZ() {
        return motZ();
    }

    @Override
    public boolean isOnGround() {
        return onGround();
    }

    @Override
    public float getFallDistance() {
        return fallDistance();
    }

    @Override
    public float getWidth() {
        return 0;
    }

    @Override
    public float getLength() {
        return 0;
    }

    @Override
    public int getTicksLived() {
        return ticksLived();
    }

    @Override
    public void setTicksLived(int ticksLived) {
        setField("ticksLived", ticksLived);
    }

    @Override
    public int getMaxFireTicks() {
        return (int) invoke("getMaxFireTicks");
    }

    @Override
    public void setMaxFireTicks(int ticks) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getFireTicks() {
        return fireTicks();
    }

    @Override
    public void setFireTicks(int fireTicks) {
        setField("fireTicks", fireTicks);
    }

    @Override
    public boolean isInWater() {
        return inWater();
    }

    @Override
    public int getNoDamageTicks() {
        return noDamageTicks();
    }

    public boolean equals(Object o) {
        return (o instanceof Entity) && ((((Entity) o).id() == this.id()));
    }

    public int hashCode() {
        return this.id();
    }

    public void die() {
        invoke("die");
    }

    public void setSize(float f, float f1) {
        invoke("setSize", f, f1);
    }

    public void setYawPitch(float f, float f1) {
        invoke("setYawPitch", f, f1);
    }

    public void setPosition(double d0, double d1, double d2) {
        invoke("setPosition", d0, d1, d2);
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

    }

    public void O() {
        invoke("O");
    }

    public boolean c(double d0, double d1, double d2) {
        return (boolean) invoke("c", d0, d1, d2);
    }

    public void move(double d0, double d1, double d2) {
        invoke("move", d0, d1, d2);
    }

    @Override
    public @NotNull String getSwimSound() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public void checkBlockCollisions() {
        invoke("checkBlockCollisions");
    }

    // public void a(BlockPosition blockPosition, Block block) {}

    @Override
    public void makeSound(@NotNull String s, float f, float f1) {
        throw new UnsupportedOperationException();
    }

    // public void a(double d0, boolean flag, Block block, BlockPosition blockPosition) {}

    // public AxisAlignedBB S() {}

    public void burn(float i) {
        invoke("burn", i);
    }

    public boolean isFireProof() {
        return field("fireProof");
    }

    @Override
    public int getPortalCooldown() {
        return portalCooldown();
    }

    @Override
    public int getDimension() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isInvulnerable() {
        return invulnerable();
    }

    @Override
    public @NotNull UUID getUniqueId() {
        return uniqueID();
    }

    @Override
    public boolean isValid() {
        return valid();
    }

    public void e(float f, float f1) {
        invoke("e", f, f1);
    }

    public boolean U() {
        return (boolean) invoke("U");
    }

    public boolean V() {
        return field("inWater");
    }

    public boolean W() {
        return (boolean) invoke("W");
    }

    public void X() {
        invoke("X");
    }

    public void Y() {
        invoke("Y");
    }

    public void Z() {
        invoke("Z");
    }

    public String aa() {
        return (String) invoke("aa");
    }

    // public boolean a(Material material) {}

    public boolean ab() {
        return (boolean) invoke("ab");
    }

    public void a(float f, float f1, float f2) {
        invoke("a", f, f1, f2);
    }

    public float c(float f) {
        return (float) invoke("c", f);
    }

    public void spawnIn(World world) {
        invoke("spawnIn", world.getHandle());
    }

    public void setLocation(double x, double y, double z, float yaw, float pitch) {
        invoke("setLocation", x, y, z, yaw, pitch);
    }

    public void setPositionRotation(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition, float yaw, float pitch) {
        invoke("setPositionRotation", blockPosition.getHandle(), yaw, pitch);
    }

    public void setPositionRotation(double x, double y, double z, float yaw, float pitch) {
        invoke("setPositionRotation", x, y, z, yaw, pitch);
    }

    @Override
    public double distanceSquared(xyz.acrylicstyle.nmsapi.abstracts.minecraft.@NotNull Entity entity) {
        return (double) invoke("h", entity.getHandle()); // todo: verify
    }

    @SuppressWarnings("deprecation")
    @Override
    public void collide(xyz.acrylicstyle.nmsapi.abstracts.minecraft.@NotNull Entity entity) {
        Ref.getClass(CLASS).getMethod("collide", Entity.CLASS).invokeObj(null, entity.getHandle());
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean damageEntity(DamageSource damageSource, float damage) {
        return (boolean) Ref.getClass(CLASS)
                .getMethod("damageEntity", getClassWithoutException("DamageSource"), float.class)
                .invokeObj(null, damageSource.getHandle(), damage);
    }

    public float g(Entity entity) {
        return (float) invoke("g", entity.getHandle());
    }

    public double e(double d0, double d1, double d2) {
        return (double) invoke("e", d0, d1, d2);
    }

    public double b(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        return (double) invoke("b", blockPosition.getHandle());
    }

    public double c(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        return (double) invoke("c", blockPosition.getHandle());
    }

    public double f(double d0, double d1, double d2) {
        return (double) invoke("f", d0, d1, d2);
    }

    public double h(Entity entity) {
        return (double) invoke("h", entity.getHandle());
    }

    // public void d(EntityHuman entityHuman) {}

    public Entity(World world) {
        super("Entity", world.getHandle());
    }

    public void collide(Entity entity) {
        invoke("collide", entity.getHandle());
    }

    public void g(double d0, double d1, double d2) {
        invoke("g", d0, d1, d2);
    }

    public void ac() {
        setField("velocityChanged", true);
    }

    // public boolean damageEntity(DamageSource damageSource, float f) {}

    public Vec3D d(float f) {
        return new Vec3D(invoke("d", f));
    }

    public Vec3D f(float f, float f1) {
        return new Vec3D(invoke("f", f, f1));
    }

    public boolean ae() {
        return (boolean) invoke("ae");
    }

    public void b(Entity entity, int i) {
        invoke("b", entity.getHandle(), i);
    }

    public boolean c(NBTTagCompound tag) {
        return (boolean) invoke("c", tag.getHandle());
    }

    public boolean save(NBTTagCompound tag) {
        return c(tag);
    }

    public boolean d(NBTTagCompound tag) {
        return (boolean) invoke("d", tag.getHandle());
    }

    public void e(NBTTagCompound tag) {
        invoke("e", tag.getHandle());
    }

    public void load(NBTTagCompound tag) {
        f(tag);
    }

    public boolean af() {
        return (boolean) invoke("af");
    }

    public String ag() {
        return (String) invoke("ag");
    }

    public void ah() { invoke("ah"); }

    @SuppressWarnings("RedundantCast")
    public NBTTagList a(double... aDouble) {
        return new NBTTagList(invoke("a", (Object) aDouble));
    }

    @SuppressWarnings("RedundantCast")
    public NBTTagList a(float... floats) {
        return new NBTTagList(invoke("a", (Object) floats));
    }

    // public EntityItem a(Item item, int i) {}

    // public EntityItem a(Item item, int i, float f) {}

    // public EntityItem a(ItemStack itemStack, float f) {}

    public boolean isAlive() {
        return (boolean) invoke("isAlive");
    }

    public boolean inBlock() {
        return (boolean) invoke("inBlock");
    }

    // public boolean e(EntityHuman entityHuman) {}

    public void f(NBTTagCompound tag) {
        invoke("f", tag.getHandle());
    }

    // public AxisAlignedBB j(Entity entity) {}

    public void ak() {
        invoke("ak");
    }

    public void al() {
        invoke("al");
    }

    public double am() {
        return (double) invoke("am");
    }

    public double an() {
        return (double) invoke("an");
    }

    public @NotNull CraftEntity getBukkitEntity() {
        return new CraftEntity(invoke("getBukkitEntity"));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void mount(xyz.acrylicstyle.nmsapi.abstracts.minecraft.@Nullable Entity entity) {
        Ref.getClass(CLASS).getMethod("mount", Entity.CLASS).invokeObj(null, entity == null ? null : entity.getHandle());
    }

    public void mount(Entity entity) {
        invoke("mount", entity.getHandle());
    }

    public float ao() {
        return (float) invoke("ao");
    }

    public Vec3D ap() {
        return Vec3D.newInstance(invoke("ap"));
    }

    public void d(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        invoke("d", blockPosition.getHandle());
    }

    public int aq() {
        return (int) invoke("aq");
    }

    public ItemStack[] getEquipment() {
        return ICollectionList.asList((Object[]) invoke("getEquipment")).map(ItemStack::new).valuesArray();
    }

    public void setEquipment(int i, ItemStack itemStack) {
        invoke("setEquipment", i, itemStack.getHandle());
    }

    public boolean isBurning() {
        return (boolean) invoke("isBurning");
    }

    @Override
    public boolean hasVehicle() {
        return getVehicle() != null;
    }

    public boolean au() {
        return (boolean) invoke("au");
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

    public boolean isInvisible() {
        return (boolean) invoke("isInvisible");
    }

    public void setInvisible(boolean flag) {
        invoke("setInvisible", flag);
    }

    public void f(boolean flag) {
        invoke("f", flag);
    }

    public boolean g(int i) {
        return (boolean) invoke("g", i);
    }

    public void b(int i, boolean flag) {
        invoke("b", i, flag);
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
                .invokeObj(null, damageSource.getHandle());
    }

    // public void onLightningStrike(EntityLightning entityLightning) {}

    // public void a(EntityLiving entityLiving) {}

    public boolean j(double d0, double d1, double d2) {
        return (boolean) invoke("j", d0, d1, d2);
    }

    public void aA() {
        invoke("aA");
    }

    public String getName() {
        return (String) invoke("getName");
    }

    @SuppressWarnings("deprecation")
    @Override
    public void sendMessage(xyz.acrylicstyle.nmsapi.abstracts.minecraft.@NotNull IChatBaseComponent iChatBaseComponent) {
        Ref.getClass(CLASS)
                .getMethod("sendMessage", xyz.acrylicstyle.nmsapi.abstracts.minecraft.IChatBaseComponent.CLASS)
                .invokeObj(null, iChatBaseComponent.getHandle());
    }

    public Entity[] aB() {
        Object o = invoke("aB");
        return o != null ? ICollectionList.asList((Object[]) o).map((Function<Object, Entity>) Entity::new).valuesArray() : null;
    }

    public boolean k(Entity entity) {
        return (boolean) invoke("k", entity.getHandle());
    }

    public float getHeadRotation() {
        return (float) invoke("getHeadRotation");
    }

    public void f(float f) {
        invoke("f", f);
    }

    public void g(float f) {
        invoke("g", f);
    }

    public boolean aD() {
        return (boolean) invoke("aD");
    }

    public boolean l(Entity entity) {
        return (boolean) invoke("l", entity.getHandle());
    }

    @Override
    public String toString() {
        return (String) invoke("toString");
    }

    // public boolean isInvulnerable(DamageSource damageSource) {}

    public void m(Entity entity) {
        invoke("m", entity.getHandle());
    }

    public void n(Entity entity) {
        invoke("n", entity.getHandle());
    }

    public void c(int i) {
        invoke("c", i);
    }

    public void teleportTo(Location exit, boolean portal) {
        invoke("teleportTo", exit, portal);
    }

    // public float a(Explosion explosion, World world, BlockPosition blockPosition, IBlockData iBlockData) {}

    // public boolean a(Explosion explosion, World world, BlockPosition blockPosition, IBlockData iBlockData, float f) {}

    public int aE() {
        return (int) invoke("aE");
    }

    public Vec3D aG() {
        return new Vec3D(invoke("aG"));
    }

    public EnumDirection aH() {
        return EnumDirection.valueOf(((Enum<?>) invoke("aH")).name());
    }

    public boolean aI() {
        return (boolean) invoke("aI");
    }

    public void appendEntityCrashDetails(CrashReportSystemDetails crashReportSystemDetails) {
        invoke("appendEntityCrashDetails", crashReportSystemDetails.getHandle());
    }

    public UUID getUniqueID() {
        return (UUID) invoke("getUniqueID");
    }

    public boolean aL() {
        return (boolean) invoke("aL");
    }

    public IChatBaseComponent getScoreboardDisplayName() {
        return new ChatComponentText(invoke("getScoreboardDisplayName"));
    }

    public void setCustomName(String s) {
        invoke("setCustomName", s);
    }

    public String getCustomName() {
        return (String) invoke("getCustomName");
    }

    public boolean hasCustomName() {
        return (boolean) invoke("hasCustomName");
    }

    public void setCustomNameVisible(boolean flag) {
        invoke("setCustomNameVisible", flag);
    }

    public boolean getCustomNameVisible() {
        return (boolean) invoke("getCustomNameVisible");
    }

    public void enderTeleportTo(double d0, double d1, double d2) {
        invoke("enderTeleportTo", d0, d1, d2);
    }

    public void i(int i) { invoke("i", i); }

    public EnumDirection getDirection() {
        return EnumDirection.valueOf(((Enum<?>) invoke("getDirection")).name());
    }

    // public ChatHoverable aQ() {}

    public boolean a(EntityPlayer entityPlayer) {
        return (boolean) invoke("a", entityPlayer.getNMSClass());
    }

    // public AxisAlignedBB getBoundingBox() {}

    // public void a(AxisAlignedBB axisAlignedBB) {}

    public float getHeadHeight() {
        return (float) invoke("getHeadHeight");
    }

    @Override
    public xyz.acrylicstyle.nmsapi.abstracts.minecraft.@NotNull Entity getEntity() {
        return this;
    }

    @Override
    public void tick() {
        invoke("tick");
    }

    @Override
    public org.bukkit.@NotNull World getBukkitWorld() {
        return world().getWorld();
    }

    @Override
    public boolean isGlowing() throws UnsupportedOperationException {
        return field("glowing");
    }

    @Override
    public void setGlowing(boolean flag) throws UnsupportedOperationException {
        setField("glowing", flag);
    }

    public boolean aT() {
        return (boolean) invoke("aT");
    }

    public void h(boolean flag) {
        invoke("h", flag);
    }

    public boolean d(int i, ItemStack itemStack) {
        return (boolean) invoke("d", i, itemStack.getHandle());
    }

    public void sendMessage(IChatBaseComponent iChatBaseComponent) {
        invoke("sendMessage", iChatBaseComponent.getHandle());
    }

    public boolean a(int i, String s) {
        return (boolean) invoke("a", i, s);
    }

    public xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition getChunkCoordinates() {
        return new BlockPosition(invoke("getChunkCoordinates"));
    }

    public Vec3D d() {
        return new Vec3D(invoke("d"));
    }

    public World getWorld() {
        return World.newInstance(invoke("getWorld"));
    }

    @Contract("-> this")
    public Entity f() {
        return this;
    }

    @Override
    public boolean getSendCommandFeedback() {
        return (boolean) invoke("getSendCommandFeedback");
    }

    // public void a(CommandObjectiveExecutor.EnumCommandResult enumCommandResult, int i) {}

    // public CommandObjectiveExecutor aU() {}

    public void o(Entity entity) {
        invoke("o", entity.getHandle());
    }

    @NotNull
    public NBTTagCompound getNBTTag() {
        Object tag = invoke("getNBTTag");
        return tag == null ? new NBTTagCompound() : new NBTTagCompound(tag);
    }

    // public boolean a(EntityHuman entityHuman, Vec3D vec3D) {}

    public boolean aW() {
        return (boolean) invoke("aW");
    }

    // public void a(EntityLiving entityLiving, Entity entity) {}

    /* Abstract methods */

    public void h() {}

    public void a(NBTTagCompound tag) {}

    public void b(NBTTagCompound tag) {}
}
