package com.dmalch.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static com.dmalch.sort.SortUtils.less;
import static com.dmalch.sort.SortUtils.swap;

public class QuickSort implements Sort {

    private static final transient Logger logger = LoggerFactory.getLogger(QuickSort.class);

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] unsortedArray) {

        logger.info(Arrays.toString(unsortedArray));

        doSort(unsortedArray, 0, unsortedArray.length - 1);

        return unsortedArray;
    }

    private <T extends Comparable<T>> void doSort(final T[] unsortedArray, final int startIndex, final int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int j = partition(unsortedArray, startIndex, endIndex);

        doSort(unsortedArray, startIndex, j - 1);
        doSort(unsortedArray, j + 1, endIndex);
    }

    private <T extends Comparable<T>> int partition(final T[] unsortedArray, final int startIndex, final int endIndex) {
        int leftIndex = startIndex + 1;
        int rightIndex = endIndex;
        int partitioningElementIndex = startIndex;
        T partitioningElement = unsortedArray[partitioningElementIndex];

        while (leftIndex < rightIndex) {
            if (less(unsortedArray[leftIndex], partitioningElement)) {
                leftIndex++;
            } else if (!less(unsortedArray[rightIndex], partitioningElement)) {
                rightIndex--;
            } else {
                swap(unsortedArray, leftIndex, rightIndex);
            }
        }

        if (less(unsortedArray[leftIndex], partitioningElement)) {
            swap(unsortedArray, startIndex, leftIndex);
            partitioningElementIndex = leftIndex;
        }

        logger.info(Arrays.toString(unsortedArray));

        return partitioningElementIndex;
    }
}
