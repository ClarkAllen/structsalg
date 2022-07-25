package net.kbg.probs.interview;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Challenges {

    /*
        Write a program that takes a number w, then accepts lines of text and outputs
        lines of text, where the output lines have as many words as possible but are
        never longer than w characters. Words may not be split, but you may assume
        that no single word is too long for a line.
     */
    public String telegramProblem(int w, String line) {
        if (w < 1 || line == null) {
            throw new IllegalArgumentException();
        }
        List<String> words = new LinkedList();
        words.addAll(List.of(line.split(" ")));
        Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        Collections.sort(words, comparator);
        words.stream().filter(a -> a.length() <= w).collect(Collectors.toList());
        String rslt = "";
        for (String word : words) {
            if (rslt.length() < 1 && word.length() <= w) {
                rslt += word;
            }
            else if (rslt.length() + word.length() + 1 <= w) {
                rslt += " " + word;
            }
        }
        System.out.println("'" + rslt + "'" + "   has length " + rslt.length());
        return rslt;
    }

    public String reverse(String arg) {
        if (arg == null) {
            throw new IllegalArgumentException();
        }
        char ca[] = arg.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int k = ca.length - 1; k > -1; --k) {
            sb.append(ca[k]);
        }
        String rslt = sb.toString();
        return rslt;
    }

    public char[] reverseInPlace(char[] arg) {
        if (arg.length == 0) {
            return arg;
        }
        int start = 0;
        int end = arg.length - 1;
        while (start < end) {
            char buf = arg[start];
            arg[start] = arg[end];
            arg[end] = buf;
            ++start;
            --end;
        }
        return arg;
    }

    /*
        The challenge is to rewrite a loop as a lambda.
     */
    public void rewriteLoopAsLambda() {
        List<String> names = Arrays.asList("Bob", "Fred", "Barney", "Philboyd", "Poindexter");

        System.out.println("\nLoop output : ");

        for (String s : names) {
            System.out.println(s);
        }

        System.out.println("\nList.forEach output");

        names.forEach(System.out::println);

        System.out.println("\nList.stream().forEach output");

        names.stream().forEach(n -> System.out.println(n));
    }

    public boolean detectDoubleWords(String arg) {
        Set<String> words = new HashSet<>();
        boolean doubledWords = false;
        words.addAll(Arrays.asList(arg.split("\\s+")));
        for (String word : words) {
            Matcher m = Pattern.compile(word + "\\s+" + word).matcher(arg);
            boolean rslt = m.find();
            if (rslt) {
                doubledWords = true;
                System.out.println("doubled word : " + word);
            }
        }
        return doubledWords;
    }

}
