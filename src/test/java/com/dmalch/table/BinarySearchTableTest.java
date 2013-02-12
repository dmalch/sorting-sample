package com.dmalch.table;

public class BinarySearchTableTest extends AbstractTableTest {

    @Override
    protected Table<Integer, Integer> givenTable() {
        return new BinarySearchTable<Integer, Integer>(6);
    }
}
