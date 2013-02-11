package com.dmalch.priority;

import static com.dmalch.sort.AbstractHeapSort.siftDown;
import static com.dmalch.sort.AbstractHeapSort.siftUp;
import static java.lang.Math.min;
import static java.lang.System.arraycopy;

public class BinaryHeapPriorityQueue extends AbstractPriorityQueue {
    private final Integer[] heap;
    private int actualSize;

    public BinaryHeapPriorityQueue(final int maxSize) {
        heap = new Integer[maxSize + 1];
        actualSize = 0;
    }

    @Override
    protected Integer[] toArray() {
        final int size = min(actualSize, heap.length - 1);

        final Integer[] ret = new Integer[size];
        arraycopy(heap, 0, ret, 0, size);
        return ret;
    }

    @Override
    protected void insert(final Integer element) {
        heap[actualSize++] = element;
        siftUp(heap, 0, actualSize - 1);
    }

    @Override
    protected void deleteMax() {
        arraycopy(heap, 1, heap, 0, actualSize - 1);
        actualSize--;

        siftDown(heap, 0, actualSize - 1);
    }

    @Override
    protected boolean noMoreSpace() {
        return actualSize >= heap.length;
    }
}
