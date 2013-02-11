package com.dmalch.sort;

public class QuickSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new QuickSort();
    }

}
