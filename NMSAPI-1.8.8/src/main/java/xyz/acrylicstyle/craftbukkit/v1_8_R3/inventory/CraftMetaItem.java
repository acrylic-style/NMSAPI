package xyz.acrylicstyle.craftbukkit.v1_8_R3.inventory;

import com.google.common.collect.ImmutableMap;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;
import xyz.acrylicstyle.minecraft.NBTBase;
import xyz.acrylicstyle.minecraft.NBTTagCompound;
import xyz.acrylicstyle.minecraft.NBTTagList;
import xyz.acrylicstyle.shared.OBCAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@SuppressWarnings("unused")
public class CraftMetaItem extends OBCAPI implements ItemMeta, Repairable {
    public static final Class<?> CLASS = getClassWithoutException("inventory.CraftMetaItem");

    public static class ItemMetaKey extends OBCAPI {
        final String BUKKIT;

        final String NBT;

        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.FIELD})
        public @interface Specific {
            To value();

            enum To {
                BUKKIT, NBT
            }
        }

        ItemMetaKey(String both) {
            this(both, both);
        }

        ItemMetaKey(String nbt, String bukkit) {
            super("inventory.CraftMetaItem.ItemMetaKey", nbt, bukkit);
            this.NBT = (String) getField("NBT");
            this.BUKKIT = (String) getField("BUKKIT");
        }
    }

    public static final ItemMetaKey NAME = new ItemMetaKey("Name", "display-name");

    public static final ItemMetaKey DISPLAY = new ItemMetaKey("display");

    public static final ItemMetaKey LORE = new ItemMetaKey("Lore", "lore");

    public static final ItemMetaKey ENCHANTMENTS = new ItemMetaKey("ench", "enchants");

    public static final ItemMetaKey ENCHANTMENTS_ID = new ItemMetaKey("id");

    public static final ItemMetaKey ENCHANTMENTS_LVL = new ItemMetaKey("lvl");

    public static final ItemMetaKey REPAIR = new ItemMetaKey("RepairCost", "repair-cost");

    public static final ItemMetaKey ATTRIBUTES = new ItemMetaKey("AttributeModifiers");

    public static final ItemMetaKey ATTRIBUTES_IDENTIFIER = new ItemMetaKey("AttributeName");

    public static final ItemMetaKey ATTRIBUTES_NAME = new ItemMetaKey("Name");

    public static final ItemMetaKey ATTRIBUTES_VALUE = new ItemMetaKey("Amount");

    public static final ItemMetaKey ATTRIBUTES_TYPE = new ItemMetaKey("Operation");

    public static final ItemMetaKey ATTRIBUTES_UUID_HIGH = new ItemMetaKey("UUIDMost");

    public static final ItemMetaKey ATTRIBUTES_UUID_LOW = new ItemMetaKey("UUIDLeast");

    public static final ItemMetaKey HIDEFLAGS = new ItemMetaKey("HideFlags", "ItemFlags");

    public static final ItemMetaKey UNBREAKABLE = new ItemMetaKey("Unbreakable");

    @SuppressWarnings("deprecation")
    public static Map<Enchantment, Integer> buildEnchantments(NBTTagCompound tag, ItemMetaKey key) {
        if (!tag.hasKey(key.NBT)) return null;
        NBTTagList ench = tag.getList(key.NBT, 10);
        Map<Enchantment, Integer> enchantments = new HashMap<>(ench.size());
        for (int i = 0; i < ench.size(); i++) {
            int id = 0xFFFF & ench.get(i).getShort(ENCHANTMENTS_ID.NBT);
            int level = 0xFFFF & ench.get(i).getShort(ENCHANTMENTS_LVL.NBT);
            Enchantment e = Enchantment.getById(id);
            if (e != null) enchantments.put(e, level);
        }
        return enchantments;
    }

    @SuppressWarnings("unchecked")
    public static Map<Enchantment, Integer> buildEnchantments(Map<String, Object> map, ItemMetaKey key) {
        try {
            return (Map<Enchantment, Integer>) ReflectionUtil
                    .getOBCClass("inventory.CraftMetaItem")
                    .getMethod("buildEnchantments", map.getClass(), key.getHandle().getClass())
                    .invoke(null, map, key.getHandle());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void applyToItem(NBTTagCompound tag) {
        invoke("applyToItem", tag.getNMSClass());
    }

    public static NBTTagList createStringList(List<String> list) {
        if (list == null || list.isEmpty()) return null;
        return new NBTTagList().addAllString(list);
    }

    @SuppressWarnings("deprecation")
    public static void applyEnchantments(Map<Enchantment, Integer> enchantments, NBTTagCompound tag, ItemMetaKey key) {
        if (enchantments == null) return;
        NBTTagList list = new NBTTagList();
        for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
            NBTTagCompound subtag = new NBTTagCompound();
            subtag.setShort(ENCHANTMENTS_ID.NBT, (short) entry.getKey().getId());
            subtag.setShort(ENCHANTMENTS_LVL.NBT, entry.getValue().shortValue());
            list.add(subtag);
        }
        tag.set(key.NBT, list);
    }

    public void setDisplayTag(NBTTagCompound tag, String key, NBTBase value) {
        NBTTagCompound display = tag.getCompound(DISPLAY.NBT);
        if (!tag.hasKey(DISPLAY.NBT)) tag.set(DISPLAY.NBT, display);
        display.set(key, value);
    }

    public boolean applicableTo(Material type) {
        return type != Material.AIR;
    }

    public boolean isEmpty() {
        return (boolean) invoke("isEmpty");
    }

    public String getDisplayName() {
        return (String) getField("displayName");
    }

    public void setDisplayName(String name) {
        invoke("setDisplayName", name);
    }

    public CraftMetaItem(Object o) {
        super(o, "CraftMetaItem");
    }

    public CraftMetaItem() {
        super("CraftMetaItem");
    }

    // todo: SerializableMeta implements ConfigurationSerializable

    @Override
    public boolean hasDisplayName() {
        return (boolean) invoke("hasDisplayName");
    }

    @Override
    public boolean hasLore() {
        return (boolean) invoke("hasLore");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getLore() {
        return (List<String>) invoke("getLore");
    }

    @Override
    public void setLore(List<String> lore) {
        invoke("setLore", lore);
    }

    @Override
    public boolean hasEnchants() {
        return (boolean) invoke("hasEnchants");
    }

    @Override
    public boolean hasEnchant(Enchantment ench) {
        return (boolean) invoke("hasEnchant", ench);
    }

    @Override
    public int getEnchantLevel(Enchantment ench) {
        return (int) invoke("getEnchantLevel", ench);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<Enchantment, Integer> getEnchants() {
        return (Map<Enchantment, Integer>) invoke("getEnchants");
    }

    @Override
    public boolean addEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction) {
        return (boolean) invoke("addEnchant", ench, level, ignoreLevelRestriction);
    }

    @Override
    public boolean removeEnchant(Enchantment ench) {
        return (boolean) invoke("removeEnchant", ench);
    }

    @Override
    public boolean hasConflictingEnchant(Enchantment ench) {
        return (boolean) invoke("hasConflictingEnchant", ench);
    }

    @Override
    public void addItemFlags(ItemFlag... itemFlags) {
        invoke("addItemFlags", (Object) itemFlags);
    }

    @Override
    public void removeItemFlags(ItemFlag... itemFlags) {
        invoke("removeItemFlags", (Object) itemFlags);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<ItemFlag> getItemFlags() {
        return (Set<ItemFlag>) invoke("getItemFlags");
    }

    @Override
    public boolean hasItemFlag(ItemFlag flag) {
        return (boolean) invoke("hasItemFlag", flag);
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public CraftMetaItem clone() {
        return new CraftMetaItem(invoke("clone"));
    }

    @Override
    public boolean hasRepairCost() {
        return (boolean) invoke("hasRepairCost");
    }

    @Override
    public int getRepairCost() {
        return (int) invoke("getRepairCost");
    }

    @Override
    public void setRepairCost(int cost) {
        invoke("setRepairCost", cost);
    }

    @Override
    public Spigot spigot() {
        return (Spigot) invoke("spigot");
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> serialize() {
        return (Map<String, Object>) invoke("serialize");
    }

    public byte getBitModifier(ItemFlag hideFlag) {
        return (byte) (1 << hideFlag.ordinal());
    }

    public boolean equalsCommon(CraftMetaItem that) {
        return (boolean) invoke("equalsCommon", that.getHandle());
    }

    public boolean notUncommon(CraftMetaItem meta) {
        return (boolean) invoke("notUncommon", meta.getHandle());
    }

    public int applyHash() {
        return (int) invoke("applyHash");
    }

    public int hashCode() {
        return (int) invoke("hashCode");
    }

    @SuppressWarnings("unchecked")
    ImmutableMap.Builder<String, Object> serialize(ImmutableMap.Builder<String, Object> builder) {
        return (ImmutableMap.Builder<String, Object>) invoke("serialize", builder);
    }

    public static void serializeEnchantments(Map<Enchantment, Integer> enchantments, ImmutableMap.Builder<String, Object> builder, ItemMetaKey key) {
        if (enchantments == null || enchantments.isEmpty()) return;
        ImmutableMap.Builder<String, Integer> enchants = ImmutableMap.builder();
        for (Map.Entry<? extends Enchantment, Integer> enchant : enchantments.entrySet()) enchants.put(enchant.getKey().getName(), enchant.getValue());
        builder.put(key.BUKKIT, enchants.build());
    }

    public static void safelyAdd(Iterable<?> addFrom, Collection<String> addTo, int maxItemLength) {
        if (addFrom == null) return;
        for (Object object : addFrom) {
            if (!(object instanceof String)) {
                if (object != null) throw new IllegalArgumentException(addFrom + " cannot contain non-string " + object.getClass().getName());
                addTo.add("");
                continue;
            }
            String page = object.toString();
            if (page.length() > maxItemLength) page = page.substring(0, maxItemLength);
            addTo.add(page);
        }
    }

    public static boolean checkConflictingEnchants(Map<Enchantment, Integer> enchantments, Enchantment ench) {
        if (enchantments == null || enchantments.isEmpty()) return false;
        for (Enchantment enchant : enchantments.keySet()) if (enchant.conflictsWith(ench)) return true;
        return false;
    }

    public String toString() {
        return (String) invoke("toString");
    }

    public CraftMetaItem(CraftMetaItem meta) {
        super("CraftMetaItem", meta.getHandle());
    }

    public CraftMetaItem(NBTTagCompound tag) {
        super("CraftMetaItem", tag.getNMSClass());
    }

    public CraftMetaItem(Map<String, Object> map) {
        super("CraftMetaItem", map);
    }
}
