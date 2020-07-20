package xyz.acrylicstyle.minecraft.v1_8_R1;

import xyz.acrylicstyle.shared.NMSAPI;

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
