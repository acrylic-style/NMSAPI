package xyz.acrylicstyle.craftbukkit.v1_15_R1;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.shared.TypedOBCAPI;

import java.util.Collection;

public class CraftChunk extends TypedOBCAPI<Chunk> implements Chunk {
    public CraftChunk(Chunk chunk) {
        super(chunk, "CraftChunk");
    }

    @Override
    public int getX() {
        return t.getX();
    }

    @Override
    public int getZ() {
        return t.getZ();
    }

    @Override
    public @NotNull World getWorld() {
        return t.getWorld();
    }

    @Override
    public @NotNull Block getBlock(int x, int y, int z) {
        return t.getBlock(x, y, z);
    }

    @Override
    public @NotNull ChunkSnapshot getChunkSnapshot() {
        return t.getChunkSnapshot();
    }

    @Override
    public @NotNull ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain) {
        return t.getChunkSnapshot(includeMaxblocky, includeBiome, includeBiomeTempRain);
    }

    @NotNull
    @Override
    public Entity[] getEntities() {
        return t.getEntities();
    }

    @NotNull
    @Override
    public BlockState[] getTileEntities() {
        return t.getTileEntities();
    }

    @Override
    public boolean isLoaded() {
        return t.isLoaded();
    }

    @Override
    public boolean load(boolean generate) {
        return t.load(generate);
    }

    @Override
    public boolean load() {
        return t.load();
    }

    @Override
    public boolean unload(boolean save) {
        return t.unload(save);
    }

    @Override
    public boolean unload() {
        return t.unload();
    }

    @Override
    public boolean isSlimeChunk() {
        return t.isSlimeChunk();
    }

    @Override
    public boolean isForceLoaded() {
        return t.isForceLoaded();
    }

    @Override
    public void setForceLoaded(boolean forced) {
        t.setForceLoaded(forced);
    }

    @Override
    public boolean addPluginChunkTicket(@NotNull Plugin plugin) {
        return t.addPluginChunkTicket(plugin);
    }

    @Override
    public boolean removePluginChunkTicket(@NotNull Plugin plugin) {
        return t.removePluginChunkTicket(plugin);
    }

    @Override
    public @NotNull Collection<Plugin> getPluginChunkTickets() {
        return t.getPluginChunkTickets();
    }

    @Override
    public long getInhabitedTime() {
        return t.getInhabitedTime();
    }

    @Override
    public void setInhabitedTime(long ticks) {
        t.setInhabitedTime(ticks);
    }

    @Override
    public boolean contains(@NotNull BlockData block) {
        return t.contains(block);
    }

    @Override
    public xyz.acrylicstyle.minecraft.v1_15_R1.Chunk getHandle() {
        return new xyz.acrylicstyle.minecraft.v1_15_R1.Chunk(invoke("getHandle"));
    }
}
