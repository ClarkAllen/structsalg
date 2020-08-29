package net.kbg.structs.linkedlist;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
public class Node<T> {

    private T data;
    private Node next;

    public Node(T data) {
        this.data = data;
        next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
