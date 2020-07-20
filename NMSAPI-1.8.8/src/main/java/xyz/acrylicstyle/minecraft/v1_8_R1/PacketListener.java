package xyz.acrylicstyle.minecraft.v1_8_R1;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public interface PacketListener {
    Class<?> CLASS = getClassWithoutException("PacketListener");

    void a(IChatBaseComponent iChatBaseComponent);
    Object getNMSPacketListener();
    default Object getHandle() { return getNMSPacketListener(); }
}
