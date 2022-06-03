package net.kbg.probs.mcdowell;

import java.util.*;

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

    /*
        Another solution to the question of two string being permutations of each other.
        This one seems smarter.
        * Make each string an array of characters
        * Sort the arrays
        * Compare the sorted character arrays for equality.
     */
    public boolean isPermutation2(String arg1, String arg2) {
        char[] ca1 = arg1.toCharArray();
        Arrays.sort(ca1);
        char[] ca2 = arg2.toCharArray();
        Arrays.sort(ca2);
        String str1 = new String(ca1);
        String str2 = new String(ca2);
        return str1.equals(str2);
    }

    /*
        Replace all the space characters in a string with '%20'.
     */
    public String URLify(String url) {
        return url.replaceAll("\\ ", "%20");
    }

    /*
        Determine if a string is the permutation of a palindrome.
        Ignore case and non-letter characters.
     */
    public boolean isPalindromePermutation(String arg) {
        if (arg == null) {
            throw new IllegalArgumentException();
        }
        String trim = arg.replaceAll("[-., :;!?()#%@$&*/]", "");
        trim = trim.toLowerCase();

        if (trim.length() < 1) {
            throw new IllegalArgumentException();
        }

        if (trim.length() == 1) {
            return true;
        }

        Map<String, Integer> charCount = new HashMap<>();
        mapChars(trim, charCount);

        int oddCount = 0;

        if (trim.length() % 2 == 1) {
            // the string has an odd length
            for (String key : charCount.keySet()) {
                if (charCount.get(key) % 2 == 1) {
                    ++oddCount;
                }
            }
            if (oddCount == 1) {
                return true;
            }
            return false;
        }

        // The string has an even length
        for (String key : charCount.keySet()) {
            if (charCount.get(key) % 2 == 1) {
                ++oddCount;
            }
        }

        if (oddCount % 2 == 0) {
            return true;
        }
        return false;
    }

    /*
        Given two strings, determine if they are one edit or zero
        edits from being the same where these edits are allowed
        (that is, if they are more than one edit different or
        less than two edits different) :
            1. insert a character
            2. remove a character
            3. replace a character
     */
    public boolean isOneAway(String arg1, String arg2) {
        if (arg1 == null || arg1.isEmpty() || arg2 == null || arg2.isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<Character> ls1 = convertToList(arg1.toCharArray());
        List<Character> ls2 = convertToList(arg2.toCharArray());
        int diffs = Math.abs(ls1.size() - ls2.size());

        if (diffs > 1) {
            return false;
        }
        if (diffs == 1) {
            // then check insert or remove
            if (ls1.size() > ls2.size()) {
                for (int g = 0; g < ls2.size(); ++g) {
                    if ( ! ls1.get(g).equals(ls2.get(g)) &&
                        ! ls1.get(g + 1).equals(ls2.get(g))) {
                        ++diffs;
                        break;
                    }
                }
            }
        } else {
            // diffs == 0
            // then check for replace
            for (int g = 0; g < ls1.size(); ++g) {
                if (ls1.get(g) != ls2.get(g)) {
                    ++diffs;
                }
                if (diffs > 1) {
                    break;
                }
            }
        }
        return diffs < 2;
    }

    private List<Character> convertToList(char[] chars) {
        List<Character> clist = new ArrayList<>(100);
        for (char c : chars) {
            clist.add(c);
        }
        return clist;
    }

    public String compressString(String arg) {
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (arg.length() == 1) {
            return arg;
        }

        List<Character> chars = convertToList(arg.toCharArray());
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        String prev = null;

        for (int k = 0; k < chars.size(); ++k) {
            String c = chars.get(k).toString();
            if (k == 0) {
                ++cnt;
                prev = c;
            } else if (k == chars.size() - 1) {
                if (c.equals(prev)) {
                    ++cnt;
                    sb.append(c).append(cnt);
                } else {
                    sb.append(prev);
                    if (cnt > 1) {
                        sb.append(cnt);
                    }
                    sb.append(c);
                }
            }
            else if (c.equals(prev)) {
                ++cnt;
            } else {
                sb.append(prev);
                if (cnt > 1) {
                    sb.append(cnt);
                }
                cnt = 1;
                prev = c;
            }

        }
        return sb.toString();
    }

    /*
        Rotate an NxN matrix 90 degrees.
            1  2                 1  3
            3  4                 2  4

            1  2  3              1  4  7
            4  5  6              2  5  8
            7  8  9              3  6  9

        This solution does not do swapping in-place.
        In-place swapping hurts my brain right now.
     */
    public int[][] rotateMatrixByDupe(int[][] mtx) {
        int rowsize = mtx.length;
        int colsize = mtx[0].length;
        System.out.println("the argument is a " + rowsize + "x" + colsize + " matrix");
        int[][] trans = new int[rowsize][colsize];

        for (int x = 0; x < rowsize; ++x) {
            for (int y = 0; y < colsize; ++y) {
                trans[y][x] = mtx[x][y];
            }
        }
        return trans;  // for now
    }

    /*
        Zero Matrix
        Write an algorithm such that if an element in an MxN matrix is zero,
        then the entire row and the entire column of that element is set to zero.
     */
    public int[][] zeroMatrix(int[][] mtx) {
        int rowsize = mtx.length;
        int colsize = mtx[0].length;
        System.out.println("the argument is a " + rowsize + "x" + colsize + " matrix");
        Set<Integer> rowsSetToZero = new HashSet<>();
        Set<Integer> colsSetToZero = new HashSet<>();

        // Find rows and columns with zeros in them.
        for (int x = 0; x < rowsize; ++x) {
            for (int y = 0; y < colsize; ++y) {
                if (mtx[x][y] == 0) {
                    if ( ! rowsSetToZero.contains(x)) {
                        rowsSetToZero.add(x);
                    }
                    if ( ! colsSetToZero.contains(y)) {
                        colsSetToZero.add(y);
                    }
                }
            }
        }

        // Set rows to zero where needed.
        for (int row : rowsSetToZero) {
            for (int y = 0; y < colsize; ++y) {
                mtx[row][y] = 0;
            }
        }

        // Set columns to zero where needed.
        for (int col : colsSetToZero) {
            for (int x = 0; x < colsize; ++x) {
                mtx[x][col] = 0;
            }
        }

        return mtx;
    }

    /*
        String Rotation
        Assume you have a method called isSubstring(s1, s2) that checks if one string
        is a substring of another.
        Using only one call to isSubstring(), determine if one string is a rotation
        of the other.
        Example : waterbottle can be rotated as  erbottlewat

        My strategy... double string2 and check with isSubstring() :
            isSubstring("waterbottle", "erbottlewaterbottlewat")
     */
    public boolean isStringRotation(String arg1, String arg2) {
        String doubled = arg2 + arg2;
        return doubled.contains(arg1);
    }
}
