package edu.escuelaing.arsw.labs.calc.linkedList;

public class Node<E> {
    private E value;
    private Node<E> next, prior;

    public Node(E value) {
        this.value = value;
    }

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    public Node(E value, Node<E> next, Node<E> prior) {
        this.value = value;
        this.next = next;
        this.prior = prior;
    }

    public Node<E> copy() {
        return new Node<E>(value, next, prior);
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrior() {
        return prior != null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrior() {
        return prior;
    }

    public void setPrior(Node<E> prior) {
        this.prior = prior;
    }

}
