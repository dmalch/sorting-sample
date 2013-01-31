package com.dmalch;

public class TopDownMergeSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new TopDownMergeSort();
    }

}
