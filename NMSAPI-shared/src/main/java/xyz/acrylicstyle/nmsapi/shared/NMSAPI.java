package xyz.acrylicstyle.nmsapi.shared;

import org.jetbrains.annotations.NotNull;
import util.reflect.Ref;
import util.reflect.RefClass;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

public class NMSAPI {
    @NotNull
    public static RefClass<?> getRefClass(@NotNull Type type, @NotNull String clazz) {
        if (type == Type.NMS) {
            return Ref.forName(ReflectionUtil.getNMSPackage() + "." + clazz);
        } else {
            return Ref.forName(ReflectionUtil.getCraftBukkitPackage() + "." + clazz);
        }
    }

    public enum Type {
        NMS,
        BUKKIT,
    }
}
