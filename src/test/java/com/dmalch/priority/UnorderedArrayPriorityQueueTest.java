package com.dmalch.priority;

public class UnorderedArrayPriorityQueueTest extends AbstractPriorityQueueTest {

    @Override
    protected PriorityQueue<Integer> givenPriorityQueueWithSize(final int maxSize) {
        return new UnorderedArrayPriorityQueue<Integer>(maxSize);
    }
}
