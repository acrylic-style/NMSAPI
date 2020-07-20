package xyz.acrylicstyle.minecraft.v1_12_R1;

import util.CollectionList;
import util.ICollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class PacketPlayOutEntityDestroy implements Packet {
    private Object o;

    public PacketPlayOutEntityDestroy(int... paramVarArgs) {
        try {
            this.o = ReflectionUtil.getNMSClass("PacketPlayOutEntityDestroy")
                    .getConstructor(int[].class)
                    .newInstance((Object) paramVarArgs);
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public PacketPlayOutEntityDestroy(Object o) {
        this.o = o;
    }

    public void a(PacketDataSerializer packetDataSerializer) {
        invoke("a", packetDataSerializer.getPacketDataSerializer());
    }

    public void b(PacketDataSerializer packetDataSerializer) {
        invoke("b", packetDataSerializer.getPacketDataSerializer());
    }

    @Override
    public void a(PacketListener packetListener) {
        invoke("a", packetListener.getNMSPacketListener());
    }

    // NMSAPI start
    @Override
    public Object toNMSPacket() {
        return getPacketPlayOutNamedEntitySpawn();
    }

    public Object getPacketPlayOutNamedEntitySpawn() {
        try {
            if (o.getClass().getCanonicalName().equals(ReflectionUtil.getNMSClass("PacketPlayOutEntityDestroy").getCanonicalName())) return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("PacketPlayOutEntityDestroy"), getPacketPlayOutNamedEntitySpawn(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("PacketPlayOutEntityDestroy")
                    .getMethod(method)
                    .invoke(getPacketPlayOutNamedEntitySpawn());
        } catch (NoSuchMethodException e) {
            try {
                return ReflectionUtil.getNMSClass("PacketPlayOutEntityDestroy")
                        .getSuperclass()
                        .getMethod(method)
                        .invoke(getPacketPlayOutNamedEntitySpawn());
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = ICollectionList.asList(o).map(Object::getClass);
            return ReflectionUtil.getNMSClass("PacketPlayOutEntityDestroy")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getPacketPlayOutNamedEntitySpawn(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setField(String field, Object value) {
        try {
            Field f = ReflectionUtil.getNMSClass("PacketPlayOutEntityDestroy").getDeclaredField(field);
            f.setAccessible(true);
            f.set(getPacketPlayOutNamedEntitySpawn(), value);
        } catch (NoSuchFieldException e) {
            try {
                Field f = ReflectionUtil.getNMSClass("PacketPlayOutEntityDestroy").getSuperclass().getDeclaredField(field);
                f.setAccessible(true);
                f.set(getPacketPlayOutNamedEntitySpawn(), value);
            } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    // NMSAPI end
}
