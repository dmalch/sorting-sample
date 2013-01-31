package com.dmalch;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public abstract class AbstractSortTest {
    public static final Integer[] UNSORTED_ARRAY = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static final Integer[] SORTED_ARRAY = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    @Test
    public void testSortIsCorrect() throws Exception {
        final Integer[] unsortedArray = givenUnsortedArray();

        final Integer[] sortedArray = whenSort(unsortedArray);

        thenTheArrayIsSorted(sortedArray);
    }

    private void thenTheArrayIsSorted(final Integer[] sortedArray) {
        assertThat(sortedArray, equalTo(SORTED_ARRAY));
    }

    private Integer[] whenSort(final Integer[] unsortedArray) {
        return sort().sort(unsortedArray);
    }

    protected abstract Sort sort();

    private Integer[] givenUnsortedArray() {
        return UNSORTED_ARRAY;
    }
}
