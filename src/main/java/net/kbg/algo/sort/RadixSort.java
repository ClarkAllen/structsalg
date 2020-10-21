package net.kbg.algo.sort;

import java.util.Arrays;

public class RadixSort {

    public void sort(int[] nums) {
        // Find the maximum number to know number of digits
        int max = findMaxEntry(nums);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(nums, nums.length, exp);
    }

    private int findMaxEntry(int[] nums) {
        int max = nums[0];
        for (int k = 1; k < nums.length; ++k) {
            if (nums[k] > max) {
                max = nums[k];
            }
        }
        return max;
    }

    // Do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arry[], int n, int exp) {
        int output[] = new int[n]; // output array
        int count[] = new int[10];   // 10 places for base 10 numbers.
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++)
            count[(arry[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // the position of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arry[i] / exp) % 10] - 1] = arry[i];
            count[(arry[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (int i = 0; i < n; i++)
            arry[i] = output[i];
    }

}
