package xyz.acrylicstyle.minecraft.v1_15_R1;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public interface IBlockAccess {
    Class<?> CLASS = getClassWithoutException("IBlockAccess");

    TileEntity getTileEntity(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition);
    IBlockData getType(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition);
    boolean isEmpty(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition);
    int getBlockPower(BlockPosition blockPosition, EnumDirection enumDirection);
}
