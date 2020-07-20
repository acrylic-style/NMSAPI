package xyz.acrylicstyle.minecraft.v1_12_R1;

public interface Packet {
    void a(PacketDataSerializer packetDataSerializer);
    void b(PacketDataSerializer packetDataSerializer);
    void a(PacketListener packetListener);
    Object toNMSPacket();
}
