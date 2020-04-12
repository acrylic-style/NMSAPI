package xyz.acrylicstyle.craftbukkit.v1_8_R3.scoreboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.util.Handler;
import xyz.acrylicstyle.shared.OBCAPI;

import java.util.Set;

public class CraftScoreboard extends OBCAPI implements Handler<xyz.acrylicstyle.minecraft.Scoreboard>, Scoreboard {
    public static final Class<?> CLASS = getClassWithoutException("CraftScoreboard");

    public CraftScoreboard(Scoreboard scoreboard) {
        super(scoreboard, "CraftScoreboard");
    }

    @Override
    public xyz.acrylicstyle.minecraft.Scoreboard getHandle() {
        return new xyz.acrylicstyle.minecraft.Scoreboard(o);
    }

    @Override
    @Deprecated
    public @NotNull Objective registerNewObjective(@NotNull String name, @NotNull String criteria) throws IllegalArgumentException {
        return ((Scoreboard) o).registerNewObjective(name, criteria);
    }

    @Override
    public @Nullable Objective getObjective(@NotNull String name) throws IllegalArgumentException {
        return ((Scoreboard) o).getObjective(name);
    }

    @Override
    public @NotNull Set<Objective> getObjectivesByCriteria(@NotNull String criteria) throws IllegalArgumentException {
        return ((Scoreboard) o).getObjectivesByCriteria(criteria);
    }

    @Override
    public @NotNull Set<Objective> getObjectives() {
        return ((Scoreboard) o).getObjectives();
    }

    @Override
    public @Nullable Objective getObjective(@NotNull DisplaySlot slot) throws IllegalArgumentException {
        return ((Scoreboard) o).getObjective(slot);
    }

    @Override
    @Deprecated
    public @NotNull Set<Score> getScores(@NotNull OfflinePlayer player) throws IllegalArgumentException {
        return ((Scoreboard) o).getScores(player);
    }

    @Override
    public @NotNull Set<Score> getScores(@NotNull String entry) throws IllegalArgumentException {
        return ((Scoreboard) o).getScores(entry);
    }

    @Override
    @Deprecated
    public void resetScores(@NotNull OfflinePlayer player) throws IllegalArgumentException {
        ((Scoreboard) o).resetScores(player);
    }

    @Override
    public void resetScores(@NotNull String entry) throws IllegalArgumentException {
        ((Scoreboard) o).resetScores(entry);
    }

    @Override
    @Deprecated
    public @Nullable Team getPlayerTeam(@NotNull OfflinePlayer player) throws IllegalArgumentException {
        return ((Scoreboard) o).getPlayerTeam(player);
    }

    @Override
    public @Nullable Team getEntryTeam(@NotNull String entry) throws IllegalArgumentException {
        return ((Scoreboard) o).getEntryTeam(entry);
    }

    @Override
    public @Nullable Team getTeam(@NotNull String teamName) throws IllegalArgumentException {
        return ((Scoreboard) o).getTeam(teamName);
    }

    @Override
    public @NotNull Set<Team> getTeams() {
        return ((Scoreboard) o).getTeams();
    }

    @Override
    public @NotNull Team registerNewTeam(@NotNull String name) throws IllegalArgumentException {
        return ((Scoreboard) o).registerNewTeam(name);
    }

    @Override
    @Deprecated
    public @NotNull Set<OfflinePlayer> getPlayers() {
        return ((Scoreboard) o).getPlayers();
    }

    @Override
    public @NotNull Set<String> getEntries() {
        return ((Scoreboard) o).getEntries();
    }

    @Override
    public void clearSlot(@NotNull DisplaySlot slot) throws IllegalArgumentException {
        ((Scoreboard) o).clearSlot(slot);
    }
}
