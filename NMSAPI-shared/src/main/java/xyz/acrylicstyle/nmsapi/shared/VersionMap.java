package xyz.acrylicstyle.nmsapi.shared;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.ActionableResult;
import util.Validate;
import util.reflect.RefClass;
import xyz.acrylicstyle.mcutil.lang.MCVersion;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;

public class VersionMap<T> {
    private static final Map<Class<?>, VersionMap<?>> map = new ConcurrentHashMap<>();
    private final Map<MCVersion, Class<? extends T>> classMap = new ConcurrentHashMap<>();
    private Class<? extends T> defaultValue;

    private VersionMap() {}

    public VersionMap<T> defaultsTo(@Nullable Class<? extends T> defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public Class<? extends T> getDefaultValue() {
        return defaultValue;
    }

    public VersionMap<T> register(@NotNull MCVersion version, @NotNull Class<? extends T> clazz) {
        Validate.notNull(version, "version cannot be null");
        Validate.notNull(clazz, "clazz cannot be null");
        classMap.put(version, clazz);
        return this;
    }

    @SuppressWarnings("unchecked")
    public T getInstance(@NotNull MCVersion version, Object o) {
        return ActionableResult
                .ofNullable(get(version))
                .map(c -> c != null ? c : getDefaultValue())
                .map(RefClass::new)
                .map(rc -> Arrays.stream(rc.getDeclaredMethods()).filter(rm -> rm.getName().equals("getInstance")).findFirst().orElse(null))
                .map(rm -> (T) invoke(rm, rm1 -> rm1.invoke(null, o), null))
                .get();
    }

    public Class<? extends T> get(@NotNull MCVersion version) {
        return get(version, getDefaultValue());
    }

    @Contract("_, !null -> param2")
    public Class<? extends T> get(@NotNull MCVersion version, @Nullable Class<? extends T> def) {
        Validate.notNull(version, "version cannot be null");
        return classMap.getOrDefault(version, def);
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public static <T> VersionMap<T> getInstance(@NotNull Class<T> clazz) {
        Validate.notNull(clazz, "class cannot be null");
        return (VersionMap<T>) getOrDefault(map.get(clazz), () -> {
            VersionMap<T> vMap = new VersionMap<>();
            map.put(clazz, vMap);
            return vMap;
        });
    }

    @Contract("!null, _ -> param1")
    private static <T> T getOrDefault(@Nullable T value, @NotNull Supplier<? extends T> supplier) {
        return value != null ? value : supplier.get();
    }

    private static <T, R> R invoke(@Nullable T value, @NotNull Function<T, R> function, R defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return function.apply(value);
    }
}
