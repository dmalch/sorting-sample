package com.dmalch.priority;

public abstract class AbstractPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {
    @Override
    public Object[] addAllAndDeleteMax(final E[] unsortedEvenArray) {
        for (final E element : unsortedEvenArray) {
            insert(element);

            if (noMoreSpace()) {
                deleteMax();
            }
        }

        return toArray();
    }

    protected abstract Object[] toArray();

    protected abstract boolean noMoreSpace();
}
