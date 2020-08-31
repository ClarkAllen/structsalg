package net.kbg.algo.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BubbleSortTest {

    private BubbleSort bubSort;

    @Before
    public void init() {
        bubSort = new BubbleSort();
    }

    @Test
    public void testSort() {
        int[] arry = new int[] {23, 5, 19, 10, 6, 16, 1, 7};
        int len = arry.length;
        print(arry);
        bubSort.sort(arry);
        print(arry);
        assertEquals(len, arry.length);
        for (int b = 0; b < arry.length - 1; ++b) {
            assertTrue(arry[b] < arry[b+1]);
        }
    }

    @Test
    public void testShortArray() {
        int[] arry = new int[] {5};
        print(arry);
        bubSort.sort(arry);
        print(arry);
        assertEquals(5, arry[0]);
    }

    @Test
    public void testEmptyArray() {
        int[] arry = new int[] {};
        print(arry);
        bubSort.sort(arry);
        print(arry);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullArray() {
        bubSort.sort(null);
    }

    private void print(int[] arry) {
        System.out.print("[ ");
        for (int g : arry) {
            System.out.print(g + " ");
        }
        System.out.println("]");
    }
}

