package xyz.acrylicstyle.nmsapi.shared.authlib;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.reflect.RefClass;
import util.reflector.CastTo;
import util.reflector.FieldGetter;
import util.reflector.FieldSetter;
import util.reflector.Reflector;
import util.reflector.ReflectorHandler;
import xyz.acrylicstyle.mcutil.mojang.Property;
import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;
import xyz.acrylicstyle.nmsapi.shared.authlib.properties.PropertyMap;

import java.util.UUID;

public class ComplexGameProfile extends AbstractGameProfile {
    public static final RefClass<?> CLASS = AbstractNMSAPI.clazz("com.mojang.authlib.GameProfile");

    @SuppressWarnings("deprecation")
    public ComplexGameProfile(@NotNull Object o) {
        super((UUID) CLASS.getMethod("getId").invokeObj(o), (String) CLASS.getMethod("getName").invokeObj(o), new PropertyMap(CLASS.getMethod("getProperties").invokeObj(o)).values().toArray(new Property[0]));
    }

    public ComplexGameProfile(@NotNull UUID id, @NotNull String name, @NotNull Property[] properties) {
        super(id, name, properties);
    }

    @Contract(pure = true)
    @NotNull
    @Override
    public Object toNMS() {
        Object nms = CLASS.getDeclaredConstructor(UUID.class, String.class).accessible(true).newInstance(id, name);
        CLASS.getDeclaredField("properties").accessible(true).removeFinal().setObj(nms, PropertyMap.arrayToMap(properties).o);
        return nms;
    }

    /**
     * Returns GameProfile as Reflector.
     */
    @Contract(pure = true)
    @NotNull
    public Refl reflector() {
        return Reflector.newReflector(null, Refl.class, new ReflectorHandler(CLASS.getClazz(), toNMS()));
    }

    public interface Refl extends xyz.acrylicstyle.mcutil.mojang.GameProfile {
        @FieldGetter("id")
        @NotNull
        @Override
        UUID getUniqueId();

        @FieldGetter("name")
        @NotNull
        @Override
        String getName();

        @FieldGetter("properties")
        @CastTo(value = PropertyMap.class, createInstance = true)
        @NotNull
        PropertyMap getProperties();

        @FieldSetter("id")
        void setUniqueId(@NotNull UUID uuid);

        @FieldSetter("name")
        void setName(@NotNull String name);

        void setProperties(@NotNull @FieldGetter("o") PropertyMap properties);
    }
}
