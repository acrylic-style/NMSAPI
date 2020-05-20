package xyz.acrylicstyle.minecraft;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.entity.CraftPlayer;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@SuppressWarnings("unused")
public class PlayerConnection extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("PlayerConnection");

    public EntityPlayer player;
    private final MinecraftServer minecraftServer;
    public NetworkManager networkManager;

    public PlayerConnection(@NotNull EntityPlayer player) {
        super(player.__playerConnection, "PlayerConnection");
        this.player = player;
        this.minecraftServer = player.server;
        this.networkManager = new NetworkManager(getField("networkManager"));
    }

    public PlayerConnection(MinecraftServer minecraftServer, NetworkManager networkManager, EntityPlayer entityPlayer) {
        super("PlayerConnection", minecraftServer.getHandle(), networkManager.getHandle(), entityPlayer.getHandle());
        this.player = entityPlayer;
        this.minecraftServer = minecraftServer;
        this.networkManager = networkManager;
    }

    public CraftPlayer getPlayer() {
        return this.player == null ? null : this.player.getBukkitEntity();
    }

    public MinecraftServer getMinecraftServer() {
        return this.minecraftServer;
    }

    public void tick() {
        invoke("tick");
    }

    public void syncPosition() {
        invoke("syncPosition");
    }

    public NetworkManager a() {
        return this.networkManager;
    }

    public NetworkManager getNetworkManager() {
        return this.networkManager;
    }

    public boolean isExemptPlayer() {
        return (boolean) invoke("isExemptPlayer");
    }

    public void disconnect(IChatBaseComponent iChatBaseComponent) {
        method("disconnect", IChatBaseComponent.CLASS).invokeObj(getHandle(), iChatBaseComponent.getHandle());
    }

    public void sendPacket(@NotNull Packet<?> packet) { method("sendPacket", Packet.CLASS).invokeObj(getHandle(), packet.getHandle()); }

    public void disconnect(String s) { invoke("disconnect", s); }

    public void a(Object packetPlayInSteerVehicle) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSteerVehicle"))
                    .invoke(getHandle(), packetPlayInSteerVehicle);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean b(Object packetPlayInFlying) {
        try {
            return (boolean) ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("b", ReflectionUtil.getNMSClass("PacketPlayInFlying"))
                    .invoke(null, packetPlayInFlying);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @apiNote Original Method name: PlayerConnection#b(PacketPlayerInVehicleMove)
     */
    public static boolean b2(Object packetPlayerInVehicleMove) {
        try {
            return (boolean) ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("b", ReflectionUtil.getNMSClass("PacketPlayerInVehicleMove"))
                    .invoke(null, packetPlayerInVehicleMove);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @apiNote Original method name: PlayerConnection#a(PacketPlayInVehicleMove)
     */
    public void a2(Object packetPlayInVehicleMove) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInVehicleMove"))
                    .invoke(getHandle(), packetPlayInVehicleMove);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a3(Object packetPlayInTeleportAccept) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInTeleportAccept"))
                    .invoke(getHandle(), packetPlayInTeleportAccept);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a4(Object packetPlayInRecipeDisplayed) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInRecipeDisplayed"))
                    .invoke(getHandle(), packetPlayInRecipeDisplayed);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a5(Object packetPlayInAdvancements) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInAdvancements"))
                    .invoke(getHandle(), packetPlayInAdvancements);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a6(Object packetPlayInTabComplete) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInTabComplete"))
                    .invoke(getHandle(), packetPlayInTabComplete);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a7(Object packetPlayInSetCommandBlock) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSetCommandBlock"))
                    .invoke(getHandle(), packetPlayInSetCommandBlock);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a8(Object packetPlayInSetCommandMinecart) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSetCommandMinecart"))
                    .invoke(getHandle(), packetPlayInSetCommandMinecart);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a9(Object packetPlayInPickItem) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInPickItem"))
                    .invoke(getHandle(), packetPlayInPickItem);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a10(Object packetPlayInItemName) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInItemName"))
                    .invoke(getHandle(), packetPlayInItemName);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a11(Object packetPlayInBeacon) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInBeacon"))
                    .invoke(getHandle(), packetPlayInBeacon);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a12(Object packetPlayInStruct) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInStruct"))
                    .invoke(getHandle(), packetPlayInStruct);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a13(Object packetPlayInSetJigsaw) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSetJigsaw"))
                    .invoke(getHandle(), packetPlayInSetJigsaw);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a14(Object packetPlayInTrSel) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInTrSel"))
                    .invoke(getHandle(), packetPlayInTrSel);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a15(Object packetPlayInBEdit) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInBEdit"))
                    .invoke(getHandle(), packetPlayInBEdit);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a16(Object packetPlayInEntityNBTQuery) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInEntityNBTQuery"))
                    .invoke(getHandle(), packetPlayInEntityNBTQuery);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a17(Object packetPlayInTileNBTQuery) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInTileNBTQuery"))
                    .invoke(getHandle(), packetPlayInTileNBTQuery);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a18(Object packetPlayInFlying) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInFlying"))
                    .invoke(getHandle(), packetPlayInFlying);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean a19(Object iWorldReader) {
        try {
            return (boolean) ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("IWorldReader"))
                    .invoke(getHandle(), iWorldReader);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(double d0, double d1, double d2, float f, float f1) {
        invoke("a", d0, d1, d2, f, f1);
    }

    public void a(double d0, double d1, double d2, float f, float f1, PlayerTeleportEvent.TeleportCause cause) {
        invoke("a", d0, d1, d2, f, f1, cause);
    }

    public void a(double d0, double d1, double d2, float f, float f1, Set<Object> packetPlayOutPositionEnumPlayerTeleportFlagsSet) {
        throw new UnsupportedOperationException(); // TODO: Not implemented
    }

    public void a(double d0, double d1, double d2, float f, float f1, Set<Object> packetPlayOutPositionEnumPlayerTeleportFlagsSet, PlayerTeleportEvent.TeleportCause cause) {
        throw new UnsupportedOperationException();
    }

    public void teleport(Location dest) {
        invoke("teleport", dest);
    }

    public void internalTeleport(double d0, double d1, double d2, float f, float f1, Set<Object> packetPlayOutPositionEnumPlayerTeleportFlagsSet) {
        throw new UnsupportedOperationException();
    }

    public void a20(Object packetPlayInBlockDig) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInBlockDig"))
                    .invoke(getHandle(), packetPlayInBlockDig);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean checkLimit(long timestamp) {
        return (boolean) invoke("checkLimit", timestamp);
    }

    public void a21(Object packetPlayInUseItem) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInUseItem"))
                    .invoke(getHandle(), packetPlayInUseItem);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a22(Object packetPlayInBlockPlace) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInBlockPlace"))
                    .invoke(getHandle(), packetPlayInBlockPlace);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a23(Object packetPlayInSpectate) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSpectate"))
                    .invoke(getHandle(), packetPlayInSpectate);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a24(Object packetPlayInResourcePackStatus) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInResourcePackStatus"))
                    .invoke(getHandle(), packetPlayInResourcePackStatus);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a25(Object packetPlayInBoatMove) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInBoatMove"))
                    .invoke(getHandle(), packetPlayInBoatMove);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a(IChatBaseComponent iChatBaseComponent) {
        method("a", IChatBaseComponent.CLASS).invokeObj(getHandle(), iChatBaseComponent.getHandle());
    }

    public void a(Packet<?> packet, @Nullable GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        method("a", Packet.CLASS, GenericFutureListener.class).invokeObj(getHandle(), packet.getHandle(), genericFutureListener);
    }

    public void a27(Object packetPlayInHeldItemSlot) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInHeldItemSlot"))
                    .invoke(getHandle(), packetPlayInHeldItemSlot);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a28(Object packetPlayInChat) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInChat"))
                    .invoke(getHandle(), packetPlayInChat);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void chat(String s, boolean async) {
        invoke("chat", s, async);
    }

    public void handleCommand(String s) {
        invoke("handleCommand", s);
    }

    public void a29(Object packetPlayInArmAnimation) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInArmAnimation"))
                    .invoke(getHandle(), packetPlayInArmAnimation);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a30(Object packetPlayInEntityAction) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInEntityAction"))
                    .invoke(getHandle(), packetPlayInEntityAction);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a31(Object packetPlayInUseEntity) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInUseEntity"))
                    .invoke(getHandle(), packetPlayInUseEntity);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a32(Object packetPlayInClientCommand) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInClientCommand"))
                    .invoke(getHandle(), packetPlayInClientCommand);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a33(Object packetPlayInCloseWindow) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInCloseWindow"))
                    .invoke(getHandle(), packetPlayInCloseWindow);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a34(Object packetPlayInWindowClick) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInWindowClick"))
                    .invoke(getHandle(), packetPlayInWindowClick);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a35(Object packetPlayInAutoRecipe) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInAutoRecipe"))
                    .invoke(getHandle(), packetPlayInAutoRecipe);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a36(Object packetPlayInEnchantItem) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInEnchantItem"))
                    .invoke(getHandle(), packetPlayInEnchantItem);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a37(Object packetPlayInSetCreativeSlot) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSetCreativeSlot"))
                    .invoke(getHandle(), packetPlayInSetCreativeSlot);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a38(Object packetPlayInTransaction) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInTransaction"))
                    .invoke(getHandle(), packetPlayInTransaction);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a39(Object packetPlayInUpdateSign) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInUpdateSign"))
                    .invoke(getHandle(), packetPlayInUpdateSign);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a40(Object packetPlayInKeepAlive) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInKeepAlive"))
                    .invoke(getHandle(), packetPlayInKeepAlive);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a41(Object packetPlayInAbilities) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInAbilities"))
                    .invoke(getHandle(), packetPlayInAbilities);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a42(Object packetPlayInSettings) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSettings"))
                    .invoke(getHandle(), packetPlayInSettings);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a43(Object packetPlayInCustomPayload) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInCustomPayload"))
                    .invoke(getHandle(), packetPlayInCustomPayload);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a44(Object packetPlayInDifficultyChange) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInDifficultyChange"))
                    .invoke(getHandle(), packetPlayInDifficultyChange);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a45(Object packetPlayInDifficultyLock) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInDifficultyLock"))
                    .invoke(getHandle(), packetPlayInDifficultyLock);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isDisconnected() {
        return (boolean) invoke("isDisconnected");
    }
}
