package net.kbg.probs.mcdowell;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ch1 {

    /*
        implement an algorithm to determine if the characters
        in a string are all unique within the string.
     */
    public boolean isUnique(String arg) {
        if (arg == null || arg.length() < 1) {
            throw new IllegalArgumentException();
        }
        if (arg.length() == 1) {
            return true;
        }
        char[] chars = arg.toCharArray();
        Arrays.sort(chars);
        for (int b=0, k=1; k < chars.length; ++b, ++k) {
            if (chars[b] == chars[k]) {
                return false;
            }
        }
        return true;
    }

    /*
        Given two strings, determine if one is a permutation of the other.
     */
    public boolean isPermutation(String arg1, String arg2) {
        if (arg1 == null || arg2 == null) {
            throw new IllegalArgumentException();
        }
        if (arg1.length() != arg2.length()) {
            return false;
        }

        Map<String, Integer> cnt1 = new HashMap<>();
        mapChars(arg1, cnt1);
        Map<String, Integer> cnt2 = new HashMap<>();
        mapChars(arg2, cnt2);

        for (String s : cnt1.keySet()) {
            if ( ! cnt2.containsKey(s) ) {
                return false;
            }
            if ( ! cnt1.get(s).equals(cnt2.get(s))) {
                return false;
            }
        }

        return true;
    }

    private void mapChars(String str, Map<String, Integer> cntMap) {
        for (char c : str.toCharArray()) {
            count(c, cntMap);
        }
    }

    public void count(char arg, Map<String, Integer> tally) {
        String key = "" + arg;
        if ( ! tally.containsKey(key) ) {
            tally.put(key, 1);
        } else {
            tally.put(key, 1 + tally.get(key));
        }
    }

}
