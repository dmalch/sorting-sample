package com.dmalch.sort;

public class InsertionSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new InsertionSort();
    }

}
