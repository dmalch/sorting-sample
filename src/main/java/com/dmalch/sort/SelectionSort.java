package com.dmalch.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static com.dmalch.sort.SortUtils.less;
import static com.dmalch.sort.SortUtils.swap;

public class SelectionSort implements Sort {

    private static final transient Logger logger = LoggerFactory.getLogger(SelectionSort.class);

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] unsortedArray) {

        logger.info(Arrays.toString(unsortedArray));

        for (int i = 0; i < unsortedArray.length; i++) {
            final int indexOfMinimalElement = findIndexOfMinimalElementFrom(i, unsortedArray);

            swap(unsortedArray, i, indexOfMinimalElement);

            logger.info(Arrays.toString(unsortedArray));
        }

        return unsortedArray;
    }

    private <T extends Comparable<T>> int findIndexOfMinimalElementFrom(final int startIndex, final T[] unsortedArray) {
        int indexOfMin = startIndex;

        for (int i = startIndex + 1; i < unsortedArray.length; i++) {
            if (less(unsortedArray[i], unsortedArray[indexOfMin])) {
                indexOfMin = i;
            }
        }

        return indexOfMin;
    }
}
