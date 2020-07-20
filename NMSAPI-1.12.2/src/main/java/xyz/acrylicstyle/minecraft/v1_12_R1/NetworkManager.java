package xyz.acrylicstyle.minecraft.v1_12_R1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.GenericFutureListener;
import org.jetbrains.annotations.Nullable;
import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import javax.crypto.SecretKey;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketAddress;
import java.util.concurrent.Future;

@SuppressWarnings("unused")
public class NetworkManager {
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

    public void channelRead0(ChannelHandlerContext channelHandlerContext, Packet packet) {
        try {
            ReflectionUtil
                    .getNMSClass("NetworkManager")
                    .getMethod("channelRead0", channelHandlerContext.getClass(), ReflectionUtil.getNMSClass("Packet"))
                    .invoke(o, channelHandlerContext, packet.toNMSPacket());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void a(Packet packet, PacketListener packetListener) {
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
        try {
            ReflectionUtil
                    .getNMSClass("NetworkManager")
                    .getMethod("setPacketListener", ReflectionUtil.getNMSClass("PacketListener"))
                    .invoke(o, packetListener.getNMSPacketListener());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendPacket(Packet packet) {
        try {
            ReflectionUtil
                    .getNMSClass("NetworkManager")
                    .getMethod("sendPacket", ReflectionUtil.getNMSClass("Packet"))
                    .invoke(o, packet.toNMSPacket());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendPacket(Packet packet, @Nullable GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        try {
            ReflectionUtil
                    .getNMSClass("NetworkManager")
                    .getMethod("sendPacket", ReflectionUtil.getNMSClass("Packet"), genericFutureListener == null ? null : genericFutureListener.getClass())
                    .invoke(o, packet.toNMSPacket(), genericFutureListener);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void b(Packet packet, @Nullable GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        try {
            ReflectionUtil
                    .getNMSClass("NetworkManager")
                    .getMethod("b", ReflectionUtil.getNMSClass("Packet"), genericFutureListener == null ? null : genericFutureListener.getClass())
                    .invoke(o, packet.toNMSPacket(), genericFutureListener);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    public void close(IChatBaseComponent iChatBaseComponent) {
        try {
            ReflectionUtil
                    .getNMSClass("NetworkManager")
                    .getMethod("close", ReflectionUtil.getNMSClass("IChatBaseComponent"))
                    .invoke(o, iChatBaseComponent.getIChatBaseComponent());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    public Object getIChatBaseComponent() {
        return j();
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

    // NMSAPI start
    private Object o;
    public NetworkManager(Object o) {
        this.o = o;
    }

    public Object getNetworkManager() {
        if (o.getClass().getSimpleName().equals("NetworkManager")) return o;
        try {
            return o.getClass().getField("networkManager").get(o);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("NetworkManager"), getNetworkManager(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("NetworkManager")
                    .getMethod(method)
                    .invoke(getNetworkManager());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            ReflectionUtil.getNMSClass("NetworkManager")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getNetworkManager(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // NMSAPI end
}
