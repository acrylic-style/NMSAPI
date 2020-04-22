package xyz.acrylicstyle.minecraft;

import org.jetbrains.annotations.NotNull;
import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class PacketPlayOutNamedEntitySpawn extends NMSAPI implements Packet<PacketListenerPlayOut> {
    public static final Class<?> CLASS = getClassWithoutException("PacketPlayOutNamedEntitySpawn");

    public PacketPlayOutNamedEntitySpawn(@NotNull EntityPlayer entityPlayer) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        super(ReflectionUtil.getNMSClass("PacketPlayOutNamedEntitySpawn")
                .getConstructor(ReflectionUtil.getNMSClass("EntityHuman"))
                .newInstance(entityPlayer.getEntityHuman()), "PacketPlayOutNamedEntitySpawn");
    }

    public PacketPlayOutNamedEntitySpawn(@NotNull Object o) {
        super(o, "PacketPlayOutNamedEntitySpawn");
    }

    public void a(PacketDataSerializer packetDataSerializer) {
        invoke("a", packetDataSerializer.getNMSClass());
    }

    public void b(PacketDataSerializer packetDataSerializer) {
        invoke("b", packetDataSerializer.getNMSClass());
    }

    @Override
    public void a(PacketListenerPlayOut packetListener) {
        packetListener.a(this);
    }

    @Override
    public Object toNMSPacket() {
        return getHandle();
    }
}
