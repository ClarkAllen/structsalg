package net.kbg.algo.sort;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    private MergeSort mgSort;

    @Before
    public void init() {
        mgSort = new MergeSort();
    }

    @Test
    public void testSort() {
        int[] arry = new int[] {23, 5, 19, 10, 6, 16, 1, 7};
        print(arry);
        mgSort.sort(arry);
        print(arry);

    }

    private void print(int[] arry) {
        System.out.print("[ ");
        for (int g : arry) {
            System.out.print(g + " ");
        }
        System.out.println("]");
    }

}
