package net.kbg.algo.sort;

import java.util.List;

public class GenQuickSort<T extends Comparable<T>> {

    /*
        The main function that implements QuickSort()
        arr[] --> Array to be sorted,
        low --> Starting index,
        high --> Ending index
    */
    public void sort(List<T> arry, int idxLo, int idxHi) {
        if (idxLo < idxHi) {
            int pi = partition(arry, idxLo, idxHi);
            System.out.println("pivot index is " + pi);
            sort(arry, idxLo, pi - 1);
            sort(arry, pi + 1, idxHi);
        }
    }

    /*
        This function takes last element as pivot,
        places the pivot element at its correct
        position in sorted array, and places all
        smaller (smaller than pivot) to left of
        pivot and all greater elements to right
        of pivot.
    */
    private int partition (List<T> arr, int low, int high) {
        // pivot (Element to be placed at right position)
        T pivot = arr.get(high);

        int i = (low - 1);  // Index of smaller element

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than the pivot
            if (arr.get(j).compareTo(pivot) < 0) {
                i++;    // increment index of smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void swap(List<T> arry, int idx1, int idx2) {
        T temp = arry.get(idx1);
        arry.set(idx1, arry.get(idx2));
        arry.set(idx2, temp);
    }

}
