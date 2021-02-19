package xyz.acrylicstyle.nmsapi.shared.minecraft.network;

import io.netty.channel.Channel;
import org.jetbrains.annotations.Contract;
import util.reflect.RefClass;
import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;

public interface NetworkManager {
    RefClass<?> CLASS = AbstractNMSAPI.nms("NetworkManager");

    @Contract(pure = true)
    Channel getChannel();
}
