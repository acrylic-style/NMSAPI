package xyz.acrylicstyle.nmsapi.shared;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.jetbrains.annotations.NotNull;
import util.CollectionList;
import util.reflect.Ref;
import util.reflect.RefClass;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class NMSAPI {
    @NotNull
    public static RefClass<?> getRefClass(@NotNull Type type, @NotNull String clazz) {
        if (type == Type.NMS) {
            return Ref.forName(ReflectionUtil.getNMSPackage() + "." + clazz);
        } else if (type == Type.BUKKIT) {
            return Ref.forName(ReflectionUtil.getCraftBukkitPackage() + "." + clazz);
        } else {
            return Ref.forName(clazz);
        }
    }

    @NotNull
    public static RefClass<?> nms(@NotNull String clazz) { return getRefClass(Type.NMS, clazz); }

    @NotNull
    public static RefClass<?> bukkit(@NotNull String clazz) { return getRefClass(Type.BUKKIT, clazz); }

    @NotNull
    public static RefClass<?> clazz(@NotNull String clazz) { return getRefClass(Type.OTHER, clazz); }

    public static <T, R> @NotNull CollectionList<R> map(@NotNull Iterable<T> iterable, @NotNull Function<T, R> mapFunction) {
        CollectionList<R> list = new CollectionList<>();
        iterable.forEach(t -> list.add(mapFunction.apply(t)));
        return list;
    }

    public static <T, U, R> @NotNull Multimap<T, R> map(@NotNull Multimap<T, U> multiMap, @NotNull Function<U, R> mapFunction) {
        Multimap<T, R> map = HashMultimap.create();
        multiMap.keySet().forEach(key -> {
            List<R> list = new ArrayList<>();
            multiMap.get(key).forEach(u -> list.add(mapFunction.apply(u)));
            map.putAll(key, list);
        });
        return map;
    }

    public enum Type {
        NMS,
        BUKKIT,
        OTHER,
    }
}
