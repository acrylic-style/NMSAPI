package xyz.acrylicstyle.minecraft.v1_15_R1;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public enum EnumChatFormat {
    BLACK,
    DARK_BLUE,
    DARK_GREEN,
    DARK_AQUA,
    DARK_RED,
    DARK_PURPLE,
    GOLD,
    GRAY,
    DARK_GRAY,
    BLUE,
    GREEN,
    AQUA,
    RED,
    LIGHT_PURPLE,
    YELLOW,
    WHITE,
    OBFUSCATED,
    BOLD,
    STRIKETHROUGH,
    UNDERLINE,
    ITALIC,
    RESET;

    public static final Class<?> CLASS = getClassWithoutException("EnumChatFormat");

    public static String d(String s) {
        return s.toLowerCase(Locale.ROOT).replaceAll("[^a-z]", "");
    }

    // NMSAPI start

    public static EnumChatFormat valueOf(Object o) {
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

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("EnumChatFormat"), getHandle(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
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
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("EnumChatFormat")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getHandle(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // NMSAPI end
}
