package xyz.acrylicstyle.minecraft.v1_8_R1;

import util.ReflectionHelper;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class ChatHoverable extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("ChatHoverable");

    public ChatHoverable(Object o) {
        super(o, "ChatHoverable");
    }

    public ChatHoverable(EnumHoverAction paramEnumHoverAction, IChatBaseComponent paramIChatBaseComponent) {
        super("ChatHoverable", paramEnumHoverAction.getHandle(), paramIChatBaseComponent.getHandle());
    }

    public static ChatHoverable getInstance(Object o) {
        if (o == null) return null;
        return new ChatHoverable(o);
    }

    public EnumHoverAction a() {
        return EnumHoverAction.valueOf(invoke("a"));
    }

    public IChatBaseComponent b() {
        return IChatBaseComponent.getInstance(invoke("b"));
    }

    @Override
    public boolean equals(Object paramObject) {
        if (this == paramObject) return true;
        if (paramObject == null || getClass() != paramObject.getClass()) return false;
        ChatHoverable chatHoverable = (ChatHoverable) paramObject;
        if (this.a() != chatHoverable.a()) return false;
        return (this.b() != null) ? this.b().equals(chatHoverable.b()) : (chatHoverable.b() == null);
    }

    @Override
    public String toString() {
        return (String) invoke("toString");
    }

    @Override
    public int hashCode() {
        return (int) invoke("hashCode");
    }

    public enum EnumHoverAction {
        SHOW_TEXT,
        SHOW_ACHIEVEMENT,
        SHOW_ITEM,
        SHOW_ENTITY;

        public static final Class<?> CLASS = NMSAPI.getClassWithoutException("ChatHoverable$EnumHoverAction");

        public boolean a() {
            return (boolean) invoke("a");
        }

        public String b() {
            return (String) invoke("b");
        }

        public static EnumHoverAction a(String s) {
            return EnumHoverAction.valueOf(ReflectionHelper.invokeMethodWithoutException(CLASS, null, "a", s));
        }

        public static EnumHoverAction valueOf(Object o) {
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
