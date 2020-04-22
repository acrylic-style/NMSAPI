package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

public class PacketPlayOutEntityDestroy extends NMSAPI implements Packet<PacketListenerPlayOut> {
    public static final Class<?> CLASS = getClassWithoutException("PacketPlayOutEntityDestroy");

    private Object o;

    @SuppressWarnings("RedundantCast")
    public PacketPlayOutEntityDestroy(int... paramVarArgs) {
        super("PacketPlayOutEntityDestroy", (Object) paramVarArgs);
    }

    public PacketPlayOutEntityDestroy(Object o) {
        super(o, "PacketPlayOutEntityDestroy");
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

    // NMSAPI start
    @Override
    public Object toNMSPacket() {
        return getHandle();
    }
}
