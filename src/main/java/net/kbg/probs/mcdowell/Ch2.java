package net.kbg.probs.mcdowell;

import net.kbg.probs.mcdowell.support.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Ch2 {

    public List<String> removeDuplicates(List<String> input) {
        if (input == null || input.size() < 1) {
            throw new IllegalArgumentException("The argument must have members");
        }
        List<String> uniques = new ArrayList<>(input.size());
        for (String item : input) {
            if ( ! uniques.contains(item) ) {
                uniques.add(item);
            }
        }
        return uniques;
    }

}
