package net.kbg.algo.search;

import java.util.ArrayList;

public class GenBinarySearch<T extends Comparable> {

    public int search(ArrayList<T> sorted, T x) {
        if (sorted == null || sorted.size() < 1) {
            throw new IllegalArgumentException();
        }
        int low = 0;
        int high = sorted.size() - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (sorted.get(mid).compareTo(x) < 0) {
                low = mid + 1;
            }
            else if (sorted.get(mid).compareTo(x) > 0) {
                high = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;   // not found
    }

}
