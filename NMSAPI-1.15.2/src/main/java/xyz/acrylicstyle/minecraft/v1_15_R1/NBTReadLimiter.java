package xyz.acrylicstyle.minecraft.v1_15_R1;

import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class NBTReadLimiter extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("NBTReadLimiter");

    public static final NBTReadLimiter a = new NBTReadLimiter(0L) {
        public void a(long b) {}
    };

    public NBTReadLimiter(Object o) {
        super(o, "NBTReadLimiter");
    }

    public NBTReadLimiter(long l) {
        super("NBTReadLimiter", l);
    }

    public void a(long l) {
        try {
            ReflectionUtil.getNMSClass("NBTReadLimiter").getMethod("a", Long.class).invoke(getHandle(), l);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
