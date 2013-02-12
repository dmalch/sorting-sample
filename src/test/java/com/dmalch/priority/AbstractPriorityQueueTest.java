package com.dmalch.priority;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;

public abstract class AbstractPriorityQueueTest {
    public static final Integer[] UNSORTED_ARRAY = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static final Integer[] TOP_5_FROM_ARRAY = {5, 4, 3, 2, 1};
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
        final PriorityQueue<Integer> priorityQueue = givenPriorityQueueWithSize(5);

        final Integer[] top5 = whenAddValuesToQueue(unsortedArray, priorityQueue);

        assertThat(top5, arrayContainingInAnyOrder(expectedArray));
    }

    private Integer[] whenAddValuesToQueue(final Integer[] unsortedArray, final PriorityQueue<Integer> priorityQueue) {
        final Object[] objects = priorityQueue.addAllAndDeleteMax(unsortedArray);
        return Arrays.copyOf(objects, objects.length, unsortedArray.getClass());
    }

    protected abstract PriorityQueue<Integer> givenPriorityQueueWithSize(int maxSize);
}
