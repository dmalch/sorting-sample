package com.dmalch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static java.lang.System.arraycopy;

public class TopDownMergeSort extends AbstractSort implements Sort {

    private static final transient Logger logger = LoggerFactory.getLogger(TopDownMergeSort.class);

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] unsortedArray) {

        logger.info(Arrays.toString(unsortedArray));

        int mid = unsortedArray.length / 2;

        mergeRecursively(unsortedArray, 0, unsortedArray.length, mid);

        return unsortedArray;
    }

    private <T extends Comparable<T>> void mergeRecursively(final T[] unsortedArray, final int start, final int end, final int mid) {
        if (end - start <= 2) {
            if (less(unsortedArray[end - 1], unsortedArray[start])) {
                swap(unsortedArray, start, end - 1);
                logger.info(Arrays.toString(unsortedArray));
            }
            return;
        }

        int mid1 = start + (mid - start) / 2;
        mergeRecursively(unsortedArray, start, mid, mid1);

        int mid2 = mid + (end - mid) / 2;
        mergeRecursively(unsortedArray, mid, end, mid2);

        merge(unsortedArray, start, end, mid);

        logger.info(Arrays.toString(unsortedArray));
    }

    private <T extends Comparable<T>> void merge(final T[] unsortedArray, final int start, final int end, final int mid) {

        Object[] auxArray = new Object[end - start];

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
