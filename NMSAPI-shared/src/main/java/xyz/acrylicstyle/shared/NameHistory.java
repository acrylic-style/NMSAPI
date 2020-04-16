package xyz.acrylicstyle.shared;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NameHistory {
    @NotNull
    private final String name;
    @Nullable
    private final Long changedToAt;

    NameHistory(@NotNull String name, @Nullable Long changedToAt) {
        this.name = name;
        this.changedToAt = changedToAt;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @Nullable
    public Long getChangedToAt() {
        return changedToAt;
    }
}
