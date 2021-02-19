package xyz.acrylicstyle.nmsapi.v1_8_8.craftbukkit.entity;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.reflector.CastTo;
import util.reflector.ForwardMethod;
import util.reflector.Reflector;
import util.reflector.ReflectorHandler;
import xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.entity.EntityPlayer;

public interface CraftPlayer extends xyz.acrylicstyle.nmsapi.shared.craftbukkit.entity.CraftPlayer, CraftEntity, Player {
    @NotNull
    static CraftPlayer getInstance(@NotNull Player player) {
        return Reflector.newReflector(null, CraftPlayer.class, new ReflectorHandler(xyz.acrylicstyle.nmsapi.shared.craftbukkit.entity.CraftPlayer.CLASS.getClazz(), player));
    }

    @ForwardMethod("getHandle")
    @CastTo(EntityPlayer.class)
    @Contract(pure = true)
    @NotNull
    @Override
    EntityPlayer getHandle();
}
