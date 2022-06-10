package edu.escuelaing.arsw.labs.calc.linkedList;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import edu.escuelaing.arsw.labs.calc.iterator.MyIterator;
import edu.escuelaing.arsw.labs.calc.iterator.MyListIterator;

public class MyLinkedList<E> extends AbstractSequentialList<E> implements Deque<E>, Cloneable, Serializable {

    private Node<E> head, tail;
    private int size;

    /**
     * Constructs an empty list.
     */
    public MyLinkedList() {
    }

    /**
     * Constructs a list with the specified head.
     * 
     * @param head
     */
    public MyLinkedList(Node<E> head) {
        this.head = head;
        init();
    }

    @Override
    public boolean add(E e) {
        try {
            addLast(e);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public void addFirst(E e) {
        if (size == 0) {
            head = new Node<E>(e);
        } else {
            Node<E> newValue = new Node<>(e, head, tail);
            head.setPrior(newValue);
            head = newValue;
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        if (size > 0) {
            Node<E> newValue = new Node<>(e, null, tail);
            if (tail != null)
                tail.setNext(newValue);
            head.setPrior(newValue);
            tail = newValue;
        } else {
            head = new Node<E>(e);
        }
        size++;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new MyIterator<>(this, true);
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E getFirst() {
        if (size > 0) {
            return head.getValue();
        }
        throw new NoSuchElementException();
    }

    @Override
    public E getLast() {
        if (size > 0) {
            return tail.getValue();
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean offer(E e) {
        try {
            addFirst(e);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean offerFirst(E e) {
        try {
            addFirst(e);
            return true;
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean offerLast(E e) {
        try {
            addLast(e);
            return true;
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    @Override
    public E peekFirst() {
        try {
            return getFirst();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public E peekLast() {
        try {
            return getLast();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E pollFirst() {
        try {
            return removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public E pollLast() {
        try {
            return removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E removeFirst() {
        if (size > 0) {
            E value = head.getValue();
            switch (size) {
                case 1:
                    head = tail = null;
                    break;
                case 2:
                    head = tail;
                    head.setNext(null);
                    head.setPrior(null);
                    tail = null;
                    break;
                default:
                    head.getNext().setPrior(tail);
                    head = head.getNext();
                    break;
            }
            size--;
            return value;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E removeLast() {
        if (size > 0) {
            E last;
            switch (size) {
                case 1:
                    last = head.getValue();
                    head = tail = null;
                    break;
                case 2:
                    last = tail.getValue();
                    head.setNext(null);
                    tail = null;
                    break;
                default:
                    last = tail.getValue();
                    tail.getPrior().setNext(null);
                    head.setPrior(tail.getPrior());
                    tail = tail.getPrior();
                    break;
            }
            size--;
            return last;
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean removeLastOccurrence(Object arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator<>(this);
    }

    @Override
    public int size() {
        return size;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    private void init() {
        Node<E> currentNode = head;
        if (currentNode != null) {
            if (currentNode.hasNext()) {
                while (currentNode != null) {
                    if (currentNode.hasNext()) {
                        currentNode.getNext().setPrior(currentNode);
                    } else {
                        tail = currentNode;
                    }
                    currentNode = currentNode.getNext();
                    size++;
                }
            } else if (currentNode.hasPrior()) {
                Node<E> prev = null;
                while (currentNode != null) {
                    if (currentNode.hasPrior()) {
                        currentNode.setNext(currentNode.getPrior());
                    } else {
                        currentNode.setNext(null);
                        tail = currentNode;
                    }
                    currentNode.setPrior(prev);
                    prev = currentNode;
                    currentNode = currentNode.getNext();
                    size++;
                }
            }
        }
        if (size == 1) {
            head.setNext(null);
            head.setPrior(null);
            tail = head;
        }
    }
}
