package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class PacketPlayOutNamedEntitySpawn implements Packet {
    private Object o;

    public PacketPlayOutNamedEntitySpawn(Object o) {
        if (o instanceof EntityPlayer) {
            try {
                this.o = ReflectionUtil.getNMSClass("PacketPlayOutNamedEntitySpawn")
                        .getConstructor(ReflectionUtil.getNMSClass("EntityHuman"))
                        .newInstance(((EntityPlayer) o).getEntityHuman());
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
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

    @Override
    public Object toNMSPacket() {
        return getPacketPlayOutNamedEntitySpawn();
    }

    // NMSAPI start
    public Object getPacketPlayOutNamedEntitySpawn() {
        try {
            if (o.getClass().getCanonicalName().equals(ReflectionUtil.getNMSClass("PacketPlayOutNamedEntitySpawn").getCanonicalName())) return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("PacketPlayOutNamedEntitySpawn"), getPacketPlayOutNamedEntitySpawn(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("PacketPlayOutNamedEntitySpawn")
                    .getMethod(method)
                    .invoke(getPacketPlayOutNamedEntitySpawn());
        } catch (NoSuchMethodException e) {
            try {
                return ReflectionUtil.getNMSClass("PacketPlayOutNamedEntitySpawn")
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
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("PacketPlayOutNamedEntitySpawn")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getPacketPlayOutNamedEntitySpawn(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
