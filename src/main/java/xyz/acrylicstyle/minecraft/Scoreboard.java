package xyz.acrylicstyle.minecraft;

import org.apache.commons.lang.NotImplementedException;
import org.jetbrains.annotations.Nullable;
import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.craftbukkit.CraftUtils;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class Scoreboard {
    public void resetPlayerScores(String s, ScoreboardObjective objective) {
        invoke("resetPlayerScores", s, objective.getNMSScoreboard());
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
        return (boolean) invoke("b", s, scoreboardObjective.getNMSScoreboard());
    }

    public Object getPlayerScoreForObjective(String s, ScoreboardObjective scoreboardObjective) {
        return invoke("getPlayerScoreForObjective", s, scoreboardObjective.getNMSScoreboard());
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Collection<Object> getScoresForObjective(ScoreboardObjective scoreboardObjective) {
        return (Collection) invoke("getScoresForObjective", scoreboardObjective.getNMSScoreboard());
    }

    @SuppressWarnings("unchecked")
    public Collection<ScoreboardObjective> getObjectives() {
        return (Collection<ScoreboardObjective>) invoke("getObjectives");
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
        invoke("unregisterObjective", scoreboardObjective.getNMSScoreboard());
    }

    public void setDisplaySlot(int i, ScoreboardObjective scoreboardObjective) {
        invoke("setDisplaySlot", i, scoreboardObjective.getNMSScoreboard());
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

    // NMSAPI start
    private Object o;

    public Scoreboard(Object o) {
        this.o = o;
    }

    public Object getNMSScoreboard() {
        if (o.getClass().getCanonicalName().startsWith("net.minecraft.server") && o.getClass().getCanonicalName().endsWith("Scoreboard")) return o;
        try {
            return CraftUtils.getHandle(o);
        } catch (NoSuchMethodException e1) {
            try {
                return o.getClass().getDeclaredField("scoreboard").get(o);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                try {
                    return o.getClass().getDeclaredField("getScoreboard").get(o);
                } catch (IllegalAccessException | NoSuchFieldException ex) {
                    ex.printStackTrace();
                    return null;
                }
            }
        } catch (InvocationTargetException | IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("Scoreboard"), getNMSScoreboard(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("Scoreboard")
                    .getMethod(method)
                    .invoke(getNMSScoreboard());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("Scoreboard")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getNMSScoreboard(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
