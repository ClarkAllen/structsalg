package net.kbg.probs.mcdowell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ch1Test {

    private Ch1 ch1;

    @Before
    public void init() {
        ch1 = new Ch1();
    }

    @Test
    public void testIsUnique() {
        assertFalse(ch1.isUnique("ghbadeafci"));
        assertFalse(ch1.isUnique("gg"));

        assertTrue(ch1.isUnique("zbfkljam"));
        assertTrue(ch1.isUnique("b"));
        assertTrue(ch1.isUnique("bk"));
        assertTrue(ch1.isUnique("kgb"));
    }

    @Test
    public void isPermutation() {
        String s1 = "madamimadam";
        String s2 = "madamimadam";  // same as 1
        String s3 = "madamimadaa";  // slightly different, same length
        String s4 = "blivit";  // different length.

        assertTrue(ch1.isPermutation(s1, s2));
        assertFalse(ch1.isPermutation(s1, s3));
        assertFalse(ch1.isPermutation(s1, s4));
    }

    @Test
    public void isPermutation2Test() {
        String s1 = "madamimadam";
        String s2 = "madamimadam";  // same as 1
        String s3 = "madamimadaa";  // slightly different, same length
        String s4 = "blivit";  // different length.

        assertTrue(ch1.isPermutation2(s1, s2));
        assertFalse(ch1.isPermutation2(s1, s3));
        assertFalse(ch1.isPermutation2(s1, s4));
    }

    @Test
    public void testURLify() {
        String before = "http://something/dirty string for mommy";
        String expected = "http://something/dirty%20string%20for%20mommy";
        String actual = ch1.URLify(before);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsPalindromePermutation() {
        String input = "Tact Coa"; // Odd length after cleaning
        assertTrue(ch1.isPalindromePermutation(input));

        input = "Tact Coa O";  // Even length after cleaning
        assertTrue(ch1.isPalindromePermutation(input));

        input = " G  ";  // Length = 1 after cleaning
        assertTrue(ch1.isPalindromePermutation(input));
    }

    @Test
    public void testIsOneAway() {
        String inp1 = "pale";
        String inp2 = "ple";
        assertTrue(ch1.isOneAway(inp1, inp2));

        inp1 = "pales";
        inp2 = "pale";
        assertTrue(ch1.isOneAway(inp1, inp2));

        inp1 = "pale";
        inp2 = "bale";
        assertTrue(ch1.isOneAway(inp1, inp2));

        inp1 = "pale";
        inp2 = "bake";
        assertFalse(ch1.isOneAway(inp1, inp2));
    }

    @Test
    public void testCompressString() {
        String input = "aabcccccaaa";
        String expected = "a2bc5a3";
        String actual = ch1.compressString(input);
        System.out.println(actual);
        assertEquals(expected, actual);

        input = "c";
        expected = "c";
        actual = ch1.compressString(input);
        System.out.println(actual);
        assertEquals(expected, actual);

        input = "cc";
        expected = "c2";
        actual = ch1.compressString(input);
        System.out.println(actual);
        assertEquals(expected, actual);

        input = "cbc";
        expected = "cbc";
        actual = ch1.compressString(input);
        System.out.println(actual);
        assertEquals(expected, actual);

        input = "abcde";
        expected = "abcde";
        actual = ch1.compressString(input);
        System.out.println(actual);
        assertEquals(expected, actual);

    }

    @Test
    public void testRotateMatrix() {
        int[][] mtx = {{1, 2}, {3, 4}};
        int[][] rslt = ch1.rotateMatrixByDupe(mtx);
        showMatrix(rslt);
        spacer(3);

        int[][] mtx3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [][] rslt3 = ch1.rotateMatrixByDupe(mtx3);
        showMatrix(rslt3);
    }

    public void showMatrix(int[][] mtx) {
        for (int x = 0; x < mtx.length; ++x) {
            for (int y = 0; y < mtx[x].length; ++y) {
                System.out.print(mtx[x][y] + "   ");
            }
            System.out.println();
        }
    }

    @Test
    public void testZeroMatrix() {
        int[][] mtx1 = {
                {11, 12, 13, 14, 15},
                {21, 0, 23, 24, 25},
                {31, 32, 33, 34, 35},
                {41, 42, 43, 0, 45},
                {51, 52, 53, 54, 55}
        };
        int[][] rslt1 = ch1.zeroMatrix(mtx1);
        showMatrix(rslt1);
    }

    @Test
    public void testStringRotation() {
        String arg1 = "waterbottle";
        String arg2 = "erbottlewat";
        boolean rslt = ch1.isStringRotation(arg1, arg2);
        Assert.assertTrue(rslt);

        String arg3 = "waterbuffalo";
        rslt = ch1.isStringRotation(arg3, arg2);
        Assert.assertFalse(rslt);
    }

    public void spacer(int rows) {
        for (int n = 0; n < rows; ++n) {
            System.out.println();
        }
    }

}
