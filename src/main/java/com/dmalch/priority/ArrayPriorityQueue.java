package com.dmalch.priority;

import static java.lang.Math.*;
import static java.lang.System.arraycopy;

public class ArrayPriorityQueue {
    private final Integer[] queue;
    private int actualSize;

    public ArrayPriorityQueue(final int maxSize) {
        queue = new Integer[maxSize + 1];
    }

    public Integer[] addAllAndDeleteMin(final Integer[] unsortedEvenArray) {
        for (final Integer element : unsortedEvenArray) {

            if (noMoreSpace()) {
                deleteMin();
            }

            insert(element);
        }

        return toArray();
    }

    private Integer[] toArray() {
        final int size = min(actualSize, queue.length - 1);

        final Integer[] ret = new Integer[size];
        arraycopy(queue, 0, ret, 0, size);
        return ret;
    }

    private void insert(final Integer element) {
        queue[actualSize++] = element;
    }

    private void deleteMin() {
        Integer min = 0;

        for (int i = 1; i < queue.length; i++) {
            if (queue[min].compareTo(queue[i]) > 0) {
                min = i;
            }
        }

        arraycopy(queue, min + 1, queue, min, queue.length - min - 1);
        actualSize--;
    }

    private boolean noMoreSpace() {
        return actualSize >= queue.length;
    }

}
