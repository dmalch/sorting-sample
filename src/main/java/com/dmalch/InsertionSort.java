package com.dmalch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class InsertionSort implements Sort {

    private static final transient Logger logger = LoggerFactory.getLogger(InsertionSort.class);

    @Override
    public int[] sort(final int[] unsortedArray) {

        logger.info(Arrays.toString(unsortedArray));

        for (int i = 0; i < unsortedArray.length; i++) {
            final int indexOfMinimalElement = findIndexOfMinimalElementFrom(i, unsortedArray);

            swap(i, indexOfMinimalElement, unsortedArray);

            logger.info(Arrays.toString(unsortedArray));
        }

        return unsortedArray;
    }

    private void swap(final int i, final int indexOfMinimalElement, final int[] unsortedArray) {
        final int tmp = unsortedArray[indexOfMinimalElement];
        unsortedArray[indexOfMinimalElement] = unsortedArray[i];
        unsortedArray[i] = tmp;
    }

    private int findIndexOfMinimalElementFrom(final int startIndex, final int[] unsortedArray) {
        int min = unsortedArray[startIndex];
        int indexOfMin = startIndex;

        for (int i = startIndex; i < unsortedArray.length; i++) {
            if (unsortedArray[i] < min) {
                min = unsortedArray[i];
                indexOfMin = i;
            }
        }

        return indexOfMin;
    }
}
