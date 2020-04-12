package xyz.acrylicstyle.craftbukkit.v1_8_R3.scheduler;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;
import xyz.acrylicstyle.shared.OBCAPI;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class CraftScheduler extends OBCAPI implements BukkitScheduler {
    public static final Class<?> CLASS = getClassWithoutException("CraftScheduler");

    public CraftScheduler() {
        super("CraftScheduler");
    }

    public CraftScheduler(BukkitScheduler scheduler) {
        super(scheduler, "CraftScheduler");
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return (int) invoke("scheduleSyncDelayedTask", plugin, task, delay);
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task, long delay) {
        return (int) invoke("scheduleSyncDelayedTask", plugin, task, delay);
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
        return (int) invoke("scheduleSyncDelayedTask", plugin, task);
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task) {
        return (int) invoke("scheduleSyncDelayedTask", plugin, task);
    }

    @Override
    public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return (int) invoke("scheduleSyncRepeatingTask", plugin, task, delay, period);
    }

    @Override
    public int scheduleSyncRepeatingTask(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return (int) invoke("scheduleSyncDelayedTask", plugin, task, delay, period);
    }

    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return (int) invoke("scheduleAsyncDelayedTask", plugin, task, delay);
    }

    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
        return (int) invoke("scheduleAsyncDelayedTask", plugin, task);
    }

    @Override
    public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return (int) invoke("scheduleAsyncRepeatingTask");
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
        return (Future<T>) invoke("callSyncMethod", plugin, task);
    }

    @Override
    public void cancelTask(int taskId) {
        invoke("cancelTask", taskId);
    }

    @Override
    public void cancelTasks(Plugin plugin) {
        invoke("cancelTasks", plugin);
    }

    @Override
    public void cancelAllTasks() {
        invoke("cancelAllTasks");
    }

    @Override
    public boolean isCurrentlyRunning(int taskId) {
        return (boolean) invoke("isCurrentlyRunning", taskId);
    }

    @Override
    public boolean isQueued(int taskId) {
        return (boolean) invoke("isQueued");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BukkitWorker> getActiveWorkers() {
        return (List<BukkitWorker>) invoke("getActiveWorkers");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BukkitTask> getPendingTasks() {
        return (List<BukkitTask>) invoke("getPendingTasks");
    }

    @Override
    public BukkitTask runTask(Plugin plugin, Runnable task) throws IllegalArgumentException {
        return (BukkitTask) invoke("runTask", plugin, task);
    }

    @Override
    public BukkitTask runTask(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
        return (BukkitTask) invoke("runTask", plugin, task);
    }

    @Override
    public BukkitTask runTaskAsynchronously(Plugin plugin, Runnable task) throws IllegalArgumentException {
        return (BukkitTask) invoke("runTaskAsynchronously", plugin, task);
    }

    @Override
    public BukkitTask runTaskAsynchronously(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
        return (BukkitTask) invoke("runTaskAsynchronously", plugin, task);
    }

    @Override
    public BukkitTask runTaskLater(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
        return (BukkitTask) invoke("runTaskLater", plugin, task, delay);
    }

    @Override
    public BukkitTask runTaskLater(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
        return (BukkitTask) invoke("runTaskLater", plugin, task, delay);
    }

    @Override
    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
        return (BukkitTask) invoke("runTaskLaterAsynchronously", plugin, task, delay);
    }

    @Override
    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
        return (BukkitTask) invoke("runTaskLaterAsynchronously");
    }

    @Override
    public BukkitTask runTaskTimer(Plugin plugin, Runnable task, long delay, long period) throws IllegalArgumentException {
        return (BukkitTask) invoke("runTaskTimer", plugin, task, delay, period);
    }

    @Override
    public BukkitTask runTaskTimer(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
        return (BukkitTask) invoke("runTaskTimer", plugin, task, delay, period);
    }

    @Override
    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable task, long delay, long period) throws IllegalArgumentException {
        return (BukkitTask) invoke("runTaskTimerAsynchronously", plugin, task, delay, period);
    }

    @Override
    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
        return (BukkitTask) invoke("runTaskTimerAsynchronously", plugin, task, delay, period);
    }
}
