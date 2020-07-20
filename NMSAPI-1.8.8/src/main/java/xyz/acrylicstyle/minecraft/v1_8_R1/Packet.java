package xyz.acrylicstyle.minecraft.v1_8_R1;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public interface Packet<T extends PacketListener> {
    Class<?> CLASS = getClassWithoutException("Packet");

    void a(PacketDataSerializer packetDataSerializer);
    void b(PacketDataSerializer packetDataSerializer);
    void a(T t);
    Object toNMSPacket();
    default Object getHandle() { return toNMSPacket(); }

    static Packet<?> getInstance(Object o) {
        if (o.getClass().isAssignableFrom(PacketPlayOutChat.CLASS)) {
            return new PacketPlayOutChat(o);
        } else if (o.getClass().isAssignableFrom(PacketPlayOutPlayerInfo.CLASS)) {
            return new PacketPlayOutPlayerInfo(o);
        } else if (o.getClass().isAssignableFrom(PacketPlayOutNamedEntitySpawn.CLASS)) {
            return new PacketPlayOutNamedEntitySpawn(o);
        } else if (o.getClass().isAssignableFrom(PacketPlayOutEntityDestroy.CLASS)) {
            return new PacketPlayOutEntityDestroy(o);
        } else {
            System.err.println("Unknown packet class: " + o.getClass().getCanonicalName());
            return null;
        }
    }
}
