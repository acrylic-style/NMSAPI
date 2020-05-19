package xyz.acrylicstyle.minecraft.v1_15_R1;

import org.apache.commons.lang.NotImplementedException;
import org.jetbrains.annotations.Nullable;
import util.CollectionList;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Scoreboard extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("Scoreboard");

    public void resetPlayerScores(String s, ScoreboardObjective objective) {
        invoke("resetPlayerScores", s, objective.getHandle());
    }

    public ScoreboardObjective getObjective(@Nullable String s) {
        return new ScoreboardObjective(invoke("getObjective", s));
    }

    public ScoreboardObjective registerObjective(String s, Object iScoreboardCriteria, Object iChatBaseComponent, Object enumScoreboardHealthDisplay) {
        throw new NotImplementedException();
    }

    public void getObjectivesForCriteria(Object o1, String s, Consumer<Object> c) {
        try {
            ReflectionUtil
                    .getNMSClass("Scoreboard")
                    .getMethod("getObjectivesForCriteria", ReflectionUtil.getNMSClass("IScoreboardCriteria"), s.getClass(), c.getClass())
                    .invoke(o, o1, s, c);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean b(String s, ScoreboardObjective scoreboardObjective) {
        return (boolean) invoke("b", s, scoreboardObjective.getHandle());
    }

    public Object getPlayerScoreForObjective(String s, ScoreboardObjective scoreboardObjective) {
        return invoke("getPlayerScoreForObjective", s, scoreboardObjective.getHandle());
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Collection<Object> getScoresForObjective(ScoreboardObjective scoreboardObjective) {
        return (Collection) invoke("getScoresForObjective", scoreboardObjective.getHandle());
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public CollectionList<ScoreboardObjective> getObjectives() {
        return new CollectionList(((Collection) invoke("getObjectives")).stream().map(ScoreboardObjective::new).collect(Collectors.toList()));
    }

    @SuppressWarnings("unchecked")
    public Collection<String> d() {
        return (Collection<String>) invoke("d");
    }

    public Collection<String> getObjectiveNames() {
        return d();
    }

    @SuppressWarnings("unchecked")
    public Collection<String> getPlayers() {
        return (Collection<String>) invoke("getPlayers");
    }

    public Map<ScoreboardObjective, Object> getPlayerObjectives(String s) {
        throw new NotImplementedException();
    }

    public void unregisterObjective(ScoreboardObjective scoreboardObjective) {
        invoke("unregisterObjective", scoreboardObjective.getHandle());
    }

    public void setDisplaySlot(int i, ScoreboardObjective scoreboardObjective) {
        invoke("setDisplaySlot", i, scoreboardObjective.getHandle());
    }

    public ScoreboardObjective getObjectiveForSlot(int i) {
        return new ScoreboardObjective(invoke("getObjectiveForSlot", i));
    }

    public Object getTeam(String s) {
        return invoke("getTeam", s);
    }

    public Object createTeam(String s) {
        return invoke("createTeam", s);
    }

    public void removeTeam(Object o) {
        throw new NotImplementedException();
    }

    public boolean addPlayerToTeam(String s, Object o) {
        throw new NotImplementedException();
    }

    public boolean removePlayerFromTeam(String s) {
        return (boolean) invoke("remotePlayerFromTeam", s);
    }

    public void removePlayerFromTeam(String s, Object o) {
        throw new NotImplementedException();
    }

    @SuppressWarnings("unchecked")
    public Collection<String> f() {
        return (Collection<String>) invoke("f");
    }

    public Collection<Object> getTeams() {
        throw new NotImplementedException();
    }

    public Object getPlayerTeam(String s) {
        return invoke("getPlayerTeam", s);
    }

    public Scoreboard(Object o) {
        super(o, "Scoreboard");
    }
}
