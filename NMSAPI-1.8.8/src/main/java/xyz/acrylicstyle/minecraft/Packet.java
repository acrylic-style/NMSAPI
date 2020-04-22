package xyz.acrylicstyle.minecraft;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public interface Packet<T extends PacketListener> {
    Class<?> CLASS = getClassWithoutException("Packet");

    void a(PacketDataSerializer packetDataSerializer);
    void b(PacketDataSerializer packetDataSerializer);
    void a(T t);
    Object toNMSPacket();
    default Object getHandle() { return toNMSPacket(); }
}
