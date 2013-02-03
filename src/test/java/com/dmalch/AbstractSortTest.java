package com.dmalch;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public abstract class AbstractSortTest {
    public static final Integer[] UNSORTED_EVEN_ARRAY = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static final Integer[] SORTED_EVEN_ARRAY = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public static final Integer[] UNSORTED_ODD_ARRAY = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static final Integer[] SORTED_ODD_ARRAY = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static final Integer[] UNSORTED_SHORT_ARRAY = {2, 1};
    public static final Integer[] SORTED_SHORT_ARRAY = {1, 2};

    public static final Integer[] EMPTY_ARRAY = {};

    @Test
    public void testSortIsCorrectForArraysWithEvenLength() throws Exception {
        doTestSortIsCorrect(UNSORTED_EVEN_ARRAY.clone(), SORTED_EVEN_ARRAY.clone());
    }

    @Test
    public void testSortIsCorrectForArraysWithOddLength() throws Exception {
        doTestSortIsCorrect(UNSORTED_ODD_ARRAY.clone(), SORTED_ODD_ARRAY.clone());
    }

    @Test
    public void testSortIsCorrectForArraysWithLittleLength() throws Exception {
        doTestSortIsCorrect(UNSORTED_SHORT_ARRAY.clone(), SORTED_SHORT_ARRAY.clone());
    }

    @Test
    public void testSortEmptyArray() throws Exception {
        doTestSortIsCorrect(EMPTY_ARRAY.clone(), EMPTY_ARRAY.clone());
    }

    private void doTestSortIsCorrect(final Integer[] unsortedArray, final Integer[] sortedArray) {
        final Integer[] actualSortedArray = whenSort(unsortedArray);

        assertThat(actualSortedArray, equalTo(sortedArray));
    }

    private Integer[] whenSort(final Integer[] unsortedArray) {
        return sort().sort(unsortedArray);
    }

    protected abstract Sort sort();

}
