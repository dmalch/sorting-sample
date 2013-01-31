package com.dmalch;

public class BottomUpMergeSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new BottomUpMergeSort();
    }

}
