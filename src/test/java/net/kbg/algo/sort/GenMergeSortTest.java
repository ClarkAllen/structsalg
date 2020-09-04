package net.kbg.algo.sort;

import org.junit.Test;

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
}
