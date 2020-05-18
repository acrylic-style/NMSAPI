package xyz.acrylicstyle.minecraft;

import java.util.Collection;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public interface IBlockState<T extends Comparable<T>> {
    Class<?> CLASS = getClassWithoutException("IBlockState");

    String a();
    Collection<T> c();
    Class<T> b();
    String a(T t);
}
