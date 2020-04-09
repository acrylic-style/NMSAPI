package xyz.acrylicstyle.minecraft;

public interface PacketListener {
    void a(IChatBaseComponent iChatBaseComponent);
    Object getNMSPacketListener();
    default Object getHandle() { return getNMSPacketListener(); }
}
