package net.kbg.algo.search;

import net.kbg.structs.graph.GraphNode;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DepthFirstSearchTest {

    @Test
    public void testBFSHappyPathSearch() {
        Map<GraphNode<Integer>, List<GraphNode<Integer>>> adjList = makeAdjacencyList();
        DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>(adjList);

        for (GraphNode<Integer> node : adjList.keySet()) {
            for (int b = 10; b < 18; ++b) {
                Optional<GraphNode<Integer>> rslt = dfs.search(node, b);
                assertTrue(rslt.isPresent());
                assertEquals(b, rslt.get().getValue().intValue());
            }
            for (int g = 20; g < 27; ++g) {
                Optional<GraphNode<Integer>> rslt = dfs.search(node, g);
                assertTrue(rslt.isPresent());
                assertEquals(g, rslt.get().getValue().intValue());
            }
        }
    }

    @Test
    public void testBFSNotFoundSearch() {
        Map<GraphNode<Integer>, List<GraphNode<Integer>>> adjList = makeAdjacencyList();
        DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>(adjList);

        for (GraphNode<Integer> node : adjList.keySet()) {
            Optional<GraphNode<Integer>> rslt = dfs.search(node, 99);
            assertTrue(rslt.isEmpty());
        }
    }

    private <T> GraphNode<T> makeNode(T value) {
        GraphNode<T> node = new GraphNode<>(value);
        return node;
    }

    private List<GraphNode<Integer>> makeList(
            GraphNode<Integer> n1,
            GraphNode<Integer> n2,
            GraphNode<Integer> n3,
            GraphNode<Integer> n4
            ) {
        List<GraphNode<Integer>> list = new ArrayList<>();
        if (n1 != null) list.add(n1);
        if (n2 != null) list.add(n2);
        if (n3 != null) list.add(n3);
        if (n4 != null) list.add(n4);
        return list;
    }

    // make an undirected disconnected graph with cycles
    private Map<GraphNode<Integer>, List<GraphNode<Integer>>> makeAdjacencyList() {

        Map<GraphNode<Integer>, List<GraphNode<Integer>>> adjacencyList = new HashMap<>();
        List<GraphNode<Integer>> list = new ArrayList<>();

        GraphNode<Integer> root1 = makeNode(10);
        GraphNode<Integer> n11 = makeNode(11);
        GraphNode<Integer> n12 = makeNode(12);
        GraphNode<Integer> n13 = makeNode(13);
        GraphNode<Integer> n14 = makeNode(14);
        GraphNode<Integer> n15 = makeNode(15);
        GraphNode<Integer> n16 = makeNode(16);
        GraphNode<Integer> n17 = makeNode(17);

        adjacencyList.put(root1, makeList(n14, n16, null, null));
        adjacencyList.put(n11, makeList(n14, null, null, null));
        adjacencyList.put(n12, makeList(n14, null, null, null));
        adjacencyList.put(n13, makeList(n14, n16, n15, n17));
        adjacencyList.put(n14, makeList(n14, n16, root1, null));
        adjacencyList.put(n15, makeList(n13, n17, null, null));
        adjacencyList.put(n16, makeList(root1, n13, null, null));
        adjacencyList.put(n17, makeList(n14, n16, null, null));

        GraphNode<Integer> root2 = makeNode(20);
        GraphNode<Integer> n21 = makeNode(21);
        GraphNode<Integer> n22 = makeNode(22);
        GraphNode<Integer> n23 = makeNode(23);
        GraphNode<Integer> n24 = makeNode(24);
        GraphNode<Integer> n25 = makeNode(25);
        GraphNode<Integer> n26 = makeNode(26);

        adjacencyList.put(root2, makeList(n23, n22, n21, null));
        adjacencyList.put(n21, makeList(n24, root2, null, null));
        adjacencyList.put(n22, makeList(n24, root2, null, null));
        adjacencyList.put(n23, makeList(root2, n25, null, null));
        adjacencyList.put(n24, makeList(n22, n25, n21, null));
        adjacencyList.put(n25, makeList(n24, n26, n23, null));
        adjacencyList.put(n26, makeList(n25, null, null, null));

        return adjacencyList;
    }
}
