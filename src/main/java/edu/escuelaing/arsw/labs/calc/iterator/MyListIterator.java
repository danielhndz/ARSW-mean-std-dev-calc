package edu.escuelaing.arsw.labs.calc.iterator;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import edu.escuelaing.arsw.labs.calc.linkedList.MyLinkedList;

public class MyListIterator<E> extends MyIterator<E> implements ListIterator<E> {

    public MyListIterator(MyLinkedList<E> linkedList) {
        super(linkedList);
    }

    @Override
    public void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasPrevious() {
        if (isDescending()) {
            return getNext() != null;
        } else {
            return getPrevious() != null;
        }
    }

    @Override
    public int nextIndex() {
        return getNextIndex();
    }

    @Override
    public E previous() {
        if (hasPrevious()) {
            E value;
            if (isDescending()) {
                value = getNext().getValue();
                if (getNext().hasPrior() && getNextIndex() <= getLinkedList().size() - 1) {
                    setNext(getNext().getNext());
                } else {
                    setNext(null);
                }
                setNextIndex(getNextIndex() + 1);
            } else {
                value = getPrevious().getValue();
                if (getPrevious().hasNext()) {
                    setPrevious(getPrevious().getPrior());
                } else {
                    setPrevious(null);
                }
                setNextIndex(getNextIndex() - 1);
            }
            return value;
        }
        throw new NoSuchElementException();
    }

    @Override
    public int previousIndex() {
        if (isDescending()) {
            return getNextIndex() + 1;
        } else {
            return getNextIndex() - 1;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(E e) {
        throw new UnsupportedOperationException();
    }

}
