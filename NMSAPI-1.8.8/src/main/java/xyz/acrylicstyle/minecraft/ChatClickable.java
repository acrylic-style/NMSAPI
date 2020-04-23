package xyz.acrylicstyle.minecraft;

import util.ReflectionHelper;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class ChatClickable extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("ChatClickable");

    public ChatClickable(Object o) {
        super(o, "ChatClickable");
    }

    public ChatClickable(EnumClickAction paramEnumClickAction, String paramString) {
        super("ChatClickable", paramEnumClickAction.getHandle(), paramString);
    }

    public static ChatClickable getInstance(Object o) {
        if (o == null) return null;
        return new ChatClickable(o);
    }

    public EnumClickAction a() {
        return EnumClickAction.valueOf(invoke("a"));
    }

    public String b() {
        return (String) invoke("b");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatClickable chatClickable = (ChatClickable) o;
        if (this.a() != chatClickable.a()) return false;
        return (this.b() != null) ? this.b().equals(chatClickable.b()) : (chatClickable.b() == null);
    }

    @Override
    public String toString() {
        return (String) invoke("toString");
    }

    @Override
    public int hashCode() {
        return (int) invoke("hashCode");
    }

    public enum EnumClickAction {
        OPEN_URL,
        OPEN_FILE,
        RUN_COMMAND,
        TWITCH_USER_INFO,
        SUGGEST_COMMAND,
        CHANGE_PAGE;

        public static final Class<?> CLASS = NMSAPI.getClassWithoutException("ChatClickable$EnumClickAction");

        public boolean a() {
            return (boolean) invoke("a");
        }

        public String b() {
            return (String) invoke("b");
        }

        public static EnumClickAction a(String s) {
            return EnumClickAction.valueOf(ReflectionHelper.invokeMethodWithoutException(CLASS, null, "a", s));
        }

        public static EnumClickAction valueOf(Object o) {
            return valueOf(((Enum<?>) o).name());
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        public Enum getHandle() {
            try {
                return Enum.valueOf((Class<Enum>) ReflectionUtil.getNMSClass("EnumChatFormat"), this.name());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        public Object invoke(String method) {
            try {
                return ReflectionUtil.getNMSClass("EnumChatFormat")
                        .getMethod(method)
                        .invoke(getHandle());
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
