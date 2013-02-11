package com.dmalch.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class TopDownHeapSort extends AbstractSort implements Sort {

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

    private <T extends Comparable<T>> void siftDown(final T[] unsortedArray, final int start, final int end) {
        int root = start;

        while (root * 2 + 1 <= end) {
            final int child = root * 2 + 1;
            int swap = root;

            if (less(unsortedArray[root], unsortedArray[child])) {
                swap = child;
            }

            if (child + 1 <= end && less(unsortedArray[swap], unsortedArray[child + 1])) {
                swap = child + 1;
            }

            if (swap != root) {
                swap(unsortedArray, root, swap);
                root = swap;
            } else {
                break;
            }
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
