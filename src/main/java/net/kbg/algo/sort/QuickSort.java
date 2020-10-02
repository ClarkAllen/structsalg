package net.kbg.algo.sort;

public class QuickSort {

    public void print(int[] arry) {
        System.out.print("{");
        for (int k = 0; k < arry.length - 1; ++k) {
            System.out.print(arry[k]);
            System.out.print(",");
        }
        System.out.print(arry[arry.length - 1]);
        System.out.println("}");
    }

    /*
        The main function that implements QuickSort()
        arr[] --> Array to be sorted,
        low --> Starting index,
        high --> Ending index
	*/
    public void sort(int[] arry, int idxLo, int idxHi) {
        if (idxLo < idxHi) {
            int pi = partition(arry, idxLo, idxHi);
            //System.out.println("pivot index is " + pi);
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
    private int partition (int arr[], int low, int high) {
        // pivot (Element to be placed at right position)
        int pivot = arr[high];

        int i = (low - 1);  // Index of smaller element

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;    // increment index of smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void swap(int[] arry, int idx1, int idx2) {
        int temp = arry[idx1];
        arry[idx1] = arry[idx2];
        arry[idx2] = temp;
        //print(arry);
    }
}
