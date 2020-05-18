package xyz.acrylicstyle.craftbukkit.v1_15_R1.scoreboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.Serializer;
import xyz.acrylicstyle.shared.NMSAPI;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

public class CraftScoreboard extends NMSAPI implements Scoreboard, Serializable {
    public static final Class<?> CLASS = getClassWithoutException("scoreboard.CraftScoreboard");

    private final Scoreboard scoreboard;

    public CraftScoreboard(Scoreboard scoreboard) {
        super(scoreboard, "CraftScoreboard");
        this.scoreboard = scoreboard;
    }

    @Override
    public xyz.acrylicstyle.minecraft.Scoreboard getHandle() {
        return new xyz.acrylicstyle.minecraft.Scoreboard(super.getNMSClass());
    }

    @Override
    @Deprecated
    public @NotNull Objective registerNewObjective(@NotNull String name, @NotNull String criteria) throws IllegalArgumentException {
        return scoreboard.registerNewObjective(name, criteria);
    }

    @Override
    public @NotNull Objective registerNewObjective(@NotNull String s, @NotNull String s1, @NotNull String s2) throws IllegalArgumentException {
        return scoreboard.registerNewObjective(s, s1, s2);
    }

    @Override
    public @NotNull Objective registerNewObjective(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull RenderType renderType) throws IllegalArgumentException {
        return scoreboard.registerNewObjective(s, s1, s2, renderType);
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

    public CraftScoreboard cloneScoreboard() {
        try {
            String s = new Serializer(this).asString();
            return (CraftScoreboard) Serializer.fromString(s).getObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
