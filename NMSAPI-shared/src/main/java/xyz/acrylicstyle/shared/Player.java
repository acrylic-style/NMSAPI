package xyz.acrylicstyle.shared;

import java.util.UUID;

class Player {
    private final Object player;

    Player(Object o) {
        this.player = o;
    }

    UUID getUniqueId() {
        try {
            return (UUID) player.getClass().getMethod("getUniqueId").invoke(player);
        } catch (ReflectiveOperationException e) { throw new RuntimeException(e); }
    }

    String getName() {
        try {
            return (String) player.getClass().getMethod("getName").invoke(player);
        } catch (ReflectiveOperationException e) { throw new RuntimeException(e); }
    }
}
