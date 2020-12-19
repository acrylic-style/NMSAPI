package xyz.acrylicstyle.nmsapi.shared.authlib.properties;

import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.Multimap;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.MultiCollection;
import util.reflect.Ref;
import util.reflect.RefClass;
import xyz.acrylicstyle.mcutil.mojang.Property;
import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;

public class PropertyMap extends AbstractPropertyMap implements Multimap<String, Property> {
    public static final RefClass<?> CLASS = AbstractNMSAPI.clazz("com.mojang.authlib.properties.PropertyMap");

    public Object o;

    public PropertyMap() {
        try {
            this.o = CLASS.getClazz().newInstance();
        } catch (ReflectiveOperationException e) { throw new RuntimeException(e); }
    }

    public PropertyMap(@NotNull Object o) { this.o = o; }

    @NotNull
    public static PropertyMap arrayToMap(Property[] properties) {
        PropertyMap map = new PropertyMap();
        for (Property property : properties) {
            map.put(property.name, property);
        }
        return map;
    }

    @NotNull
    public PropertyMap setMultiCollection(@NotNull MultiCollection<String, Property> multiCollection) {
        return (PropertyMap) super.setMultiCollection(multiCollection);
    }

    @Contract(pure = true)
    @NotNull
    @SuppressWarnings("unchecked")
    public Multimap<String, Object> delegate() {
        return (Multimap<String, Object>) Ref.getClass(ForwardingMultimap.class).getDeclaredMethod("delegate").accessible(true).invoke((ForwardingMultimap<?, ?>) o);
    }

    @Override
    public Object translateValue(@Nullable Object value) {
        return xyz.acrylicstyle.nmsapi.shared.authlib.properties.Property.translateValue(value);
    }

    @Override
    public Object convertToNMS(@NotNull Property property) {
        return xyz.acrylicstyle.nmsapi.shared.authlib.properties.Property.convertToNMS(property);
    }

    @Override
    public Property translateToNMS(@NotNull Object value) {
        return xyz.acrylicstyle.nmsapi.shared.authlib.properties.Property.translateToNMS(value);
    }

    @Override
    public Property convertToNMSAPI(@NotNull Object o) {
        return new xyz.acrylicstyle.nmsapi.shared.authlib.properties.Property(o);
    }
}
