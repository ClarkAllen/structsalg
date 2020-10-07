package net.kbg.algo.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GenBubbleSortTest {

    @Test
    public void testSortingStrings() {
        GenBubbleSort<String> bubSort = new GenBubbleSort<>();
        ArrayList<String> list = new ArrayList(Arrays.asList(
                new String[] {"m", "k", "a", "x", "s"}));
        int len = list.size();
        System.out.println(list);
        bubSort.sort(list);
        System.out.println(list);
        assertEquals(len, list.size());
        for (int k = 0, b = 1; b < list.size(); ++k, ++b) {
            assertTrue(list.get(k).compareTo(list.get(b)) <= 0);
        }
    }
}
