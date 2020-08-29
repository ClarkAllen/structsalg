package net.kbg.structs.linkedlist;

import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;

@NoArgsConstructor
public class LinkedList<T> {
    private Node<T> tail;
    private int size;

    public int size() {
        return size;
    }

    public Node<T> add(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        Node<T> newTail = new Node<>(data);
        if (size == 0) {
            newTail.setNext(newTail);  // point to the head.
        } else {
            newTail.setNext(tail.getNext());  // point to the head.
            tail.setNext(newTail);
        }
        tail = newTail;
        ++size;
        return newTail;
    }

    public void clear() {
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getAt(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (size == 0 || index >= size) {
            throw new NoSuchElementException();
        }

        Node<T> curr = tail.getNext();

        for (int k = 0; k < index; ++k) {
            curr = curr.getNext();
        }

        return curr.getData();
    }

    public T remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (size == 0 || index >= size) {
            throw new NoSuchElementException();
        }

        Node<T> curr = tail.getNext();  // may point to self if size == 1

        if (size == 1) {
            tail = null;
        }
        else if (index == 0) {
            tail.setNext(curr.getNext());
        } else {
            Node<T> before = tail;
            for (int k = 0; k < index; ++k) {
                before = curr;
                curr = curr.getNext();
            }
            before.setNext(curr.getNext());  // removing curr
        }
        --size;

        return curr.getData();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size == 0) {
            return "LinkedList{}";
        }

        Node<T> curr = tail.getNext();
        sb.append(curr.getData().toString());
        int tally = 1;

        while (tally < size) {
            Node<T> next = curr.getNext();
            sb.append(",")
                .append(next.getData().toString());
            ++tally;
            curr = next;
        }
        return "LinkedList{" + sb.toString() + "}";
    }
}
