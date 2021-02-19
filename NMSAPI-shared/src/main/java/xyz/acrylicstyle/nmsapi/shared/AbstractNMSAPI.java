package xyz.acrylicstyle.nmsapi.shared;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.CollectionList;
import util.reflect.Ref;
import util.reflect.RefClass;
import xyz.acrylicstyle.mcutil.lang.MCVersion;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AbstractNMSAPI {
    public static final MCVersion VERSION = toMCVersion(ReflectionUtil.getServerVersion());

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

    @SuppressWarnings("unchecked")
    @NotNull
    public static <T> Class<T> nmsapi(@NotNull String version, @NotNull String clazz) {
        return (Class<T>) getRefClass(Type.OTHER, "xyz.acrylicstyle.nmsapi." + version + "." + clazz).getClazz();
    }

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

    @Contract(pure = true)
    @NotNull
    public static MCVersion toMCVersion(@NotNull String packageName) {
        if (packageName.equals("v1_8_R1")) return MCVersion.v1_8;
        if (packageName.equals("v1_8_R2")) return MCVersion.v1_8_3;
        if (packageName.equals("v1_8_R3")) return MCVersion.v1_8_8;
        if (packageName.equals("v1_9_R1")) return MCVersion.v1_9; // 1.9.2
        if (packageName.equals("v1_9_R2")) return MCVersion.v1_9_4;
        if (packageName.equals("v1_10_R1")) return MCVersion.v1_10; // 1.10.x
        if (packageName.equals("v1_11_R1")) return MCVersion.v1_11; // 1.11.x
        if (packageName.equals("v1_12_R1")) return MCVersion.v1_12; // 1.12.x
        if (packageName.equals("v1_13_R1")) return MCVersion.v1_13;
        if (packageName.equals("v1_13_R2")) return MCVersion.v1_13_1; // 1.13.2
        if (packageName.equals("v1_14_R1")) return MCVersion.v1_14; // 1.14.x
        if (packageName.equals("v1_15_R1")) return MCVersion.v1_15; // 1.15.x
        if (packageName.equals("v1_16_R1")) return MCVersion.v1_16; // 1.16.1
        if (packageName.equals("v1_16_R2")) return MCVersion.v1_16_2; // 1.16.3
        if (packageName.equals("v1_16_R3")) return MCVersion.v1_16_4; // 1.16.5
        if (packageName.equals("v1_17_R1")) return MCVersion.v1_17;
        return MCVersion.UNKNOWN;
    }

    public enum Type {
        NMS,
        BUKKIT,
        OTHER,
    }
}
