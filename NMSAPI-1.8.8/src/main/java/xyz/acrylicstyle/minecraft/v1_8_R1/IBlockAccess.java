package xyz.acrylicstyle.minecraft.v1_8_R1;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public interface IBlockAccess {
    Class<?> CLASS = getClassWithoutException("IBlockAccess");

    TileEntity getTileEntity(BlockPosition blockPosition);
    IBlockData getType(BlockPosition blockPosition);
    boolean isEmpty(BlockPosition blockPosition);
    int getBlockPower(BlockPosition blockPosition, EnumDirection enumDirection);
}
