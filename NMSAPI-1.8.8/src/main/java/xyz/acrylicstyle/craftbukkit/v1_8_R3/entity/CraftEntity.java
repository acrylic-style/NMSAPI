package xyz.acrylicstyle.craftbukkit.v1_8_R3.entity;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.util.Handler;
import xyz.acrylicstyle.shared.OBCAPI;

/**
 * Placeholder class(for now) to make easier to get nms instance
 */
public class CraftEntity extends OBCAPI implements Handler<xyz.acrylicstyle.minecraft.Entity> {
    @NotNull
    @Override
    @Contract(value = "-> new", pure = true)
    public xyz.acrylicstyle.minecraft.Entity getHandle() {
        return new xyz.acrylicstyle.minecraft.Entity(getOBCClass());
    }

    /**
     * Constructs CraftEntity.
     * @param o Object. Compatible types:
     *          <ul>
     *          <li>obc.CraftEntity</li>
     *          <li>org.bukkit.entity.Entity</li>
     *          </ul>
     */
    public CraftEntity(@NotNull Object o) {
        super(o, "CraftEntity");
    }

    protected CraftEntity(Object o, String clazz) {
        super(o, clazz);
    }
}
