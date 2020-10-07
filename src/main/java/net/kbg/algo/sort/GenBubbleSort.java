package net.kbg.algo.sort;

import java.util.ArrayList;
import java.util.List;

public class GenBubbleSort<T extends Comparable<T>> {

    public void sort(ArrayList<T> items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
        for (int k = 0; k < items.size(); ++k) {
            for (int b = 0; b < items.size() - 1; ++b) {
                if (items.get(b).compareTo(items.get(b+1)) > 0) {
                    swap(b, b+1, items);
                }
            }
        }
    }

    private void swap(int idx1, int idx2, List<T> items) {
        T buf = items.get(idx1);
        items.set(idx1, items.get(idx2));
        items.set(idx2, buf);
    }
}
