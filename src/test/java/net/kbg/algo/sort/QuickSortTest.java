package net.kbg.algo.sort;

import org.junit.Test;

public class QuickSortTest {

    /*
        the transition goes like this :
        {10,7,8,9,1,5}  original
        {1,7,8,9,10,5}  swap 10 and 1
        {1,5,8,9,10,7}  swap 7 and 5
        {1,5,7,9,10,8}  swap 8 and 7
        {1,5,7,8,10,9}  swap 9 and 8
        {1,5,7,8,9,10}  swap 10 and 9
     */
    @Test
    public void testHappyPathSort() {
        int[] arry = {10,7,8,9,1,5};
        QuickSort qs = new QuickSort();
        qs.sort(arry, 0, arry.length - 1);
        qs.print(arry);
    }
}
