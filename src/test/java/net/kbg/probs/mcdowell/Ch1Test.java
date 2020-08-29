package net.kbg.probs.mcdowell;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Ch1Test {

    @Test
    public void testIsUnique() {
        Ch1 ch1 = new Ch1();
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

        Ch1 ch1 = new Ch1();
        assertTrue(ch1.isPermutation(s1, s2));
        assertFalse(ch1.isPermutation(s1, s3));
        assertFalse(ch1.isPermutation(s1, s4));
    }
}
