package net.kbg.probs.mcdowell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import net.kbg.probs.mcdowell.support.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Ch2Test {

    private Ch2 ch2;

    @Before
    public void init() {
        ch2 = new Ch2();
    }

    @Test
    public void removeDupesTest_uniques_list() {
        int expected = 5;
        List<String> list = makeUniqueTestList();
        List<String> rslt = ch2.removeDuplicates(list);
        System.out.println(rslt);
        Assert.assertEquals(expected, rslt.size());
    }

    @Test
    public void removeDupesTest_dupes_list() {
        int expected = 4;
        List<String> list = makeDuplicatesTestList();
        List<String> rslt = ch2.removeDuplicates(list);
        System.out.println(rslt);
        Assert.assertEquals(expected, rslt.size());
    }

    protected List<String> makeUniqueTestList() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        return list;
    }

    protected List<String> makeDuplicatesTestList() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("three");
        list.add("five");
        return list;
    }

}
