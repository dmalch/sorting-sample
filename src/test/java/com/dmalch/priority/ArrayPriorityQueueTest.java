package com.dmalch.priority;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ArrayPriorityQueueTest {
    public static final Integer[] UNSORTED_EVEN_ARRAY = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static final Integer[] TOP_5_FROM_EVEN_ARRAY = {12, 11, 10, 9, 8};

    @Test
    public void test() throws Exception {
        final ArrayPriorityQueue priorityQueue = new ArrayPriorityQueue(5);

        final Integer[] top5 = priorityQueue.addAllAndDeleteMin(UNSORTED_EVEN_ARRAY);

        assertThat(top5, equalTo(TOP_5_FROM_EVEN_ARRAY));
    }
}
