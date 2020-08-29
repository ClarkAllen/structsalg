package net.kbg.structs.linkedlist;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LinkedListTest {

    @Test
    public void testAdd() {
        LinkedList<String> list = makeTripleList();
        assertEquals(3, list.size());
        System.out.println(list.toString());
    }

    @Test
    public void testAddOne() {
        LinkedList<String> list = makeUnitList();
        assertEquals(1, list.size());
        System.out.println(list.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNull() {
        LinkedList<String> list = new LinkedList<>();
        list.add(null);
    }

    @Test
    public void testGetAt() {
        LinkedList<String> list = makeTripleList();
        assertEquals(3, list.size());
        System.out.println(list.toString());
        assertEquals("one", list.getAt(0));
        System.out.println("index 0 = " + list.getAt(0));
        assertEquals("two", list.getAt(1));
        System.out.println("index 1 = " + list.getAt(1));
        assertEquals("three", list.getAt(2));
        System.out.println("index 2 = " + list.getAt(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetAtWithEmptyList() {
        LinkedList<String> list = new LinkedList<>();
        list.getAt(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetAtWithBadIndex() {
        LinkedList<String> list = makeTripleList();
        list.getAt(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAtNegativeIndex() {
        LinkedList<String> list = makeUnitList();
        list.getAt(-1);
    }

    @Test
    public void testRemove() {
        LinkedList<String> list = makeTripleList();
        assertEquals(3, list.size());

        String val = list.remove(2);
        assertNotNull(val);
        assertEquals("three", val);
        assertEquals(2, list.size());

        val = list.remove(1);
        assertNotNull(val);
        assertEquals("two", val);
        assertEquals(1, list.size());

        val = list.remove(0);
        assertNotNull(val);
        assertEquals("one", val);
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveForward() {
        LinkedList<String> list = makeTripleList();
        assertEquals(3, list.size());

        String val = list.remove(0);
        assertNotNull(val);
        assertEquals("one", val);
        assertEquals(2, list.size());

        val = list.remove(0);
        assertNotNull(val);
        assertEquals("two", val);
        assertEquals(1, list.size());

        val = list.remove(0);
        assertNotNull(val);
        assertEquals("three", val);
        assertEquals(0, list.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveBadIndex() {
        LinkedList<String> list = makeTripleList();
        list.remove(3);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveEmptyList() {
        LinkedList<String> list = new LinkedList<>();
        list.remove(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNegativeIndex() {
        LinkedList<String> list = makeTripleList();
        list.remove(-1);
    }

    @Test
    public void testClear() {
        LinkedList<String> list = makeTripleList();
        assertEquals(3, list.size());
        System.out.println(list.toString());
        list.clear();
        assertEquals(0, list.size());
        System.out.println(list.toString());
    }

    public LinkedList<String> makeTripleList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        return list;
    }

    public LinkedList<String> makeUnitList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("one");
        return list;
    }

}
