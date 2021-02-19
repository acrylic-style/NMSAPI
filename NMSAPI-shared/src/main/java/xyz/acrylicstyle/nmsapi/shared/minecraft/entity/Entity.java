package xyz.acrylicstyle.nmsapi.shared.minecraft.entity;

import util.reflect.RefClass;
import util.reflector.CastTo;
import util.reflector.FieldGetter;
import util.reflector.FieldSetter;
import util.reflector.ForwardMethod;
import xyz.acrylicstyle.mcutil.lang.MCVersion;
import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;

import java.util.UUID;

public interface Entity {
    RefClass<?> CLASS = AbstractNMSAPI.nms("Entity");

    @ForwardMethod("isFireProof")
    boolean isFireProof();

    boolean isInWater();

    @ForwardMethod("setLocation")
    void setLocation(double x, double y, double z, float yaw, float pitch);

    void setPositionRotation(double x, double y, double z, float yaw, float pitch);

    boolean isSneaking();

    void setSneaking(boolean flag);

    boolean isSprinting();

    void setSprinting(boolean flag);

    boolean isInvisible();

    void setInvisible(boolean flag);

    int getAirTicks();

    void setAirTicks(int ticks);

    @ForwardMethod("getName")
    String getName();

    String getCustomName();

    void setCustomName(String name);

    boolean hasCustomName();

    UUID getUniqueID();

    @FieldGetter("dimension")
    int getDimension();

    @FieldGetter("valid")
    boolean isValid();

    @FieldGetter("noclip")
    boolean isNoClip();

    @FieldGetter("onGround")
    boolean isOnGround();

    // These methods works until 1.16.5

    @FieldGetter("dead")
    boolean getDeadFlag();

    @FieldSetter("dead")
    void setDeadFlag(boolean flag);

    // These methods works only on 1.17+

    @FieldGetter("dead")
    @CastTo(value = RemovalReason.class, createInstance = true)
    RemovalReason getDeadState();

    @FieldSetter("dead")
    void setDeadState(@ForwardMethod("getHandle") RemovalReason reason);

    class RemovalReason {
        static {
            if (AbstractNMSAPI.VERSION.ordinal() > MCVersion.SNAPSHOT_20W45A.ordinal()) {
                throw new UnsupportedOperationException("Unsupported Minecraft Version: " + AbstractNMSAPI.VERSION.getName());
            }
        }

        public static final RemovalReason KILLED = new RemovalReason("KILLED");
        public static final RemovalReason DISCARDED = new RemovalReason("DISCARDED");
        public static final RemovalReason UNLOADED_TO_CHUNK = new RemovalReason("UNLOADED_TO_CHUNK");
        public static final RemovalReason UNLOADED_WITH_PLAYER = new RemovalReason("UNLOADED_WITH_PLAYER");
        public static final RemovalReason CHANGED_DIMENSION = new RemovalReason("CHANGED_DIMENSION");

        private final Object handle;

        private RemovalReason(String name) {
            this.handle = AbstractNMSAPI.nms("Entity$RemovalReason").getField(name).get(null);
        }

        @SuppressWarnings("unused")
        public RemovalReason(Object o) { // -> @CastTo(value = RemovalReason.class, createInstance = true)
            this.handle = o;
        }

        public String name() {
            return ((Enum<?>) this.handle).name();
        }

        public Object getHandle() { // -> @ForwardMethod("getHandle")
            return handle;
        }
    }
}
