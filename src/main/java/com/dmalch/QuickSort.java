package com.dmalch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class QuickSort extends AbstractSort implements Sort {

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
        int partitioningElementIndex = startIndex;

        final ArrayList<T> lowerElements = new ArrayList<T>();
        final ArrayList<T> greaterElements = new ArrayList<T>();

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (less(unsortedArray[i], unsortedArray[partitioningElementIndex])) {
                lowerElements.add(unsortedArray[i]);
            } else {
                greaterElements.add(unsortedArray[i]);
            }
        }

        final Iterator<T> lowerIterator = lowerElements.iterator();
        final Iterator<T> greaterIterator = greaterElements.iterator();

        final T partitioningElement = unsortedArray[partitioningElementIndex];
        partitioningElementIndex = startIndex + lowerElements.size();

        for (int i = startIndex; i < unsortedArray.length; i++) {
            if (lowerIterator.hasNext()) {
                unsortedArray[i] = lowerIterator.next();
            } else if (i == partitioningElementIndex) {
                unsortedArray[partitioningElementIndex] = partitioningElement;
            } else if (greaterIterator.hasNext()) {
                unsortedArray[i] = greaterIterator.next();
            }
        }

        logger.info(Arrays.toString(unsortedArray));

        return partitioningElementIndex;
    }
}
