package xyz.acrylicstyle.minecraft.v1_15_R1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.GenericFutureListener;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import javax.crypto.SecretKey;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketAddress;
import java.util.concurrent.Future;

@SuppressWarnings("unused")
public class NetworkManager extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("NetworkManager");

    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        invoke("channelActive", channelHandlerContext);
    }

    public void setProtocol(Object enumProtocol) {
        try {
            ReflectionUtil
                    .getNMSClass("NetworkManager")
                    .getMethod("setProtocol", ReflectionUtil.getNMSClass("EnumProtocol"))
                    .invoke(o, enumProtocol);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        invoke("channelInactive", channelHandlerContext);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {
        invoke("exceptionCaught", channelHandlerContext, throwable);
    }

    public void channelRead0(ChannelHandlerContext channelHandlerContext, Packet<?> packet) {
        invoke("channelRead0", channelHandlerContext, packet.getHandle());
    }

    public static void a(Packet<?> packet, PacketListener packetListener) {
        try {
            ReflectionUtil
                    .getNMSClass("NetworkManager")
                    .getMethod("a", ReflectionUtil.getNMSClass("Packet"), ReflectionUtil.getNMSClass("PacketListener"))
                    .invoke(null, packet.toNMSPacket(), packetListener.getNMSPacketListener());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setPacketListener(PacketListener packetListener) {
        invoke("setPacketListener", packetListener.getHandle());
    }

    public void sendPacket(Packet<?> packet) {
        method("sendPacket", Packet.CLASS).invokeObj(getHandle(), packet.getHandle());
    }

    public void sendPacket(Packet<?> packet, @Nullable GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        method("sendPacket", Packet.CLASS, GenericFutureListener.class).invokeObj(getHandle(), packet.getHandle(), genericFutureListener);
    }

    public void b(Packet<?> packet, @Nullable GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        method("b", Packet.CLASS, GenericFutureListener.class).invokeObj(getHandle(), packet.getHandle(), genericFutureListener);
    }

    public void o() {
        invoke("o");
    }

    public void a() {
        invoke("a");
    }

    public SocketAddress getSocketAddress() {
        return (SocketAddress) getField("socketAddress");
    }

    public void close(xyz.acrylicstyle.minecraft.v1_15_R1.IChatBaseComponent iChatBaseComponent) {
        method("close", xyz.acrylicstyle.minecraft.v1_15_R1.IChatBaseComponent.CLASS).invokeObj(getHandle(), iChatBaseComponent.getHandle());
    }

    public boolean isLocal() {
        return (boolean) invoke("isLocal");
    }

    public void a(SecretKey secretKey) {
        invoke("a", secretKey);
    }

    public boolean isConnected() {
        return (boolean) invoke("isConnected");
    }

    public boolean h() {
        return (boolean) invoke("h");
    }

    public boolean isChannelNull() {
        return h();
    }

    public Object i() {
        return getField("packetListener");
    }

    public Object getPacketListener() {
        return i();
    }

    public Object j() {
        return getField("m");
    }

    public xyz.acrylicstyle.minecraft.v1_15_R1.IChatBaseComponent getIChatBaseComponent() {
        return IChatBaseComponent.getInstance(j());
    }

    public void stopReading() {
        invoke("stopReading");
    }

    public void setCompressionLevel(int i) {
        invoke("setCompressionLevel", i);
    }

    public void handleDisconnection() {
        invoke("handleDisconnection");
    }

    public SocketAddress getRawAddress() {
        try {
            return (SocketAddress) getField("channel").getClass().getMethod("remoteAddress").invoke(getField("channel"));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public NetworkManager(Object o) {
        super(o, "NetworkManager");
    }
}
