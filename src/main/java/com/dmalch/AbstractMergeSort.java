package com.dmalch;

import static java.lang.System.arraycopy;

public abstract class AbstractMergeSort extends AbstractSort {
    protected <T extends Comparable<T>> void merge(final T[] unsortedArray, final int start, final int end, final int mid) {

        Comparable[] auxArray = new Comparable[end - start];

        int firstIndex = start;
        int secondIndex = mid;

        for (int i = 0; i < auxArray.length; i++) {
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

        arraycopy(auxArray, 0, unsortedArray, start, end - start);
    }
}
