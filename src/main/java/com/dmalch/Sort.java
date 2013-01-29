package com.dmalch;

public interface Sort {
    <T extends Comparable<T>> T[] sort(final T[] unsortedArray);
}
