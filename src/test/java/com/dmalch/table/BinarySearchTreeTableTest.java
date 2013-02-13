package com.dmalch.table;

public class BinarySearchTreeTableTest extends AbstractTableTest {

    @Override
    protected Table<Integer, Integer> givenTable() {
        return new BinarySearchTreeTable<Integer, Integer>();
    }
}
