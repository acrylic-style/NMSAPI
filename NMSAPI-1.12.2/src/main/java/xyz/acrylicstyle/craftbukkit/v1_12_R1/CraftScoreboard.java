package xyz.acrylicstyle.craftbukkit.v1_12_R1;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class CraftScoreboard implements Handler<xyz.acrylicstyle.minecraft.v1_12_R1.Scoreboard>, Scoreboard {
    private Scoreboard scoreboard;

    public CraftScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public xyz.acrylicstyle.minecraft.v1_12_R1.Scoreboard getHandle() {
        return new xyz.acrylicstyle.minecraft.v1_12_R1.Scoreboard(scoreboard);
    }

    @Override
    @Deprecated
    public @NotNull Objective registerNewObjective(@NotNull String name, @NotNull String criteria) throws IllegalArgumentException {
        return scoreboard.registerNewObjective(name, criteria);
    }

    @Override
    public @Nullable Objective getObjective(@NotNull String name) throws IllegalArgumentException {
        return scoreboard.getObjective(name);
    }

    @Override
    public @NotNull Set<Objective> getObjectivesByCriteria(@NotNull String criteria) throws IllegalArgumentException {
        return scoreboard.getObjectivesByCriteria(criteria);
    }

    @Override
    public @NotNull Set<Objective> getObjectives() {
        return scoreboard.getObjectives();
    }

    @Override
    public @Nullable Objective getObjective(@NotNull DisplaySlot slot) throws IllegalArgumentException {
        return scoreboard.getObjective(slot);
    }

    @Override
    @Deprecated
    public @NotNull Set<Score> getScores(@NotNull OfflinePlayer player) throws IllegalArgumentException {
        return scoreboard.getScores(player);
    }

    @Override
    public @NotNull Set<Score> getScores(@NotNull String entry) throws IllegalArgumentException {
        return scoreboard.getScores(entry);
    }

    @Override
    @Deprecated
    public void resetScores(@NotNull OfflinePlayer player) throws IllegalArgumentException {
        scoreboard.resetScores(player);
    }

    @Override
    public void resetScores(@NotNull String entry) throws IllegalArgumentException {
        scoreboard.resetScores(entry);
    }

    @Override
    @Deprecated
    public @Nullable Team getPlayerTeam(@NotNull OfflinePlayer player) throws IllegalArgumentException {
        return scoreboard.getPlayerTeam(player);
    }

    @Override
    public @Nullable Team getEntryTeam(@NotNull String entry) throws IllegalArgumentException {
        return scoreboard.getEntryTeam(entry);
    }

    @Override
    public @Nullable Team getTeam(@NotNull String teamName) throws IllegalArgumentException {
        return scoreboard.getTeam(teamName);
    }

    @Override
    public @NotNull Set<Team> getTeams() {
        return scoreboard.getTeams();
    }

    @Override
    public @NotNull Team registerNewTeam(@NotNull String name) throws IllegalArgumentException {
        return scoreboard.registerNewTeam(name);
    }

    @Override
    @Deprecated
    public @NotNull Set<OfflinePlayer> getPlayers() {
        return scoreboard.getPlayers();
    }

    @Override
    public @NotNull Set<String> getEntries() {
        return scoreboard.getEntries();
    }

    @Override
    public void clearSlot(@NotNull DisplaySlot slot) throws IllegalArgumentException {
        scoreboard.clearSlot(slot);
    }
}
