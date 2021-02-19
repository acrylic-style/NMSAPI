package xyz.acrylicstyle.nmsapi.shared.minecraft.network;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.reflect.RefClass;
import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;

public interface PlayerConnection {
    RefClass<?> CLASS = AbstractNMSAPI.nms("PlayerConnection");

    @Contract(pure = true)
    @NotNull
    NetworkManager getNetworkManager();
}
