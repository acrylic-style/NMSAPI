package xyz.acrylicstyle.nmsapi.shared.craftbukkit.entity;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.nmsapi.shared.mineraft.entity.EntityPlayer;

public interface CraftPlayer {
    @Contract(pure = true)
    @NotNull
    EntityPlayer getHandle();
}
