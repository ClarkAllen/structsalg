package net.kbg.algo.sort;

public class MergeSort {

    public void sort(int[] arry) {
        if (arry == null) {
            throw new IllegalArgumentException();
        }
        int[] helpArry = new int[arry.length];
        mergesort(arry, helpArry, 0, arry.length - 1);
    }

    private void mergesort(int[] arry, int[] helpArry, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesort(arry, helpArry, low, middle);
            mergesort(arry, helpArry, middle + 1, high);
            merge(arry, helpArry, low, middle, high);
        }
    }

    private void merge(int[] arry, int[] helpArry, int low, int middle, int high) {
        for (int k = low; k <= high; ++k) {
            helpArry[k] = arry[k];
        }

        int helpLeft = low;
        int helpRight = middle + 1;
        int current = low;

        while (helpLeft <= middle && helpRight <= high) {
            if (helpArry[helpLeft] <= helpArry[helpRight]) {
                arry[current] = helpArry[helpLeft];
                ++helpLeft;
            } else {
                arry[current] = helpArry[helpRight];
                ++helpRight;
            }
            ++current;
        }

        int remaining = middle - helpLeft;
        for (int b = 0; b <= remaining; ++b) {
            arry[current + b] = helpArry[helpLeft + b];
        }
    }


}
