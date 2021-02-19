package xyz.acrylicstyle.nmsapi;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.mcutil.lang.MCVersion;
import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;
import xyz.acrylicstyle.nmsapi.shared.craftbukkit.entity.CraftPlayer;
import xyz.acrylicstyle.nmsapi.shared.minecraft.entity.EntityPlayer;
import xyz.acrylicstyle.tomeito_api.utils.Log;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

public class NMSAPI extends AbstractNMSAPI {
    private static final Log.Logger LOGGER = Log.with("NMSAPI");
    private static boolean warned = false;

    @Contract(pure = true)
    @NotNull
    public static EntityPlayer getEntityPlayer(@NotNull Player player) {
        if (VERSION == MCVersion.v1_8_8) {
            return xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.entity.EntityPlayer.getInstance(player);
        } else {
            warn();
            return xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.entity.EntityPlayer.getInstance(player);
        }
    }

    @Contract(pure = true)
    @NotNull
    public static CraftPlayer getCraftPlayer(@NotNull Player player) {
        if (VERSION == MCVersion.v1_8_8) {
            return xyz.acrylicstyle.nmsapi.v1_8_8.craftbukkit.entity.CraftPlayer.getInstance(player);
        } else {
            warn();
            return xyz.acrylicstyle.nmsapi.v1_8_8.craftbukkit.entity.CraftPlayer.getInstance(player);
        }
    }

    private static void warn() {
        if (!warned) {
            LOGGER.warn("==================================================");
            LOGGER.warn("");
            LOGGER.warn("NMSAPI does not fully support " + ReflectionUtil.getServerVersion() + ". You've been warned!");
            LOGGER.warn("");
            LOGGER.warn("==================================================");
            warned = true;
        }
    }
}
