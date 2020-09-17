package xyz.acrylicstyle.minecraft.v1_12_R1;

import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class NBTReadLimiter {
    public static final NBTReadLimiter a = new NBTReadLimiter(0L) {
        public void a(long b) {}
    };

    private Object o;

    public NBTReadLimiter(Object o) {
        if (o.getClass().isAssignableFrom(Long.class)) {
            try {
                this.o = ReflectionUtil.getNMSClass("NBTReadLimiter").getConstructor(Long.class).newInstance((long) o);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return;
        }
        this.o = o;
    }

    public Object getNMSNBTReadLimiter() {
        if (o.getClass().getCanonicalName().startsWith("net.minecraft.server") && o.getClass().getSimpleName().equals("NBTReadLimiter")) return o;
        return null;
    }

    public void a(long l) {
        try {
            ReflectionUtil.getNMSClass("NBTReadLimiter").getMethod("a", Long.class).invoke(getNMSNBTReadLimiter(), l);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
