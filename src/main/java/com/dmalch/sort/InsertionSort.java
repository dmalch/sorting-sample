package com.dmalch.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class InsertionSort extends AbstractSort implements Sort {

    private static final transient Logger logger = LoggerFactory.getLogger(InsertionSort.class);

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] unsortedArray) {

        logger.info(Arrays.toString(unsortedArray));

        for (int i = 1; i < unsortedArray.length; i++) {
            swapIfInIncorrectOrder(i, unsortedArray);

            logger.info(Arrays.toString(unsortedArray));
        }

        return unsortedArray;
    }

    private <T extends Comparable<T>> void swapIfInIncorrectOrder(final int startIndex, final T[] unsortedArray) {
        for (int j = startIndex; j > 0 && less(unsortedArray[j], unsortedArray[(j - 1)]); j--) {
            swap(unsortedArray, j, j - 1);
        }
    }
}
