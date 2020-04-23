package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.authlib.GameProfile;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.lang.reflect.Array;

@SuppressWarnings("unused")
public class PacketPlayOutPlayerInfo extends NMSAPI implements Packet<PacketListenerPlayOut> {
    public static final Class<?> CLASS = NMSAPI.getClassWithoutException("PacketPlayOutPlayerInfo");

    public EnumPlayerInfoAction a;

    public PacketPlayOutPlayerInfo(Object o) {
        super(o, "PacketPlayOutPlayerInfo");
    }

    public PacketPlayOutPlayerInfo(EnumPlayerInfoAction paramEnumPlayerInfoAction, EntityPlayer... paramVarArgs) {
        super(callCtor(paramEnumPlayerInfoAction, paramVarArgs), "PacketPlayOutPlayerInfo");
        this.a = paramEnumPlayerInfoAction;
    }

    private static Object callCtor(EnumPlayerInfoAction paramEnumPlayerInfoAction, EntityPlayer[] players) {
        try {
            Object osu = Array.newInstance(ReflectionUtil.getNMSClass("EntityPlayer"), players.length);
            for (int i = 0; i < players.length; i++) Array.set(osu, i, players[i].getHandle());
            return ReflectionUtil.getNMSClass("PacketPlayOutPlayerInfo")
                    .getConstructor(EnumPlayerInfoAction.CLASS, Array.newInstance(ReflectionUtil.getNMSClass("EntityPlayer"), players.length).getClass())
                    .newInstance(paramEnumPlayerInfoAction.getHandle(), osu);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void a(PacketDataSerializer packetDataSerializer) {
        invoke("a", packetDataSerializer.getHandle());
    }

    @Override
    public void b(PacketDataSerializer packetDataSerializer) {
        invoke("b", packetDataSerializer.getHandle());
    }

    @Override
    public void a(PacketListenerPlayOut packetListenerPlayOut) {
        packetListenerPlayOut.a(this);
    }

    @Override
    public Object toNMSPacket() {
        return super.getHandle();
    }

    public enum EnumPlayerInfoAction {
        ADD_PLAYER,
        UPDATE_GAME_MODE,
        UPDATE_LATENCY,
        UPDATE_DISPLAY_NAME,
        REMOVE_PLAYER;

        public static final Class<?> CLASS = getClassWithoutException("PacketPlayOutPlayerInfo$EnumPlayerInfoAction");

        @SuppressWarnings({"unchecked", "rawtypes"})
        public Enum<?> getHandle() {
            try {
                return Enum.valueOf((Class<Enum>) ReflectionUtil.getNMSClass("PacketPlayOutPlayerInfo$EnumPlayerInfoAction"), this.name());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public String toString() {
        return (String) invoke("toString");
    }

    public PacketPlayOutPlayerInfo() { super("PacketPlayOutPlayerInfo"); }

    public static class PlayerInfoData extends NMSAPI {
        private final int b = field("b");
        private final EnumGamemode c = EnumGamemode.valueOf(((Enum<?>) getField("c")).name());
        private final GameProfile d = new GameProfile(getField("d"));
        private final IChatBaseComponent e = new ChatComponentText(getField("e"));

        public PlayerInfoData(PacketPlayOutPlayerInfo this$0, GameProfile gameProfile, int paramInt, EnumGamemode paramEnumGameMode, IChatBaseComponent paramIChatBaseComponent) {
            super("PlayerInfoData", this$0.getHandle(), gameProfile.getHandle(), paramInt, paramEnumGameMode.getHandle(), paramIChatBaseComponent.getHandle());
        }

        public GameProfile a() { return this.d; }

        public GameProfile getProfile() { return d; } // NMSAPI - OBFHelper

        public GameProfile getGameProfile() { return d; } // NMSAPI - OBFHelper

        public int b() { return b; }

        public EnumGamemode c() { return c; }

        public EnumGamemode getGameMode() { return c; } // NMSAPI - OBFHelper

        public IChatBaseComponent d() { return e; }

        public IChatBaseComponent getIChatBaseComponent() { return e; }

        public String toString() {
            return (String) invoke("toString");
        }
    }
}
