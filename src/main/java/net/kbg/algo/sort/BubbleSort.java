package net.kbg.algo.sort;

public class BubbleSort {

    public void sort(int[] arry) {
        if (arry == null) {
            throw new IllegalArgumentException();
        }
        for (int k = 0; k < arry.length; ++k) {
            for (int b = 0; b < arry.length -1; ++b) {
                if (arry[b] > arry[b+1]) {
                    swap(b, b+1, arry);
                }
            }
        }
    }

    public void swap(int idx1, int idx2, int[] arry) {
        int buf = arry[idx1];
        arry[idx1] = arry[idx2];
        arry[idx2] = buf;
    }

}
