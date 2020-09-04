package net.kbg.algo.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GenMergeSortTest {

    @Test
    public void testSortString() {
        GenMergeSort<String> mergeSort = new GenMergeSort<>();
        List<String> list = Arrays.asList(
                new String[] {"m", "k", "a", "x", "s"});
        int len = list.size();
        System.out.println(list);
        mergeSort.sort(list);
        System.out.println(list);
        assertEquals(len, list.size());
        for (int k = 0, b = 1; b < list.size(); ++k, ++b) {
            assertTrue(list.get(k).compareTo(list.get(b)) <= 0);
        }
    }

    @Test
    public void testSortIntegers() {
        GenMergeSort<Integer> mergeSort = new GenMergeSort<>();
        List<Integer> list = makeIntegerList();
        int len = list.size();
        System.out.println(list);
        mergeSort.sort(list);
        System.out.println(list);
        assertEquals(len, list.size());
        for (int k = 0, b = 1; b < list.size(); ++k, ++b) {
            assertTrue(list.get(k).compareTo(list.get(b)) <= 0);
        }
    }

    private List<Integer> makeIntegerList() {
        List<Integer> list = new ArrayList<>();
        list.add(19);
        list.add(6);
        list.add(11);
        list.add(22);
        list.add(4);
        return list;
    }
}
