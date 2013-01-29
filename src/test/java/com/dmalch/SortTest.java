package com.dmalch;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SortTest {

    public static final int[] UNSORTED_ARRAY = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static final int[] SORTED_ARRAY = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    public void testSortIsCorrect() throws Exception {
        final int[] unsortedArray = givenUnsortedArray();

        final int[] sortedArray = whenSort(unsortedArray);

        thenTheArrayIsSorted(sortedArray);
    }

    private void thenTheArrayIsSorted(final int[] sortedArray) {
        assertThat(sortedArray, equalTo(SORTED_ARRAY));
    }

    private int[] whenSort(final int[] unsortedArray) {
        return new InsertionSort().sort(unsortedArray);
    }

    private int[] givenUnsortedArray() {
        return UNSORTED_ARRAY;
    }
}
