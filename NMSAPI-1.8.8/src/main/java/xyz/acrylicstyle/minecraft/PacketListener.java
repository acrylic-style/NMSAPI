package xyz.acrylicstyle.minecraft;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public interface PacketListener {
    Class<?> CLASS = getClassWithoutException("PacketListener");

    void a(IChatBaseComponent iChatBaseComponent);
    Object getNMSPacketListener();
    default Object getHandle() { return getNMSPacketListener(); }
}
