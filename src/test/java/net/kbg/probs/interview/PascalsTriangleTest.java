package net.kbg.probs.interview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PascalsTriangleTest {

    private PascalsTriangle triangle;

    @Before
    public void init() {
        triangle = new PascalsTriangle();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroArgument() {
        triangle.makePascalTriangle(0);
    }

    @Test
    public void testArgOne() {
        List<List<Integer>> rslt = triangle.makePascalTriangle(1);
        showTriangle(rslt);
        Assert.assertEquals(1, rslt.size());
    }

    @Test
    public void testArgTwo() {
        List<List<Integer>> rslt = triangle.makePascalTriangle(2);
        showTriangle(rslt);
        Assert.assertEquals(2, rslt.size());
    }

    @Test
    public void testArgThree() {
        List<List<Integer>> rslt = triangle.makePascalTriangle(3);
        showTriangle(rslt);
        Assert.assertEquals(3, rslt.size());
    }

    @Test
    public void testArgFour() {
        List<List<Integer>> rslt = triangle.makePascalTriangle(4);
        showTriangle(rslt);
        Assert.assertEquals(4, rslt.size());
    }

    @Test
    public void testArgFive() {
        List<List<Integer>> rslt = triangle.makePascalTriangle(5);
        showTriangle(rslt);
        Assert.assertEquals(5, rslt.size());
    }

    @Test
    public void testIteration() {
        for (int k = 1; k < 10; ++k) {
            List<List<Integer>> rslt = triangle.makePascalTriangle(k);
            showTriangle(rslt);
            spacer(3);
        }
    }

    public void showTriangle(List<List<Integer>> t) {
        for (List<Integer> row : t) {
            for (Integer val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public void spacer(int b) {
        for (int c = 0; c < b; ++c) {
            System.out.println();
        }
    }

}
