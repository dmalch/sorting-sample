package com.dmalch.sort;

public interface Sort {
    <T extends Comparable<T>> T[] sort(final T[] unsortedArray);
}
