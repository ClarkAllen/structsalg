package net.kbg.algo.search;

import net.kbg.algo.sort.QuickSort;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void testSearchIntListHappyPath() {
        int[] nums = makeIntArray();
        QuickSort qs = new QuickSort();
        qs.print(nums);
        qs.sort(nums, 0, nums.length - 1);
        qs.print(nums);
        BinarySearch bs = new BinarySearch();

        int rslt = bs.search(nums, 3);
        assertEquals(2, rslt);

        rslt = bs.search(nums, 9);
        assertEquals(8, rslt);

        rslt = bs.search(nums, 1);
        assertEquals(0, rslt);

        rslt = bs.search(nums, 21);
        assertEquals(11, rslt);
    }

    @Test
    public void testSearchIntListNotFound() {
        int[] nums = makeIntArray();
        QuickSort qs = new QuickSort();
        qs.print(nums);
        qs.sort(nums, 0, nums.length - 1);
        qs.print(nums);

        BinarySearch bs = new BinarySearch();
        int rslt = bs.search(nums, 105);
        assertEquals(-1, rslt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroLengthArray() {
        BinarySearch bs = new BinarySearch();
        int[] zero = new int[]{};
        bs.search(zero, 10);
    }

    private int[] makeIntArray() {
        return new int[] {5,1,9,4,2,14,6,11,3,7,21,8};
    }
}
