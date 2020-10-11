package net.kbg.algo.search;

import net.kbg.structs.graph.GraphNode;

import java.util.*;

public class BreadthFirstSearch<T> {

    public Optional<GraphNode<T>> search(GraphNode<T> start, T value) {
        Queue<GraphNode<T>> queue = new ArrayDeque<>();
        Set<GraphNode<T>> visited = new HashSet<>();
        queue.add(start);

        GraphNode<T> currentNode;

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            //System.out.println("node value : " + currentNode.toString());

            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                visited.add(currentNode);
                queue.addAll(currentNode.getNeighbors());
                queue.removeAll(visited);   // in case there are cycles in the graph.
            }
        }

        return Optional.empty();

    }
}
