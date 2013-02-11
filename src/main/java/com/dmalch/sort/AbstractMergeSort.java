package com.dmalch.sort;

public abstract class AbstractMergeSort extends AbstractSort {
    protected <T extends Comparable<T>> void merge(final T[] unsortedArray, final T[] auxArray, final int start, final int end, final int mid) {

        int firstIndex = start;
        int secondIndex = mid;

        for (int i = start; i < end; i++) {
            if (firstIndex >= mid) {
                auxArray[i] = unsortedArray[secondIndex++];
            } else if (secondIndex >= end) {
                auxArray[i] = unsortedArray[firstIndex++];
            } else if (less(unsortedArray[firstIndex], unsortedArray[secondIndex])) {
                auxArray[i] = unsortedArray[firstIndex++];
            } else {
                auxArray[i] = unsortedArray[secondIndex++];
            }
        }
    }
}
