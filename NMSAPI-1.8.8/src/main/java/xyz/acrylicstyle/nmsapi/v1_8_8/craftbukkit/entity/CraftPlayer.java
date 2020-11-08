package xyz.acrylicstyle.nmsapi.v1_8_8.craftbukkit.entity;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.reflect.RefClass;
import util.reflector.CastTo;
import util.reflector.ForwardMethod;
import util.reflector.Reflector;
import util.reflector.ReflectorHandler;
import xyz.acrylicstyle.nmsapi.shared.NMSAPI;
import xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.entity.EntityPlayer;

public interface CraftPlayer extends Player {
    RefClass<?> CLASS = NMSAPI.bukkit("entity.CraftPlayer");

    @NotNull
    static CraftPlayer getInstance(@NotNull Player player) {
        return Reflector.newReflector(null, CraftPlayer.class, new ReflectorHandler(CLASS.getClazz(), player));
    }

    @ForwardMethod("getHandle")
    @CastTo(EntityPlayer.class)
    @Contract(pure = true)
    @NotNull
    EntityPlayer getHandle();
}
