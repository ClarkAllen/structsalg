package net.kbg.algo.search;

import net.kbg.structs.graph.GraphNode;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class BreadthFirstSearchTest {

    @Test
    public void testBFSHappyPathSearch() {
        GraphNode<Integer> n = makeTestGraph6V();
        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>();
        Optional<GraphNode<Integer>> rslt = bfs.search(n,6);
        assertTrue(rslt.isPresent());
        int value = rslt.get().getValue();
        assertEquals(6, value);
    }

    @Test
    public void testBFSNotFoundSearch() {
        GraphNode<Integer> n = makeTestGraph6V();
        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>();
        Optional<GraphNode<Integer>> rslt = bfs.search(n,22);
        assertTrue(rslt.isEmpty());
    }

    private <T> GraphNode<T> makeNode(T value) {
        GraphNode<T> n = new GraphNode<>(value);
        return n;
    }

    private GraphNode<Integer> makeTestGraph6V() {
        // 6 vertices undirected graph with cycles.
        GraphNode<Integer> n1 = makeNode(1);
        GraphNode<Integer> n2 = makeNode(2);
        GraphNode<Integer> n3 = makeNode(3);
        GraphNode<Integer> n4 = makeNode(4);
        GraphNode<Integer> n5 = makeNode(5);
        GraphNode<Integer> n6 = makeNode(6);

        n1.addNeighbor(n2);
        n1.addNeighbor(n4);

        n2.addNeighbor(n1);
        n2.addNeighbor(n4);
        n2.addNeighbor(n5);

        n3.addNeighbor(n5);
        n3.addNeighbor(n6);

        n4.addNeighbor(n1);
        n4.addNeighbor(n2);
        n4.addNeighbor(n5);

        n5.addNeighbor(n2);
        n5.addNeighbor(n3);
        n5.addNeighbor(n4);

        n6.addNeighbor(n3);

        return n1;
    }
}

