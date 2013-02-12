package com.dmalch.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static com.dmalch.sort.SortUtils.less;
import static com.dmalch.sort.SortUtils.swap;

public class ShellSort implements Sort {

    private static final transient Logger logger = LoggerFactory.getLogger(ShellSort.class);

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] unsortedArray) {

        logger.info(Arrays.toString(unsortedArray));

        int h = calcH(unsortedArray);

        while (h >= 1) {
            doSort(h, unsortedArray);

            h = h / 3;
        }

        return unsortedArray;
    }

    private <T extends Comparable<T>> void doSort(final int h, final T[] unsortedArray) {
        for (int i = h; i < unsortedArray.length; i++) {
            swapIfInIncorrectOrder(i, h, unsortedArray);

            logger.info(Arrays.toString(unsortedArray));
        }
    }

    private <T extends Comparable<T>> void swapIfInIncorrectOrder(final int startIndex, final int h, final T[] unsortedArray) {
        for (int j = startIndex; j >= h && less(unsortedArray[j], unsortedArray[(j - h)]); j -= h) {
            swap(unsortedArray, j, j - h);
        }
    }

    private <T extends Comparable<T>> int calcH(final T[] unsortedArray) {
        int h = 1;
        while (h < unsortedArray.length / 3) h = 3 * h + 1;
        return h;
    }
}
