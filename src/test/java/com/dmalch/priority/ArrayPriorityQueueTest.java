package com.dmalch.priority;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ArrayPriorityQueueTest {
    public static final Integer[] UNSORTED_ARRAY = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static final Integer[] TOP_5_FROM_ARRAY = {12, 11, 10, 9, 8};
    public static final Integer[] EMPTY_ARRAY = new Integer[]{};

    @Test
    public void testGeneralArray() throws Exception {
        doTest(UNSORTED_ARRAY, TOP_5_FROM_ARRAY);
    }

    @Test
    public void testEmptyArray() throws Exception {
        doTest(EMPTY_ARRAY, EMPTY_ARRAY);
    }

    private void doTest(final Integer[] unsortedArray, final Integer[] expectedArray) {
        final ArrayPriorityQueue priorityQueue = new ArrayPriorityQueue(5);

        final Integer[] top5 = priorityQueue.addAllAndDeleteMin(unsortedArray);

        assertThat(top5, equalTo(expectedArray));
    }
}
