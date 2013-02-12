package com.dmalch.priority;

public abstract class AbstractPriorityQueue implements PriorityQueue {
    @Override
    public Integer[] addAllAndDeleteMax(final Integer[] unsortedEvenArray) {
        for (final Integer element : unsortedEvenArray) {
            insert(element);

            if (noMoreSpace()) {
                deleteMax();
            }
        }

        return toArray();
    }

    protected abstract Integer[] toArray();

    protected abstract boolean noMoreSpace();
}
