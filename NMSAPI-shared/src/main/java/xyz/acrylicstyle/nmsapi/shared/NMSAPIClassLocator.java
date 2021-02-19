package xyz.acrylicstyle.nmsapi.shared;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.Validate;

public class NMSAPIClassLocator<T> {
    private final String clazz;

    public NMSAPIClassLocator(@NotNull String clazz) {
        Validate.notNull(clazz, "clazz cannot be null");
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    public Class<? extends T> get(@Nullable String version) { // accepts (example) - v1_8_8, v1.8.8
        if (version != null) version = version.replace(".", "_") + ".";
        try {
            return (Class<? extends T>) Class.forName("xyz.acrylicstyle.nmsapi." + version + this.clazz);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
