package net.kbg.algo.search;

import net.kbg.algo.sort.GenQuickSort;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GenBinarySearchTest {

    @Test
    public void testFindHappyPath() {
        GenQuickSort<String> qs = new GenQuickSort<>();
        ArrayList<String> lst = makeStringList();
        qs.sort(lst, 0, lst.size() - 1);
        System.out.println(lst);
        GenBinarySearch<String> gbs = new GenBinarySearch<>();
        int rslt = gbs.search(lst, "delta");
        assertEquals(3, rslt);
    }

    @Test
    public void testFindNotFound() {
        GenQuickSort<String> qs = new GenQuickSort<>();
        ArrayList<String> lst = makeStringList();
        qs.sort(lst, 0, lst.size() - 1);
        System.out.println(lst);
        GenBinarySearch<String> gbs = new GenBinarySearch<>();
        int rslt = gbs.search(lst, "zulu");
        assertEquals(-1, rslt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionForEmptyList() {
        ArrayList<String> lst = new ArrayList<>();
        GenBinarySearch<String> gbs = new GenBinarySearch<>();
        gbs.search(lst, "zulu");
    }

    private ArrayList<String> makeStringList() {
        ArrayList<String> lst = new ArrayList<>();
        lst.add("alpha");
        lst.add("foxtrot");
        lst.add("delta");
        lst.add("bravo");
        lst.add("echo");
        lst.add("charlie");
        return lst;
    }
}
