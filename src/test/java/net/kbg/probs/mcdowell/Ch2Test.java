package net.kbg.probs.mcdowell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import net.kbg.probs.mcdowell.support.LinkedList;

public class Ch2Test {

    private Ch2 ch2;

    @Before
    public void init() {
        ch2 = new Ch2();
    }

    @Test
    public void removeDupesTest() {
        int expected = 5;
        LinkedList<String> list = makeTestList();
        System.out.println(list);
        Assert.assertEquals(expected, list.size());
    }

    protected LinkedList<String> makeTestList() {
        LinkedList<String> list = new LinkedList<>();
        list.append("one");
        list.append("two");
        list.append("three");
        list.append("four");
        list.append("five");
        return list;
    }


}
