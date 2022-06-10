package edu.escuelaing.arsw.labs.calc.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.escuelaing.arsw.labs.calc.linkedList.MyLinkedList;
import edu.escuelaing.arsw.labs.calc.linkedList.Node;

public class MyIterator<E> implements Iterator<E> {

    private MyLinkedList<E> linkedList;
    private Node<E> previous, next;
    private int nextIndex;
    private boolean descending;

    public MyIterator(MyLinkedList<E> linkedList) {
        this.linkedList = linkedList;
        if (this.linkedList.size() > 0) {
            next = linkedList.getHead();
        }
    }

    public MyIterator(MyLinkedList<E> linkedList, boolean descending) {
        this.linkedList = linkedList;
        this.descending = descending;
        if (this.linkedList.size() > 0) {
            if (this.descending) {
                previous = this.linkedList.getTail();
                this.nextIndex = this.linkedList.size() - 1;
            } else {
                next = this.linkedList.getHead();
            }
        }
    }

    public MyIterator(MyLinkedList<E> linkedList, int nextIndex) {
        this.linkedList = linkedList;
        if (this.linkedList.size() > 0) {
            if (nextIndex == 0) {
                next = this.linkedList.getHead();
                this.nextIndex = nextIndex;
            } else if (nextIndex == this.linkedList.size() - 1) {
                next = this.linkedList.getTail();
                this.nextIndex = nextIndex;
            } else if (nextIndex == this.linkedList.size()) {
                next = null;
                this.nextIndex = nextIndex;
            } else if (0 < nextIndex && nextIndex < this.linkedList.size() - 1) {
                Node<E> currentNode = this.linkedList.getHead();
                int currentIndex = 0;
                while (currentIndex < nextIndex) {
                    currentNode = currentNode.getNext();
                    currentIndex++;
                }
                next = currentNode;
                this.nextIndex = nextIndex;
            }
        }
    }

    @Override
    public boolean hasNext() {
        if (descending) {
            return previous != null;
        } else {
            return next != null;
        }
    }

    @Override
    public E next() {
        if (hasNext()) {
            E value;
            if (descending) {
                value = previous.getValue();
                if (previous.hasPrior() && nextIndex >= 0) {
                    previous = previous.getPrior();
                } else {
                    previous = null;
                }
                nextIndex--;
            } else {
                value = next.getValue();
                if (next.hasNext()) {
                    next = next.getNext();
                } else {
                    next = null;
                }
                nextIndex++;
            }
            return value;
        }
        throw new NoSuchElementException();
    }

    public MyLinkedList<E> getLinkedList() {
        return linkedList;
    }

    public void setLinkedList(MyLinkedList<E> linkedList) {
        this.linkedList = linkedList;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public boolean isDescending() {
        return descending;
    }

    public void setDescending(boolean descending) {
        this.descending = descending;
    }

}
