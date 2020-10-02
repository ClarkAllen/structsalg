package net.kbg.algo.search;

public class BinarySearch {

    // returns the integer index of the element if found.
    public int search(int[] sorted, int x) {
        if (sorted.length < 1) {
            throw new IllegalArgumentException();
        }
        int low = 0;
        int high = sorted.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (sorted[mid] < x) {
                low = mid + 1;
            }
            else if (sorted[mid] > x) {
                high = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;   // not found
    }
}
