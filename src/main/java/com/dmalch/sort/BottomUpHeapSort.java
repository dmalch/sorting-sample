package com.dmalch.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static com.dmalch.sort.HeapUtils.siftDown;
import static com.dmalch.sort.HeapUtils.siftUp;
import static com.dmalch.sort.SortUtils.swap;

public class BottomUpHeapSort implements Sort {

    private static final transient Logger logger = LoggerFactory.getLogger(BottomUpHeapSort.class);

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] unsortedArray) {

        logger.info(Arrays.toString(unsortedArray));

        heapify(unsortedArray);

        doSort(unsortedArray);

        return unsortedArray;
    }

    private <T extends Comparable<T>> void doSort(final T[] unsortedArray) {
        for (int i = unsortedArray.length - 1; i >= 0; i--) {
            swap(unsortedArray, 0, i);

            siftDown(unsortedArray, 0, i - 1);

            logger.info(Arrays.toString(unsortedArray));
        }
    }

    private <T extends Comparable<T>> void heapify(final T[] unsortedArray) {
        for (int i = unsortedArray.length - 1; i > unsortedArray.length / 2; i--) {
            siftUp(unsortedArray, 0, i);

            logger.info(Arrays.toString(unsortedArray));
        }
    }

}
