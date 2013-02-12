package com.dmalch.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static com.dmalch.sort.HeapUtils.siftDown;
import static com.dmalch.sort.SortUtils.swap;

public class TopDownHeapSort implements Sort {

    private static final transient Logger logger = LoggerFactory.getLogger(TopDownHeapSort.class);

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] unsortedArray) {

        logger.info(Arrays.toString(unsortedArray));

        heapify(unsortedArray);

        doSort(unsortedArray);

        return unsortedArray;
    }

    private <T extends Comparable<T>> void heapify(final T[] unsortedArray) {
        for (int i = (unsortedArray.length - 2) / 2; i >= 0; i--) {
            siftDown(unsortedArray, i, unsortedArray.length - 1);

            logger.info(Arrays.toString(unsortedArray));
        }
    }

    private <T extends Comparable<T>> void doSort(final T[] unsortedArray) {
        for (int i = unsortedArray.length - 1; i >= 0; i--) {
            swap(unsortedArray, 0, i);

            siftDown(unsortedArray, 0, i - 1);

            logger.info(Arrays.toString(unsortedArray));
        }
    }
}
