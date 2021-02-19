package xyz.acrylicstyle.nmsapi.shared.minecraft.network;

import io.netty.channel.Channel;
import org.jetbrains.annotations.Contract;

public interface NetworkManager {
    @Contract(pure = true)
    Channel getChannel();
}
