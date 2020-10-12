package net.kbg.algo.search;

import net.kbg.structs.graph.GraphNode;

import java.util.*;

public class DepthFirstSearch<T> {

    private Map<GraphNode<T>, List<GraphNode<T>>> adjacencyList;

    private DepthFirstSearch() {}

    public DepthFirstSearch(Map<GraphNode<T>, List<GraphNode<T>>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public Optional<GraphNode<T>> search(GraphNode<T> start, T value) {
        Stack<GraphNode<T>> stack = new Stack<>();
        Set<GraphNode<T>> visited = new HashSet<>();
        stack.push(start);
        while ( ! stack.isEmpty() ) {
            GraphNode<T> current = stack.pop();
            visited.add(current);
            if (current.getValue().equals(value)) {
                return Optional.of(current);
            }
            for (GraphNode<T> node : adjacencyList.keySet()) {
                if ( ! visited.contains(node) ) {
                    stack.push(node);
                }
            }
        }
        return Optional.empty();
    }

}
