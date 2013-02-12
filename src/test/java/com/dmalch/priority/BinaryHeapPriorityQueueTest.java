package com.dmalch.priority;

public class BinaryHeapPriorityQueueTest extends AbstractPriorityQueueTest {

    @Override
    protected PriorityQueue<Integer> givenPriorityQueueWithSize(final int maxSize) {
        return new BinaryHeapPriorityQueue<Integer>(maxSize);
    }
}
