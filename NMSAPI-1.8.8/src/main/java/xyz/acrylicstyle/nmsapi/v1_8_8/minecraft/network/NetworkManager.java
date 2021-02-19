package xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.network;

import io.netty.channel.Channel;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.reflector.FieldGetter;
import util.reflector.FieldSetter;
import util.reflector.ForwardMethod;

import java.net.SocketAddress;

public interface NetworkManager extends xyz.acrylicstyle.nmsapi.shared.minecraft.network.NetworkManager {
    @FieldGetter("channel")
    @Contract(pure = true)
    @Override
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
