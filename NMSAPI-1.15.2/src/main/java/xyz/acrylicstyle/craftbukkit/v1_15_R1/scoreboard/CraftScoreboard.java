package xyz.acrylicstyle.craftbukkit.v1_15_R1.scoreboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.Serializer;
import xyz.acrylicstyle.shared.TypedOBCAPI;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

public class CraftScoreboard extends TypedOBCAPI<Scoreboard> implements Scoreboard, Serializable {
    public static final Class<?> CLASS = getClassWithoutException("scoreboard.CraftScoreboard");

    public CraftScoreboard(Scoreboard scoreboard) {
        super(scoreboard, "CraftScoreboard");
        this.t = scoreboard;
    }

    @Override
    public xyz.acrylicstyle.minecraft.v1_15_R1.Scoreboard getHandle() {
        return new xyz.acrylicstyle.minecraft.v1_15_R1.Scoreboard(invoke("getHandle"));
    }

    @Override
    @Deprecated
    public @NotNull Objective registerNewObjective(@NotNull String name, @NotNull String criteria) throws IllegalArgumentException {
        return t.registerNewObjective(name, criteria);
    }

    @Override
    public @NotNull Objective registerNewObjective(@NotNull String s, @NotNull String s1, @NotNull String s2) throws IllegalArgumentException {
        return t.registerNewObjective(s, s1, s2);
    }

    @Override
    public @NotNull Objective registerNewObjective(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull RenderType renderType) throws IllegalArgumentException {
        return t.registerNewObjective(s, s1, s2, renderType);
    }

    @Override
    public @Nullable Objective getObjective(@NotNull String name) throws IllegalArgumentException {
        return t.getObjective(name);
    }

    @Override
    public @NotNull Set<Objective> getObjectivesByCriteria(@NotNull String criteria) throws IllegalArgumentException {
        return t.getObjectivesByCriteria(criteria);
    }

    @Override
    public @NotNull Set<Objective> getObjectives() {
        return t.getObjectives();
    }

    @Override
    public @Nullable Objective getObjective(@NotNull DisplaySlot slot) throws IllegalArgumentException {
        return t.getObjective(slot);
    }

    @Override
    @Deprecated
    public @NotNull Set<Score> getScores(@NotNull OfflinePlayer player) throws IllegalArgumentException {
        return t.getScores(player);
    }

    @Override
    public @NotNull Set<Score> getScores(@NotNull String entry) throws IllegalArgumentException {
        return t.getScores(entry);
    }

    @Override
    @Deprecated
    public void resetScores(@NotNull OfflinePlayer player) throws IllegalArgumentException {
        t.resetScores(player);
    }

    @Override
    public void resetScores(@NotNull String entry) throws IllegalArgumentException {
        t.resetScores(entry);
    }

    @Override
    @Deprecated
    public @Nullable Team getPlayerTeam(@NotNull OfflinePlayer player) throws IllegalArgumentException {
        return t.getPlayerTeam(player);
    }

    @Override
    public @Nullable Team getEntryTeam(@NotNull String entry) throws IllegalArgumentException {
        return t.getEntryTeam(entry);
    }

    @Override
    public @Nullable Team getTeam(@NotNull String teamName) throws IllegalArgumentException {
        return t.getTeam(teamName);
    }

    @Override
    public @NotNull Set<Team> getTeams() {
        return t.getTeams();
    }

    @Override
    public @NotNull Team registerNewTeam(@NotNull String name) throws IllegalArgumentException {
        return t.registerNewTeam(name);
    }

    @Override
    @Deprecated
    public @NotNull Set<OfflinePlayer> getPlayers() {
        return t.getPlayers();
    }

    @Override
    public @NotNull Set<String> getEntries() {
        return t.getEntries();
    }

    @Override
    public void clearSlot(@NotNull DisplaySlot slot) throws IllegalArgumentException {
        t.clearSlot(slot);
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
