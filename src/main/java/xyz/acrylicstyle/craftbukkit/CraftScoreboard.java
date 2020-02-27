package xyz.acrylicstyle.craftbukkit;

import org.bukkit.scoreboard.Scoreboard;

public abstract class CraftScoreboard implements Handler<xyz.acrylicstyle.minecraft.Scoreboard>, Scoreboard {
    private Scoreboard scoreboard;

    public CraftScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public xyz.acrylicstyle.minecraft.Scoreboard getHandle() {
        return new xyz.acrylicstyle.minecraft.Scoreboard(scoreboard);
    }
}
