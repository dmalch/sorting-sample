package com.dmalch.priority;

import static java.lang.Math.min;
import static java.lang.System.arraycopy;

public class UnorderedArrayPriorityQueue extends AbstractPriorityQueue {
    private final Integer[] queue;
    private int actualSize;

    public UnorderedArrayPriorityQueue(final int maxSize) {
        queue = new Integer[maxSize + 1];
        actualSize = 0;
    }

    @Override
    protected Integer[] toArray() {
        final int size = min(actualSize, queue.length - 1);

        final Integer[] ret = new Integer[size];
        arraycopy(queue, 0, ret, 0, size);
        return ret;
    }

    @Override
    protected void insert(final Integer element) {
        queue[actualSize++] = element;
    }

    @Override
    protected void deleteMax() {
        Integer max = 0;

        for (int i = 1; i < queue.length; i++) {
            if (queue[max].compareTo(queue[i]) < 0) {
                max = i;
            }
        }

        arraycopy(queue, max + 1, queue, max, queue.length - max - 1);
        actualSize--;
    }

    @Override
    protected boolean noMoreSpace() {
        return actualSize >= queue.length;
    }

}
