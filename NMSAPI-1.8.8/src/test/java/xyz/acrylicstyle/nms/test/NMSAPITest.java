package xyz.acrylicstyle.nms.test;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.Test;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.support.DummyServer;
import xyz.acrylicstyle.minecraft.NBTTagCompound;

import java.util.UUID;

public class NMSAPITest {
    static { new DummyServer(); }

    private NBTTagCompound getNBTTagCompound() {
        ItemStack item = new ItemStack(Material.STONE);
        xyz.acrylicstyle.minecraft.ItemStack itemStack = CraftItemStack.asNMSCopy(item);
        return itemStack.getTag();
    }

    //@Test
    public void storeString() {
        NBTTagCompound tag = getNBTTagCompound();
        String uuid = UUID.randomUUID().toString();
        tag.setString("uuid", uuid);
        assert tag.getString("uuid").equals(uuid);
    }

    //@Test
    public void storeInt() {
        NBTTagCompound tag = getNBTTagCompound();
        tag.setInt("integer", 155);
        assert tag.getInt("integer") == 155;
        tag.setInt("integer", Integer.MAX_VALUE);
        assert tag.getInt("integer") == Integer.MAX_VALUE;
    }

    //@Test
    public void storeBoolean() {
        NBTTagCompound tag = getNBTTagCompound();
        tag.setBoolean("boolean", true);
        assert tag.getBoolean("boolean");
        tag.setBoolean("boolean", false);
        assert !tag.getBoolean("boolean");
    }
}
