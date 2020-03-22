package xyz.acrylicstyle.minecraft;

import java.util.Collection;

public interface IBlockState<T extends Comparable<T>> {
    String a();
    Collection<T> c();
    Class<T> b();
    String a(T t);
}
