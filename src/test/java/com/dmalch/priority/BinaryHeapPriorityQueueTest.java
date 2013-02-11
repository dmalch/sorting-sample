package com.dmalch.priority;

public class BinaryHeapPriorityQueueTest extends AbstractPriorityQueueTest {

    @Override
    protected PriorityQueue givenPriorityQueueWithSize(final int maxSize) {
        return new BinaryHeapPriorityQueue(maxSize);
    }
}
