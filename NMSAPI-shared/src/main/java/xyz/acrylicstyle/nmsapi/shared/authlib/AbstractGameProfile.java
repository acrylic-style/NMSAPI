package xyz.acrylicstyle.nmsapi.shared.authlib;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.mcutil.mojang.Property;
import xyz.acrylicstyle.mcutil.mojang.SimpleGameProfile;

import java.util.UUID;

/**
 * A base GameProfile class. All GameProfile classes on NMSAPI must extend this class.
 */
public abstract class AbstractGameProfile extends SimpleGameProfile {
    public AbstractGameProfile(@NotNull UUID id, @NotNull String name, @NotNull Property[] properties) {
        super(id, name, properties);
    }

    @Contract(pure = true)
    @NotNull
    public abstract Object toNMS();
}
