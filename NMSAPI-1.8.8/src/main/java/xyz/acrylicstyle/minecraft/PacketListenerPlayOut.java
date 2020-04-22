package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.shared.NMSAPI;

public interface PacketListenerPlayOut extends PacketListener {
    Class<?> CLASS = NMSAPI.getClassWithoutException("PacketListenerPlayOut");

    void a(PacketPlayOutEntityDestroy paramPacketPlayOutEntityDestroy);

    void a(PacketPlayOutNamedEntitySpawn paramPacketPlayOutNamedEntitySpawn);

    void a(PacketPlayOutPlayerInfo paramPacketPlayOutPlayerInfo);
}
