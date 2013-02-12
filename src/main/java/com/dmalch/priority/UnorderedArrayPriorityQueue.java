package com.dmalch.priority;

import com.dmalch.sort.AbstractSort;

import static java.lang.Math.min;
import static java.util.Arrays.copyOf;

public class UnorderedArrayPriorityQueue<E extends Comparable<E>> extends AbstractPriorityQueue<E> {
    private final E[] queue;
    private int actualSize;

    public UnorderedArrayPriorityQueue(final int maxSize) {
        queue = (E[]) new Comparable[maxSize + 1];
        actualSize = 0;
    }

    @Override
    protected E[] toArray(final Class<? extends E[]> aClass) {
        final int size = min(actualSize, queue.length - 1);

        return copyOf(queue, size, aClass);
    }

    @Override
    public void insert(final E element) {
        queue[actualSize++] = element;
    }

    @Override
    public void deleteMax() {
        Integer max = 0;

        for (int i = 1; i < queue.length; i++) {
            if (queue[max].compareTo(queue[i]) < 0) {
                max = i;
            }
        }

        AbstractSort.swap(queue, max, actualSize - 1);
        actualSize--;
    }

    @Override
    protected boolean noMoreSpace() {
        return actualSize >= queue.length;
    }

}
