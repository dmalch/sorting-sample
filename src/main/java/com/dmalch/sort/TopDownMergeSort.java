package com.dmalch.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static java.lang.System.arraycopy;

public class TopDownMergeSort extends AbstractMergeSort implements Sort {

    private static final transient Logger logger = LoggerFactory.getLogger(TopDownMergeSort.class);

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] unsortedArray) {

        logger.info(Arrays.toString(unsortedArray));

        int mid = unsortedArray.length / 2;

        final T[] auxArray = unsortedArray.clone();

        mergeRecursively(unsortedArray, auxArray, 0, unsortedArray.length, mid);

        arraycopy(auxArray, 0, unsortedArray, 0, unsortedArray.length);

        return unsortedArray;
    }

    private <T extends Comparable<T>> void mergeRecursively(final T[] unsortedArray, final T[] auxArray, final int start, final int end, final int mid) {
        if (end - start <= 1) {
            return;
        }

        int mid1 = start + (mid - start) / 2;
        mergeRecursively(auxArray, unsortedArray, start, mid, mid1);

        int mid2 = mid + (end - mid) / 2;
        mergeRecursively(auxArray, unsortedArray, mid, end, mid2);

        merge(unsortedArray, auxArray, start, end, mid);

        logger.info(Arrays.toString(auxArray));
    }

}
