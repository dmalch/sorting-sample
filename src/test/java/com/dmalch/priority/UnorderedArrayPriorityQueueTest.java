package com.dmalch.priority;

public class UnorderedArrayPriorityQueueTest extends AbstractPriorityQueueTest {

    @Override
    protected PriorityQueue givenPriorityQueueWithSize(final int maxSize) {
        return new UnorderedArrayPriorityQueue(maxSize);
    }
}
