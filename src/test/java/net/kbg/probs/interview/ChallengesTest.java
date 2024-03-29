package net.kbg.probs.interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChallengesTest {

    Challenges challenges;

    @Before
    public void init() {
        challenges = new Challenges();
    }

    @Test
    public void reverseInPlaceTest() {
        String arg = "Blivit";
        String expected = "tivilB";
        String rslt = new String(challenges.reverseInPlace(arg.toCharArray()));
        assertEquals(expected, rslt);
    }

    @Test
    public void reverseTest() {
        String arg = "Blivit";
        String expected = "tivilB";
        String rslt = challenges.reverse(arg);
        assertEquals(expected, rslt);
    }

    @Test
    public void telegramProblemTest() {
        for (int w = 5; w < 26; ++w) {
            String line = "I once did a small thing and it was too small to be so good";
            String rslt = challenges.telegramProblem(w, line);
            assertTrue(rslt.length() <= w);
        }
    }
}
