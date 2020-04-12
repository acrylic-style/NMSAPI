package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public class GameRules {
    public static final Class<?> CLASS = getClassWithoutException("GameRules");

    public static final GameRules DO_FIRE_TICK = new GameRules("DO_FIRE_TICK");
    public static final GameRules MOB_GRIEFING = new GameRules("MOB_GRIEFING");
    public static final GameRules KEEP_INVENTORY = new GameRules("KEEP_INVENTORY");
    public static final GameRules DO_MOB_SPAWNING = new GameRules("DO_MOB_SPAWNING");
    public static final GameRules DO_MOB_LOOT = new GameRules("DO_MOB_LOOT");
    public static final GameRules DO_TILE_DROPS = new GameRules("DO_TILE_DROPS");
    public static final GameRules DO_ENTITY_DROPS = new GameRules("DO_ENTITY_DROPS");
    public static final GameRules COMMAND_BLOCK_OUTPUT = new GameRules("COMMAND_BLOCK_OUTPUT");
    public static final GameRules NATURAL_REGENERATION = new GameRules("NATURAL_REGENERATION");
    public static final GameRules DO_DAYLIGHT_CYCLE = new GameRules("DO_DAYLIGHT_CYCLE");
    public static final GameRules LOG_ADMIN_COMMANDS = new GameRules("LOG_ADMIN_COMMANDS");
    public static final GameRules SHOW_DEATH_MESSAGES = new GameRules("SHOW_DEATH_MESSAGES");
    public static final GameRules RANDOM_TICK_SPEED = new GameRules("RANDOM_TICK_SPEED");
    public static final GameRules SEND_COMMAND_FEEDBACK = new GameRules("SEND_COMMAND_FEEDBACK");
    public static final GameRules REDUCED_DEBUG_INFO = new GameRules("REDUCED_DEBUG_INFO");
    public static final GameRules SPECTATORS_GENERATE_CHUNKS = new GameRules("SPECTATORS_GENERATE_CHUNKS");
    public static final GameRules SPAWN_RADIUS = new GameRules("SPAWN_RADIUS");
    public static final GameRules DISABLE_ELYTRA_MOVEMENT_CHECK = new GameRules("DISABLE_ELYTRA_MOVEMENT_CHECK");
    public static final GameRules MAX_ENTITY_CRAMMING = new GameRules("MAX_ENTITY_CRAMMING");
    public static final GameRules DO_WEATHER_CYCLE = new GameRules("DO_WEATHER_CYCLE");
    public static final GameRules DO_LIMITED_CRAFTING = new GameRules("DO_LIMITED_CRAFTING");
    public static final GameRules MAX_COMMAND_CHAIN_LENGTH = new GameRules("MAX_COMMAND_CHAIN_LENGTH");
    public static final GameRules ANNOUNCE_ADVANCEMENTS = new GameRules("ANNOUNCE_ADVANCEMENTS");
    public static final GameRules DISABLE_RAIDS = new GameRules("DISABLE_RAIDS");
    public static final GameRules DO_INSOMNIA = new GameRules("DO_INSOMNIA");
    public static final GameRules DO_IMMEDIATE_RESPAWN = new GameRules("DO_IMMEDIATE_RESPAWN");
    public static final GameRules DROWNING_DAMAGE = new GameRules("DROWNING_DAMAGE");
    public static final GameRules FALL_DAMAGE = new GameRules("FALL_DAMAGE");
    public static final GameRules FIRE_DAMAGE = new GameRules("FIRE_DAMAGE");
    public static final GameRules DO_PATROL_SPAWNING = new GameRules("DO_PATROL_SPAWNING");
    public static final GameRules DO_TRADER_SPAWNING = new GameRules("DO_TRADER_SPAWNING");

    public static GameRules getCustomGameRule(String s) { return new GameRules(s); }

    private String key;

    private GameRules(String s) {
        this.key = s;
    }

    public Object toNMSGameRule() {
        try {
            return ReflectionUtil.getNMSClass("GameRules").getField(key).get(null);
        } catch (IllegalAccessException | ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }
}
