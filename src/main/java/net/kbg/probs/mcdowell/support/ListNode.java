package net.kbg.probs.mcdowell.support;

import java.util.Objects;

public class ListNode<T> {
    private ListNode prev;
    private ListNode next;
    private ListNode current;
    private T data;

    public ListNode(T tdat) {
        data = tdat;
        prev = null;
        next = null;
    }

    public ListNode() {
        data = null;
        prev = null;
        next = null;
    }

    public T get() {
        return data;
    }

    public ListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(ListNode<T> ln) {
        prev = ln;
    }

    public ListNode<T> getNext() {
        ListNode<T> n = null;
        if (current != null) {
            n = current.next;
        }
        return current;
    }

    public void setNext(ListNode<T> ln) {
        next = ln;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) o;
        return Objects.equals(prev, listNode.prev) && Objects.equals(next, listNode.next) && Objects.equals(current, listNode.current) && Objects.equals(data, listNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                '}';
    }
}
