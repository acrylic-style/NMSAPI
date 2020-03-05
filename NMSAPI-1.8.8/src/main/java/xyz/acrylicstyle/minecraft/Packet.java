package xyz.acrylicstyle.minecraft;

public interface Packet {
    void a(PacketDataSerializer packetDataSerializer);
    void b(PacketDataSerializer packetDataSerializer);
    void a(PacketListener packetListener);
    Object toNMSPacket();
}
