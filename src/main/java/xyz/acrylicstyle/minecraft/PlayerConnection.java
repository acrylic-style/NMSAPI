package xyz.acrylicstyle.minecraft;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.jetbrains.annotations.Nullable;
import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.craftbukkit.CraftPlayer;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@SuppressWarnings("unused")
public class PlayerConnection {
    public EntityPlayer player;
    private final MinecraftServer minecraftServer;
    public NetworkManager networkManager = null;

    public PlayerConnection(EntityPlayer player) {
        this.player = player;
        minecraftServer = new MinecraftServer(player.getEntityPlayer());
        try {
            networkManager = new NetworkManager(this.getPlayerConnection().getClass().getField("networkManager").get(this.getPlayerConnection()));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
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

    public void disconnect(Object iChatBaseComponent) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("disconnect", ReflectionUtil.getNMSClass("IChatBaseComponent"))
                    .invoke(getPlayerConnection(), iChatBaseComponent);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(String s) {
        invoke("disconnect", s);
    }

    public void a(Object packetPlayInSteerVehicle) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSteerVehicle"))
                    .invoke(getPlayerConnection(), packetPlayInSteerVehicle);
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
                    .invoke(getPlayerConnection(), packetPlayInVehicleMove);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a3(Object packetPlayInTeleportAccept) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInTeleportAccept"))
                    .invoke(getPlayerConnection(), packetPlayInTeleportAccept);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a4(Object packetPlayInRecipeDisplayed) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInRecipeDisplayed"))
                    .invoke(getPlayerConnection(), packetPlayInRecipeDisplayed);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a5(Object packetPlayInAdvancements) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInAdvancements"))
                    .invoke(getPlayerConnection(), packetPlayInAdvancements);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a6(Object packetPlayInTabComplete) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInTabComplete"))
                    .invoke(getPlayerConnection(), packetPlayInTabComplete);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a7(Object packetPlayInSetCommandBlock) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSetCommandBlock"))
                    .invoke(getPlayerConnection(), packetPlayInSetCommandBlock);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a8(Object packetPlayInSetCommandMinecart) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSetCommandMinecart"))
                    .invoke(getPlayerConnection(), packetPlayInSetCommandMinecart);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a9(Object packetPlayInPickItem) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInPickItem"))
                    .invoke(getPlayerConnection(), packetPlayInPickItem);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a10(Object packetPlayInItemName) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInItemName"))
                    .invoke(getPlayerConnection(), packetPlayInItemName);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a11(Object packetPlayInBeacon) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInBeacon"))
                    .invoke(getPlayerConnection(), packetPlayInBeacon);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a12(Object packetPlayInStruct) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInStruct"))
                    .invoke(getPlayerConnection(), packetPlayInStruct);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a13(Object packetPlayInSetJigsaw) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSetJigsaw"))
                    .invoke(getPlayerConnection(), packetPlayInSetJigsaw);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a14(Object packetPlayInTrSel) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInTrSel"))
                    .invoke(getPlayerConnection(), packetPlayInTrSel);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a15(Object packetPlayInBEdit) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInBEdit"))
                    .invoke(getPlayerConnection(), packetPlayInBEdit);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a16(Object packetPlayInEntityNBTQuery) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInEntityNBTQuery"))
                    .invoke(getPlayerConnection(), packetPlayInEntityNBTQuery);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a17(Object packetPlayInTileNBTQuery) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInTileNBTQuery"))
                    .invoke(getPlayerConnection(), packetPlayInTileNBTQuery);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a18(Object packetPlayInFlying) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInFlying"))
                    .invoke(getPlayerConnection(), packetPlayInFlying);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean a19(Object iWorldReader) {
        try {
            return (boolean) ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("IWorldReader"))
                    .invoke(getPlayerConnection(), iWorldReader);
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
                    .invoke(getPlayerConnection(), packetPlayInBlockDig);
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
                    .invoke(getPlayerConnection(), packetPlayInUseItem);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a22(Object packetPlayInBlockPlace) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInBlockPlace"))
                    .invoke(getPlayerConnection(), packetPlayInBlockPlace);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a23(Object packetPlayInSpectate) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSpectate"))
                    .invoke(getPlayerConnection(), packetPlayInSpectate);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a24(Object packetPlayInResourcePackStatus) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInResourcePackStatus"))
                    .invoke(getPlayerConnection(), packetPlayInResourcePackStatus);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a25(Object packetPlayInBoatMove) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInBoatMove"))
                    .invoke(getPlayerConnection(), packetPlayInBoatMove);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a26(Object iChatBaseComponent) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("IChatBaseComponent"))
                    .invoke(getPlayerConnection(), iChatBaseComponent);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendPacket(Object packet) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("Packet"))
                    .invoke(getPlayerConnection(), packet);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a(Object packet, @Nullable GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("Packet"), genericFutureListener == null ? null : genericFutureListener.getClass())
                    .invoke(getPlayerConnection(), packet, genericFutureListener);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a27(Object packetPlayInHeldItemSlot) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInHeldItemSlot"))
                    .invoke(getPlayerConnection(), packetPlayInHeldItemSlot);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a28(Object packetPlayInChat) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInChat"))
                    .invoke(getPlayerConnection(), packetPlayInChat);
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
                    .invoke(getPlayerConnection(), packetPlayInArmAnimation);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a30(Object packetPlayInEntityAction) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInEntityAction"))
                    .invoke(getPlayerConnection(), packetPlayInEntityAction);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a31(Object packetPlayInUseEntity) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInUseEntity"))
                    .invoke(getPlayerConnection(), packetPlayInUseEntity);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a32(Object packetPlayInClientCommand) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInClientCommand"))
                    .invoke(getPlayerConnection(), packetPlayInClientCommand);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a33(Object packetPlayInCloseWindow) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInCloseWindow"))
                    .invoke(getPlayerConnection(), packetPlayInCloseWindow);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a34(Object packetPlayInWindowClick) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInWindowClick"))
                    .invoke(getPlayerConnection(), packetPlayInWindowClick);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a35(Object packetPlayInAutoRecipe) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInAutoRecipe"))
                    .invoke(getPlayerConnection(), packetPlayInAutoRecipe);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a36(Object packetPlayInEnchantItem) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInEnchantItem"))
                    .invoke(getPlayerConnection(), packetPlayInEnchantItem);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a37(Object packetPlayInSetCreativeSlot) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSetCreativeSlot"))
                    .invoke(getPlayerConnection(), packetPlayInSetCreativeSlot);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a38(Object packetPlayInTransaction) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInTransaction"))
                    .invoke(getPlayerConnection(), packetPlayInTransaction);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a39(Object packetPlayInUpdateSign) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInUpdateSign"))
                    .invoke(getPlayerConnection(), packetPlayInUpdateSign);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a40(Object packetPlayInKeepAlive) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInKeepAlive"))
                    .invoke(getPlayerConnection(), packetPlayInKeepAlive);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a41(Object packetPlayInAbilities) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInAbilities"))
                    .invoke(getPlayerConnection(), packetPlayInAbilities);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a42(Object packetPlayInSettings) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInSettings"))
                    .invoke(getPlayerConnection(), packetPlayInSettings);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a43(Object packetPlayInCustomPayload) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInCustomPayload"))
                    .invoke(getPlayerConnection(), packetPlayInCustomPayload);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a44(Object packetPlayInDifficultyChange) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInDifficultyChange"))
                    .invoke(getPlayerConnection(), packetPlayInDifficultyChange);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void a45(Object packetPlayInDifficultyLock) {
        try {
            ReflectionUtil
                    .getNMSClass("PlayerConnection")
                    .getMethod("a", ReflectionUtil.getNMSClass("PacketPlayInDifficultyLock"))
                    .invoke(getPlayerConnection(), packetPlayInDifficultyLock);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isDisconnected() {
        return (boolean) invoke("isDisconnected");
    }

    // NMSAPI start
    public Object getPlayerConnection() {
        try {
            return player.getEntityPlayer().getClass().getField("playerConnection").get(player.getEntityPlayer());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("PlayerConnection"), getPlayerConnection(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("PlayerConnection")
                    .getMethod(method)
                    .invoke(getPlayerConnection());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("PlayerConnection")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getPlayerConnection(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
