package com.dmalch.priority;

import static com.dmalch.sort.HeapUtils.siftDown;
import static com.dmalch.sort.HeapUtils.siftUp;
import static java.lang.Math.min;
import static java.lang.System.arraycopy;
import static java.util.Arrays.copyOf;

public class BinaryHeapPriorityQueue<E extends Comparable<E>> extends AbstractPriorityQueue<E> {
    private final E[] heap;
    private int actualSize;

    public BinaryHeapPriorityQueue(final int maxSize) {
        heap = (E[]) new Comparable[maxSize + 1];
        actualSize = 0;
    }

    @Override
    protected E[] toArray(final Class<? extends E[]> aClass) {
        final int size = min(actualSize, heap.length - 1);

        return copyOf(heap, size, aClass);
    }

    @Override
    public void insert(final E element) {
        heap[actualSize++] = element;
        siftUp(heap, 0, actualSize - 1);
    }

    @Override
    public void deleteMax() {
        arraycopy(heap, 1, heap, 0, actualSize - 1);
        actualSize--;

        siftDown(heap, 0, actualSize - 1);
    }

    @Override
    protected boolean noMoreSpace() {
        return actualSize >= heap.length;
    }
}
