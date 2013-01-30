package com.dmalch;

public abstract class AbstractSort {

    protected <T extends Comparable<T>> boolean less(final T[] unsortedArray, final int firstIndex, final int secondIndex) {
        return unsortedArray[firstIndex].compareTo(unsortedArray[secondIndex]) < 0;
    }

    protected <T extends Comparable<T>> void swap(final T[] unsortedArray, final int firstIndex, final int secondIndex) {
        final T tmp = unsortedArray[secondIndex];
        unsortedArray[secondIndex] = unsortedArray[firstIndex];
        unsortedArray[firstIndex] = tmp;
    }
}