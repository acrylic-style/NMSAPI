package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.shared.NMSAPI;

public class PlayerAbilities extends NMSAPI {
    public boolean isInvulnerable = field("isInvulnerable");
    public boolean isFlying = field("isFlying");
    public boolean canFly = field("canFly");
    public boolean canInstantlyBuild = field("canInstantlyBuild");
    public boolean mayBuild = field("mayBuild");
    public float flySpeed = field("flySpeed");
    public float walkSpeed = field("walkSpeed");

    public PlayerAbilities() {
        super("PlayerAbilities");
    }

    public void a(NBTTagCompound tag) {
        invoke("a", tag.getHandle());
    }

    public void saveTo(NBTTagCompound tag) { a(tag); } // NMSAPI - OBFHelper

    public void b(NBTTagCompound tag) {
        invoke("b", tag.getHandle());
    }

    public void loadFrom(NBTTagCompound tag) { b(tag); } // NMSAPI - OBFHelper

    public float a() {
        return field("flySpeed");
    }

    public float b() {
        return field("walkSpeed");
    }

    public float getFlySpeed() { return field("flySpeed"); }

    public float getWalkSpeed() { return field("walkSpeed"); }
}
