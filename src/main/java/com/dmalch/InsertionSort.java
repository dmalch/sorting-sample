package com.dmalch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class InsertionSort implements Sort {

    private static final transient Logger logger = LoggerFactory.getLogger(InsertionSort.class);

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] unsortedArray) {

        logger.info(Arrays.toString(unsortedArray));

        for (int i = 0; i < unsortedArray.length; i++) {
            final int indexOfMinimalElement = findIndexOfMinimalElementFrom(i, unsortedArray);

            swap(i, indexOfMinimalElement, unsortedArray);

            logger.info(Arrays.toString(unsortedArray));
        }

        return unsortedArray;
    }

    private <T extends Comparable<T>> void swap(final int i, final int indexOfMinimalElement, final T[] unsortedArray) {
        final T tmp = unsortedArray[indexOfMinimalElement];
        unsortedArray[indexOfMinimalElement] = unsortedArray[i];
        unsortedArray[i] = tmp;
    }

    private <T extends Comparable<T>> int findIndexOfMinimalElementFrom(final int startIndex, final T[] unsortedArray) {
        T min = unsortedArray[startIndex];
        int indexOfMin = startIndex;

        for (int i = startIndex; i < unsortedArray.length; i++) {
            if (unsortedArray[i].compareTo(min) < 0) {
                min = unsortedArray[i];
                indexOfMin = i;
            }
        }

        return indexOfMin;
    }
}
