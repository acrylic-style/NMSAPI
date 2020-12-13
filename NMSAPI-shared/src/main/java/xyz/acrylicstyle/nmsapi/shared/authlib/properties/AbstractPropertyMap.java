package xyz.acrylicstyle.nmsapi.shared.authlib.properties;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.CollectionList;
import util.MultiCollection;
import xyz.acrylicstyle.mcutil.mojang.Property;
import xyz.acrylicstyle.nmsapi.shared.NMSAPI;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class AbstractPropertyMap implements Multimap<String, Property> {
    @NotNull
    public abstract Multimap<String, Object> delegate();
    public abstract Object translateValue(@Nullable Object value);
    public abstract Object convertToNMS(@NotNull Property property);
    public abstract Property translateToNMS(@NotNull Object value);
    public abstract Property convertToNMSAPI(@NotNull Object o);

    @NotNull
    public AbstractPropertyMap setMultiCollection(@NotNull MultiCollection<String, Property> multiCollection) {
        this.clear();
        multiCollection.forEach(this::putAll);
        return this;
    }

    @Override
    public int size() { return delegate().size(); }

    @Override
    public boolean isEmpty() { return delegate().isEmpty(); }

    @Override
    public boolean containsKey(@Nullable Object key) { return delegate().containsKey(key); }

    @Override
    public boolean containsValue(@Nullable Object value) {
        return delegate().containsValue(this.translateValue(value));
    }

    @Override
    public boolean containsEntry(@Nullable Object key, @Nullable Object value) {
        return delegate().containsEntry(key, this.translateValue(value));
    }

    @Override
    public boolean put(@Nullable String key, @Nullable Property value) {
        return delegate().put(key, this.translateValue(value));
    }

    @Override
    public boolean remove(@Nullable Object key, @Nullable Object value) {
        return delegate().remove(key, this.translateValue(value));
    }

    @Override
    public boolean putAll(@Nullable String key, @NotNull Iterable<? extends Property> values) {
        return delegate().putAll(key, NMSAPI.map(values, this::convertToNMS));
    }

    @Override
    public boolean putAll(@NotNull Multimap<? extends String, ? extends Property> multimap) {
        return delegate().putAll(NMSAPI.map(multimap, this::convertToNMS));
    }

    @SuppressWarnings("Convert2MethodRef")
    @Override
    public Collection<Property> replaceValues(@Nullable String key, @NotNull Iterable<? extends Property> values) {
        return new CollectionList<>((Collection<?>) delegate().replaceValues(key, NMSAPI.map(values, this::convertToNMS))).map(o -> convertToNMSAPI(o));
    }

    @SuppressWarnings("Convert2MethodRef")
    @Override
    public Collection<Property> removeAll(@Nullable Object key) {
        return new CollectionList<>(delegate().removeAll(key)).map(o -> convertToNMSAPI(o));
    }

    @Override
    public void clear() { delegate().clear(); }

    @Override
    public Collection<Property> get(@Nullable String key) {
        return new CollectionList<>(delegate().get(key)).map(this::convertToNMSAPI);
    }

    @Override
    public Set<String> keySet() { return delegate().keySet(); }

    @Override
    public Multiset<String> keys() { return delegate().keys(); }

    @Override
    public Collection<Property> values() {
        return new CollectionList<>(delegate().values()).map(this::convertToNMSAPI);
    }

    @Override
    public Collection<Map.Entry<String, Property>> entries() {
        return new CollectionList<>(delegate().entries()).map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), this.translateToNMS(entry.getValue())));
    }

    @Override
    public Map<String, Collection<Property>> asMap() {
        return new util.Collection<>(delegate().asMap()).mapValues((s, c) -> NMSAPI.map(c, this::translateToNMS));
    }
}
