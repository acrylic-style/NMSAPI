package xyz.acrylicstyle.nmsapi;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.mcutil.lang.MCVersion;
import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;
import xyz.acrylicstyle.nmsapi.shared.craftbukkit.entity.CraftPlayer;
import xyz.acrylicstyle.nmsapi.shared.mineraft.entity.EntityPlayer;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

public class NMSAPI extends AbstractNMSAPI {
    @NotNull private static final MCVersion version = toMCVersion(ReflectionUtil.getServerVersion());
    private static boolean warned = false;

    @Contract(pure = true)
    @NotNull
    public static EntityPlayer getEntityPlayer(@NotNull Player player) {
        if (version == MCVersion.v1_8_8) {
            return xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.entity.EntityPlayer.getInstance(player);
        } else {
            warn();
            return xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.entity.EntityPlayer.getInstance(player);
        }
    }

    @Contract(pure = true)
    @NotNull
    public static CraftPlayer getCraftPlayer(@NotNull Player player) {
        if (version == MCVersion.v1_8_8) {
            return xyz.acrylicstyle.nmsapi.v1_8_8.craftbukkit.entity.CraftPlayer.getInstance(player);
        } else {
            warn();
            return xyz.acrylicstyle.nmsapi.v1_8_8.craftbukkit.entity.CraftPlayer.getInstance(player);
        }
    }

    @Contract(pure = true)
    @NotNull
    public static MCVersion toMCVersion(@NotNull String packageName) {
        if (packageName.equals("v1_8_R3")) return MCVersion.v1_8_8;
        return MCVersion.UNKNOWN;
    }

    private static void warn() {
        if (!warned) {
            System.err.println("[NMSAPI] ==================================================");
            System.err.println("[NMSAPI]");
            System.err.println("[NMSAPI] NMSAPI does not fully support " + ReflectionUtil.getServerVersion() + ". You've been warned!");
            System.err.println("[NMSAPI]");
            System.err.println("[NMSAPI] ==================================================");
            warned = true;
        }
    }
}
