package com.dmalch.priority;

public abstract class AbstractPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {
    @Override
    public E[] addAllAndDeleteMax(final E[] unsortedEvenArray, final Class<? extends E[]> aClass) {
        for (final E element : unsortedEvenArray) {
            insert(element);

            if (noMoreSpace()) {
                deleteMax();
            }
        }

        return toArray(aClass);
    }

    protected abstract E[] toArray(final Class<? extends E[]> aClass);

    protected abstract boolean noMoreSpace();
}
