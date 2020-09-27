package net.kbg.structs.simplelinkedlist;

import java.util.NoSuchElementException;

/*
    A simplified LinkedList implementation that requires the user
    to keep track of the root element on his/her own.
 */
public class Node<T> {
    private Node next = null;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public void append(T data) {
        Node end = new Node(data);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public boolean hasNext() {
        return next != null;
    }

    public Node next() {
        if (next != null) {
            return next;
        }
        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
