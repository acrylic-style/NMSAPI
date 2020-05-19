package xyz.acrylicstyle.minecraft.v1_15_R1;

import net.md_5.bungee.api.chat.BaseComponent;
import xyz.acrylicstyle.shared.NMSAPI;

public class PacketPlayOutChat extends NMSAPI implements Packet<PacketListenerPlayOut> {
    public static final Class<?> CLASS = getClassWithoutException("PacketPlayOutChat");

    public BaseComponent[] components;

    public PacketPlayOutChat(Object o) {
        super(o, "PacketPlayOutChat");
    }

    public PacketPlayOutChat() {
        super("PacketPlayOutChat");
    }

    public PacketPlayOutChat(xyz.acrylicstyle.minecraft.v1_15_R1.IChatBaseComponent iChatBaseComponent) {
        this(iChatBaseComponent, (byte) 1);
    }

    public BaseComponent[] getComponents() { return field("components"); } // NMSAPI - getter for nms components field

    private static Object callCtor(xyz.acrylicstyle.minecraft.v1_15_R1.IChatBaseComponent iChatBaseComponent, byte b0) {
        try {
            return CLASS.getConstructor(xyz.acrylicstyle.minecraft.v1_15_R1.IChatBaseComponent.CLASS, byte.class).newInstance(iChatBaseComponent, b0);
        } catch (ReflectiveOperationException e) { throw new RuntimeException(e); }
    }

    public PacketPlayOutChat(IChatBaseComponent iChatBaseComponent, byte b0) {
        super(callCtor(iChatBaseComponent, b0), "PacketPlayOutChat");
    }

    @Override
    public void a(PacketDataSerializer packetDataSerializer) {
        invoke("a", packetDataSerializer.getHandle());
    }

    @Override
    public void b(PacketDataSerializer packetDataSerializer) {
        invoke("b", packetDataSerializer.getHandle());
    }

    @Override
    public void a(PacketListenerPlayOut packetListenerPlayOut) {
        packetListenerPlayOut.a(this);
    }

    @Override
    public Object toNMSPacket() {
        return super.getHandle();
    }

    public boolean b() {
        return (boolean) invoke("b");
    }
}
