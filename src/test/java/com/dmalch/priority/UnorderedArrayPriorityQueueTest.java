package com.dmalch.priority;

public class UnorderedArrayPriorityQueueTest extends AbstractPriorityQueueTest {

    @Override
    protected UnorderedArrayPriorityQueue givenPriorityQueueWithSize(final int maxSize) {
        return new UnorderedArrayPriorityQueue(maxSize);
    }
}
