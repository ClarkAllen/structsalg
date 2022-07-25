package net.kbg.probs.mcdowell.support;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList <T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private ListNode<T> current;

    private int size;

    public LinkedList() {
        head = new ListNode<>();
        tail = head;
        current = head;
        size = 0;
    }

    public void append(T tdata) {
        ListNode<T> td = new ListNode(tdata);
        tail.setNext(td);
        tail = td;
        current = td;
        size += 1;
    }

    public int size() {
        return size;
    }

    private ListNode<T> getNext() {
        if (current.getNext() != null) {
            return current.getNext();
        }
        throw new NoSuchElementException();
    }

    public ListNode<T> get(int index) {
        checkIndex(index);
        current = head.getNext();
        for (int k = 1; k <= index; ++k) {
            current = current.getNext();
        }
        return current;
    }

    public ListNode<T> remove(int index) {
        checkIndex(index);
        ListNode<T> node = null;
        if (index == 0) {
            node = head.getNext().getNext();
            head.setNext(node);
            head.getNext().setPrev(null);
            --size;
            current = head;
        } else {
            node = get(index);
            ListNode<T> prev = node.getPrev();
            prev.setNext(node.getNext());
            --size;
            current = head;
        }
        return node;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList<?> that = (LinkedList<?>) o;
        return size == that.size && Objects.equals(head, that.head) && Objects.equals(tail, that.tail) && Objects.equals(current, that.current);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, current, size);
    }

    @Override
    public String toString() {
        String content = "";
        ListNode<T>  fst = head.getNext();
        for (int k = 0; k < size; ++k) {
            if (fst != null) {
                content += "," + fst.toString();
                fst = fst.getNext();
            }
        }
        if (content.startsWith(",")) {
            content = content.substring(1);
        }
        return "LinkedList{" +
                content +
                ", size=" + size +
                '}';
    }
}
