package xyz.acrylicstyle.minecraft.v1_8_R1;

import com.google.common.collect.ImmutableMap;

import java.util.Collection;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public interface IBlockData {
    Class<?> CLASS = getClassWithoutException("IBlockData");

    @SuppressWarnings("rawtypes")
    Collection<IBlockState> a();

    <T extends Comparable<T>> T get(IBlockState<T> iBlockState);

    <T extends Comparable<T>, V extends T> IBlockData set(IBlockState<T> iBlockState, V v);

    <T extends Comparable<T>> IBlockData a(IBlockState<T> iBlockState);

    @SuppressWarnings("rawtypes")
    ImmutableMap<IBlockState, Comparable> b();

    // Block getBlock();
}
