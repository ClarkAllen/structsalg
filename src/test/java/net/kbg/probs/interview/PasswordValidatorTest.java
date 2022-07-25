package net.kbg.probs.interview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class PasswordValidatorTest {

    private PasswordValidator pv;

    @Before
    public void init() {
        pv = new PasswordValidator();
    }

    @Test
    public void testIsValidPassword_isTrue() {
        List<String> forbidden = new LinkedList<>();
        forbidden.add("GomerPile");
        forbidden.add("Blivit123!");
        //boolean rslt = pv.isValidPassword("MyGoodPass123!!", forbidden);
        boolean rslt = pv.isValidPasswordSimple("MyGoodPass123!!", forbidden);
        Assert.assertTrue(rslt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsValidPassword_NullPassArg() {
        List<String> forbidden = new LinkedList<>();
        forbidden.add("GomerPile");
        forbidden.add("Blivit123!");
        pv.isValidPassword(null,forbidden);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsValidPassword_NullListArg() {
        List<String> forbidden = null;
        pv.isValidPassword("SomeThing1!!", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsValidPassword_EmptyListArg() {
        List<String> forbidden = new LinkedList<>();
        pv.isValidPassword("SomeThing1!!", forbidden);
    }

    @Test
    public void testIsValidPassword_short() {
        List<String> forbidden = new LinkedList<>();
        forbidden.add("GomerPile");
        forbidden.add("Blivit123!");
        //boolean rslt = pv.isValidPassword("MyGoodPass123!!", forbidden);
        boolean rslt = pv.isValidPasswordSimple("My1!", forbidden);
        Assert.assertFalse(rslt);
    }

    @Test
    public void testIsValidPassword_NoUpcase() {
        List<String> forbidden = new LinkedList<>();
        forbidden.add("GomerPile");
        forbidden.add("Blivit123!");
        //boolean rslt = pv.isValidPassword("mybadpass123!!", forbidden);
        boolean rslt = pv.isValidPasswordSimple("mybadpass123!!", forbidden);
        Assert.assertFalse(rslt);
    }

    @Test
    public void testIsValidPassword_NoLowcase() {
        List<String> forbidden = new LinkedList<>();
        forbidden.add("GomerPile");
        forbidden.add("Blivit123!");
        //boolean rslt = pv.isValidPassword("mybadpass123!!", forbidden);
        boolean rslt = pv.isValidPasswordSimple("MYBADPASS123!!", forbidden);
        Assert.assertFalse(rslt);
    }

    @Test
    public void testIsValidPassword_NoNumbers() {
        List<String> forbidden = new LinkedList<>();
        forbidden.add("GomerPile");
        forbidden.add("Blivit123!");
        //boolean rslt = pv.isValidPassword("mybadpass123!!", forbidden);
        boolean rslt = pv.isValidPasswordSimple("SomeThing?", forbidden);
        Assert.assertFalse(rslt);
    }

    @Test
    public void testIsValidPassword_NoSymbols() {
        List<String> forbidden = new LinkedList<>();
        forbidden.add("GomerPile");
        forbidden.add("Blivit123!");
        //boolean rslt = pv.isValidPassword("mybadpass123!!", forbidden);
        boolean rslt = pv.isValidPasswordSimple("SomeThing123", forbidden);
        Assert.assertFalse(rslt);
    }
}
