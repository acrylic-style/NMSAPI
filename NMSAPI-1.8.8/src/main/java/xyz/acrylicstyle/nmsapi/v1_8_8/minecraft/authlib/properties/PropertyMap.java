package xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties;

import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.CollectionList;
import util.MultiCollection;
import util.reflect.Ref;
import util.reflect.RefClass;
import xyz.acrylicstyle.mcutil.mojang.Property;
import xyz.acrylicstyle.nmsapi.shared.NMSAPI;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class PropertyMap implements Multimap<String, Property> {
    public static final RefClass<?> CLASS = NMSAPI.clazz("com.mojang.authlib.properties.PropertyMap");

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

    @Contract(pure = true)
    @NotNull
    public MultiCollection<String, Property> asMultiCollection() {
        MultiCollection<String, Property> multiCollection = new MultiCollection<>();
        delegate().keySet().forEach(key -> multiCollection.putAll(key, this.get(key)));
        return multiCollection;
    }

    @Contract(pure = true)
    @NotNull
    @SuppressWarnings("unchecked")
    public Multimap<String, Object> delegate() {
        return (Multimap<String, Object>) Ref.getClass(ForwardingMultimap.class).getDeclaredMethod("delegate").accessible(true).invoke((ForwardingMultimap<?, ?>) o);
    }

    @Override
    public int size() { return delegate().size(); }

    @Override
    public boolean isEmpty() { return delegate().isEmpty(); }

    @Override
    public boolean containsKey(@Nullable Object key) { return delegate().containsKey(key); }

    @Override
    public boolean containsValue(@Nullable Object value) {
        return delegate().containsValue(xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property.translateValue(value));
    }

    @Override
    public boolean containsEntry(@Nullable Object key, @Nullable Object value) {
        return delegate().containsEntry(key, xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property.translateValue(value));
    }

    @Override
    public boolean put(@Nullable String key, @Nullable Property value) {
        return delegate().put(key, xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property.translateValue(value));
    }

    @Override
    public boolean remove(@Nullable Object key, @Nullable Object value) {
        return delegate().remove(key, xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property.translateValue(value));
    }

    @Override
    public boolean putAll(@Nullable String key, @NotNull Iterable<? extends Property> values) {
        return delegate().putAll(key, NMSAPI.map(values, xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property::convertToNMS));
    }

    @Override
    public boolean putAll(@NotNull Multimap<? extends String, ? extends Property> multimap) {
        return delegate().putAll(NMSAPI.map(multimap, xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property::convertToNMS));
    }

    @SuppressWarnings("Convert2MethodRef")
    @Override
    public Collection<Property> replaceValues(@Nullable String key, @NotNull Iterable<? extends Property> values) {
        return new CollectionList<>((Collection<?>) delegate().replaceValues(key, NMSAPI.map(values, xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property::convertToNMS))).map(o -> new xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property(o));
    }

    @SuppressWarnings("Convert2MethodRef")
    @Override
    public Collection<Property> removeAll(@Nullable Object key) {
        return new CollectionList<>(delegate().removeAll(key)).map(o -> new xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property(o));
    }

    @Override
    public void clear() { delegate().clear(); }

    @Override
    public Collection<Property> get(@Nullable String key) {
        return new CollectionList<>(delegate().get(key)).map((@NotNull Function<Object, Property>) xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property::new);
    }

    @Override
    public Set<String> keySet() { return delegate().keySet(); }

    @Override
    public Multiset<String> keys() { return delegate().keys(); }

    @Override
    public Collection<Property> values() {
        return new CollectionList<>(delegate().values()).map((@NotNull Function<Object, Property>) xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property::new);
    }

    @Override
    public Collection<Map.Entry<String, Property>> entries() {
        return new CollectionList<>(delegate().entries()).map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property.translateToNMS(entry.getValue())));
    }

    @Override
    public Map<String, Collection<Property>> asMap() {
        return new util.Collection<>(delegate().asMap()).mapValues((s, c) -> NMSAPI.map(c, xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.Property::translateToNMS));
    }
}
