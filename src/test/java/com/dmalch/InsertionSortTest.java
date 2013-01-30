package com.dmalch;

public class InsertionSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new InsertionSort();
    }

}
