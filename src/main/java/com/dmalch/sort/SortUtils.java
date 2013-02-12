package com.dmalch.sort;

public final class SortUtils {

    public static <T extends Comparable<T>> boolean less(final T first, final T second) {
        return first.compareTo(second) < 0;
    }

    public static <T extends Comparable<T>> void swap(final T[] unsortedArray, final int firstIndex, final int secondIndex) {
        final T tmp = unsortedArray[secondIndex];
        unsortedArray[secondIndex] = unsortedArray[firstIndex];
        unsortedArray[firstIndex] = tmp;
    }
}