package com.dmalch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class BottomUpMergeSort extends AbstractMergeSort implements Sort {

    private static final transient Logger logger = LoggerFactory.getLogger(BottomUpMergeSort.class);

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] unsortedArray) {
        logger.info(Arrays.toString(unsortedArray));

        int subArrayLength = 1;

        do {
            mergeAllSubArrays(unsortedArray, subArrayLength);

            subArrayLength = determineNextSubArrayLength(subArrayLength, unsortedArray.length);
        } while (subArrayLength < unsortedArray.length);

        return unsortedArray;
    }

    private <T extends Comparable<T>> void mergeAllSubArrays(final T[] unsortedArray, final int subArrayLength) {
        final int stepLength = subArrayLength * 2;

        for (int start = 0; start < unsortedArray.length; start += stepLength) {
            final int end = start + stepLength <= unsortedArray.length ? start + stepLength : unsortedArray.length;
            merge(unsortedArray, start, end, start + subArrayLength);
            logger.info(Arrays.toString(unsortedArray));
        }
    }

    private int determineNextSubArrayLength(final int subArrayLength, final int maxLength) {
        return subArrayLength >= maxLength ? maxLength : subArrayLength * 2;
    }
}
