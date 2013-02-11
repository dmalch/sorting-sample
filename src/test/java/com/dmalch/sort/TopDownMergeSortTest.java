package com.dmalch.sort;

public class TopDownMergeSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new TopDownMergeSort();
    }

}
