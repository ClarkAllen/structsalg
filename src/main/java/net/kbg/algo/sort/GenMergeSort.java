package net.kbg.algo.sort;

import java.util.ArrayList;
import java.util.List;

public class GenMergeSort <T extends Comparable<T>> {

    public void sort(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        sort(list, 0, list.size() - 1);
    }
    
    private void sort(List<T> list, int left, int hi) {
        if (left < hi) {
            int mid = (left + hi) / 2;
            sort(list, left, mid);
            sort(list, mid + 1, hi);
            merge(list, left, mid, hi);
        }
    }
    
    private void merge(List<T> list, int low, int mid, int hi) {
        int n1 = mid - low + 1;
        int n2 = hi - mid;

        List<T> sub1 = new ArrayList<>();
        List<T> sub2 = new ArrayList<>();

        for (int i = 0; i < n1; ++i) {
            sub1.add(list.get(low + i));
        }

        for (int j = 0; j < n2; ++j) {
            sub2.add(list.get(mid + 1 + j));
        }
        
        int i = 0;
        int j = 0;

        int k = low;

        while (i < n1 && j < n2) {
            if (sub1.get(i).compareTo(sub2.get(j)) <= 0) {
                list.set(k, sub1.get(i));
                ++i;
            }
            else {
                list.set(k, sub2.get(j));
                ++j;
            }
            ++k;
        }

        // copy the remaining elements of sub1, if any.
        while (i < n1) {
            list.set(k, sub1.get(i));
            ++i;
            ++k;
        }

        // copy the remaining elements of sub2, if any.
        while (j < n2) {
            list.set(k, sub2.get(j));
            ++j;
            ++k;
        }
    }
    
}
