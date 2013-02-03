package com.dmalch;

public class QuickSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new QuickSort();
    }

}
