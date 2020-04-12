package xyz.acrylicstyle.minecraft;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public interface Packet {
    Class<?> CLASS = getClassWithoutException("Packet");

    void a(PacketDataSerializer packetDataSerializer);
    void b(PacketDataSerializer packetDataSerializer);
    void a(PacketListener packetListener);
    Object toNMSPacket();
    default Object getHandle() { return toNMSPacket(); }
}
