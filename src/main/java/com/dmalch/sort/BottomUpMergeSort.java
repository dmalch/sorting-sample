package com.dmalch.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static java.lang.System.arraycopy;

public class BottomUpMergeSort extends AbstractMergeSort implements Sort {

    private static final transient Logger logger = LoggerFactory.getLogger(BottomUpMergeSort.class);

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] unsortedArray) {
        logger.info(Arrays.toString(unsortedArray));

        int subArrayLength = 1;

        final T[] auxArray = unsortedArray.clone();

        final T[] resultArray = mergeAllSubArrays(unsortedArray, auxArray, subArrayLength);

        arraycopy(resultArray, 0, unsortedArray, 0, unsortedArray.length);

        return unsortedArray;
    }

    private <T extends Comparable<T>> T[] mergeAllSubArrays(final T[] unsortedArray, final T[] auxArray, final int subArrayLength) {
        if (subArrayLength >= unsortedArray.length) {
            return unsortedArray;
        }

        final int stepLength = subArrayLength * 2;

        for (int start = 0; start < unsortedArray.length; start += stepLength) {
            final int end = start + stepLength <= unsortedArray.length ? start + stepLength : unsortedArray.length;
            merge(unsortedArray, auxArray, start, end, start + subArrayLength);
            logger.info(Arrays.toString(auxArray));
        }

        final int newSubArrayLength = determineNextSubArrayLength(subArrayLength, unsortedArray.length);

        return mergeAllSubArrays(auxArray, unsortedArray, newSubArrayLength);
    }

    private int determineNextSubArrayLength(final int subArrayLength, final int maxLength) {
        return subArrayLength >= maxLength ? maxLength : subArrayLength * 2;
    }
}
