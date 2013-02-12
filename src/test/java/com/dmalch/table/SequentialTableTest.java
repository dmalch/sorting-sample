package com.dmalch.table;

public class SequentialTableTest extends AbstractTableTest {

    @Override
    protected Table<Integer, Integer> givenTable() {
        return new SequentialTable<Integer, Integer>();
    }
}
