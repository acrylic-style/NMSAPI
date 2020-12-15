package xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.network;

import io.netty.channel.Channel;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.reflect.RefClass;
import util.reflector.FieldGetter;
import util.reflector.FieldSetter;
import util.reflector.ForwardMethod;
import xyz.acrylicstyle.nmsapi.shared.NMSAPI;

import java.net.SocketAddress;

public interface NetworkManager {
    RefClass<?> CLASS = NMSAPI.nms("NetworkManager");

    @FieldGetter("channel")
    @Contract(pure = true)
    Channel getChannel();

    @FieldSetter("channel")
    void setChannel(@NotNull Channel channel);

    @FieldGetter("l")
    @Contract(pure = true)
    SocketAddress getSocketAddress();

    @ForwardMethod("getRawAddress")
    @Contract(pure = true)
    SocketAddress getRawAddress();

    @ForwardMethod("g")
    boolean isChannelOpen();

    @ForwardMethod("k")
    void disableAutoRead();
}
