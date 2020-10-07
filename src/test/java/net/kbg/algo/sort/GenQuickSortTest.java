package net.kbg.algo.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenQuickSortTest {

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
    public void testHappyPathSortIntegers() {
        ArrayList<Integer> arry = makeIntList();
        GenQuickSort qs = new GenQuickSort();
        qs.sort(arry, 0, arry.size() - 1);
        System.out.println(arry);
    }

    @Test
    public void testHappyPathSortStrings() {
        ArrayList<String> arry = makeStringList();
        GenQuickSort qs = new GenQuickSort();
        qs.sort(arry, 0, arry.size() - 1);
        System.out.println(arry);
    }

    private ArrayList<Integer> makeIntList() {
        ArrayList<Integer> arry = new ArrayList<>();
        arry.add(10);
        arry.add(7);
        arry.add(8);
        arry.add(9);
        arry.add(1);
        arry.add(5);
        return arry;
    }

    private ArrayList<String> makeStringList() {
        ArrayList<String> arry = new ArrayList<>();
        arry.add("ten");
        arry.add("seven");
        arry.add("eight");
        arry.add("nine");
        arry.add("one");
        arry.add("five");
        return arry;
    }

}
