package xyz.acrylicstyle.shared;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class PlayerProfile {
    @NotNull
    private final String name;
    @NotNull
    private final UUID uuid;

    PlayerProfile(@NotNull String name, @NotNull String uuid) {
        this.name = name;
        this.uuid = UUID.fromString(uuid.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5"));
    }

    PlayerProfile(@NotNull String name, @NotNull UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public UUID getUniqueId() {
        return uuid;
    }
}
