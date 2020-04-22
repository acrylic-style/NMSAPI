package xyz.acrylicstyle.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import xyz.acrylicstyle.shared.NMSAPI;

@SuppressWarnings("unused")
public class WorldData extends NMSAPI {
    public static Class<?> CLASS = getClassWithoutException("WorldData");

    public static final EnumDifficulty a = EnumDifficulty.NORMAL;

    public static final EnumDifficulty NORMAL_DIFFICULTY = EnumDifficulty.NORMAL; // NMSAPI - OBFHelper

    public WorldServer world;

    public WorldData() { // NMSAPI - change protected to public
        super("WorldData");
        this.world = new WorldServer(getField("world"));
    }

    public WorldData(NBTTagCompound tag) {
        super("WorldData", tag.getHandle());
        this.world = new WorldServer(getField("world"));
    }

    public WorldData(WorldSettings worldSettings, String s) {
        super("WorldData", worldSettings.getHandle(), s);
        this.world = new WorldServer(getField("world"));
    }

    public void a(WorldSettings worldSettings) {
        invoke("a", worldSettings.getHandle());
        this.world = new WorldServer(getField("world"));
    }

    public WorldData(WorldData worldData) {
        super("WorldData", worldData.getHandle());
        this.world = worldData.world;
    }

    public NBTTagCompound a() {
        return new NBTTagCompound(invoke("a"));
    }

    public NBTTagCompound a(NBTTagCompound tag) {
        return new NBTTagCompound(invoke("a", tag.getHandle()));
    }

    public void a(NBTTagCompound tag, NBTTagCompound tag2) { // NMSAPI - change private to public
        invoke("a", tag.getHandle(), tag2.getHandle());
    }

    public long getSeed() {
        return field("b");
    }

    public int c() {
        return field("e");
    }

    public int d() {
        return field("f");
    }

    public int e() {
        return field("g");
    }

    public long getTime() {
        return field("h");
    }

    public long getDayTime() {
        return field("i");
    }

    public NBTTagCompound i() {
        return new NBTTagCompound(getField("l"));
    }

    public void setTime(long i) {
        invoke1("setTime", long.class, i);
    }

    public void setDayTime(long i) {
        invoke1("setDayTime", long.class, i);
    }

    public void setSpawn(BlockPosition blockPosition) {
        invoke("setSpawn", blockPosition.getHandle());
    }

    public String getName() {
        return field("n");
    }

    public void a(String s) {
        invoke("a", s);
    }

    public int l() {
        return field("o");
    }

    public void e(int i) {
        invoke1("e", int.class, i);
    }

    public int A() {
        return field("p");
    }

    public void i(int i) {
        invoke1("i", int.class, i);
    }

    public boolean isThundering() {
        return field("s");
    }

    public void setThundering(boolean flag) {
        World world = Bukkit.getWorld(getName());
        if (world != null) {
            ThunderChangeEvent thunder = new ThunderChangeEvent(world, flag);
            Bukkit.getServer().getPluginManager().callEvent(thunder);
            if (thunder.isCancelled()) return;
            setThunderDuration(0);
        }
        setField("s", flag);
    }

    public int getThunderDuration() {
        return field("t");
    }

    public void setThunderDuration(int i) {
        invoke1("setThunderDuration", int.class, i);
    }

    public boolean hasStorm() {
        return field("g");
    }

    public void setStorm(boolean flag) {
        World world = Bukkit.getWorld(getName());
        if (world != null) {
            WeatherChangeEvent weather = new WeatherChangeEvent(world, flag);
            Bukkit.getServer().getPluginManager().callEvent(weather);
            if (weather.isCancelled()) return;
            setWeatherDuration(0);
        }
        setField("g", flag);
    }

    public int getWeatherDuration() {
        return field("r");
    }

    public void setWeatherDuration(int i) {
        invoke1("setWeatherDuration", int.class, i);
    }

    public WorldSettings.EnumGamemode getGameType() {
        return WorldSettings.EnumGamemode.valueOf(getField("u"));
    }

    public boolean shouldGenerateMapFeatures() {
        return field("v");
    }

    public void f(boolean flag) {
        setField("v", flag);
    }

    public void setGameType(WorldSettings.EnumGamemode enumGameMode) {
        setField("u", enumGameMode.getHandle());
    }

    public boolean isHardcore() {
        return field("w");
    }

    public void g(boolean flag) {
        setField("g", flag);
    }

    public void setHardcore(boolean flag) { g(flag); } // NMSAPI - OBFHelper

    public WorldType getType() {
        return new WorldType(getField("c"));
    }

    public void a(WorldType worldType) {
        setField("c", worldType.getHandle());
    }

    public void setType(WorldType worldType) { a(worldType); } // NMSAPI - OBFHelper

    public String getGeneratorOptions() {
        return field("d");
    }

    public boolean v() {
        return field("x");
    }

    public void c(boolean flag) {
        setField("x", flag);
    }

    public boolean w() {
        return field("y");
    }

    public void d(boolean flag) {
        setField("y", flag);
    }

    public GameRules x() {
        return new GameRules(getField("K"));
    }

    public double C() {
        return field("B");
    }

    public double D() {
        return field("C");
    }

    public double E() {
        return field("D");
    }

    public void a(double d0) {
        setField("D", d0);
    }

    public long F() {
        return field("E");
    }

    public void e(long i) {
        invoke1("e", long.class, i);
    }

    public double G() {
        return field("F");
    }

    public void b(double d0) {
        invoke1("b", double.class, d0);
    }

    public void c(double d0) {
        invoke1("c", double.class, d0);
    }

    public void d(double d0) {
        invoke1("d", double.class, d0);
    }

    public double H() {
        return field("G");
    }

    public void e(double d0) {
        invoke1("e", double.class, d0);
    }

    public double I() {
        return field("H");
    }

    public void f(double d0) {
        invoke1("f", double.class, d0);
    }

    public int J() {
        return field("I");
    }

    public int K() {
        return field("J");
    }

    public void j(int i) {
        invoke1("j", int.class, i);
    }

    public void k(int i) {
        invoke1("k", int.class, i);
    }

    public EnumDifficulty getDifficulty() {
        return EnumDifficulty.valueOf(getField("z"));
    }

    public void setDifficulty(EnumDifficulty enumDifficulty) {
        invoke("setDifficulty", enumDifficulty.getHandle());
    }

    public boolean isDifficultyLocked() {
        return field("A");
    }

    public void e(boolean flag) {
        invoke1("e", boolean.class, flag);
    }

    public void a(CrashReportSystemDetails crashReportSystemDetails) {
        invoke("a", crashReportSystemDetails.getHandle());
    }

    public void checkName(String name) {
        invoke("checkName", name);
    }
}
