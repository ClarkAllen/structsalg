package net.kbg.structs.simplelinkedlist;

import org.junit.Test;

public class NodeTest {

    @Test
    public void testHappyPath() {
        Node<String> root = new Node<>("root");
        root.append("1: What's all this, then?");
        root.append("2: All this, and smarts too!");
        root.append("3: Then war came.");
        Node<String> n = root;
        while (n.hasNext()) {
            n = n.next();
            System.out.println(n);
        }
    }

}
