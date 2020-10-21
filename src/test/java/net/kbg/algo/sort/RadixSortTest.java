package net.kbg.algo.sort;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RadixSortTest {

    @Test
    public void testRadixSort(){
        RadixSort radixSort = new RadixSort();
        int[] nums = new int[] { 170, 45, 75, 90, 802, 24, 2, 66 };
        print(nums);
        radixSort.sort(nums);
        print(nums);
        for (int k = 0, b = 1; b < nums.length; ++k, ++b) {
            assertTrue(nums[k] <= nums[b]);
        }
    }

    private void print(int[] nums) {
        String rslt = "[";
        for (int k = 0; k < nums.length - 1; ++k) {
            rslt += nums[k] + ",";
        }
        rslt += nums[nums.length - 1] + "]";
        System.out.println(rslt);
    }

}
