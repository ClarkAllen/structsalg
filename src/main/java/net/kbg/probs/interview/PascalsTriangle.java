package net.kbg.probs.interview;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Make the first N rows of Pascal's Triangle.
 */
public class PascalsTriangle {

    public List<List<Integer>> makePascalTriangle(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("N must be > 0");
        }
        List<List<Integer>> rslt = new ArrayList<>();
        for (int idx = 1; idx <= n; ++idx) {
            addRows(idx, rslt);
        }
        return rslt;
    }

    public List<List<Integer>> addRows(int n, List<List<Integer>> rslt) {
        if (n < 1) {
            return null;
        }
        if (n == 1) {
            rslt.add(Arrays.asList(1));
            return rslt;
        } else if (n == 2) {
            rslt.add(Arrays.asList(1,1));
            return rslt;
        }
        else if (n > 2) {
            List<Integer> prev = makeNewRow(rslt.get(rslt.size() - 1));
            if (prev != null) {
                rslt.add(prev);
            }
        }

        return rslt;
    }

    public List<Integer> makeNewRow(List<Integer> row) {
        List<Integer> nr = new ArrayList<>();   // nr = new row
        nr.add(1);
        int k = 0;
        while (k + 1 < row.size()) {
            nr.add(row.get(k) + row.get(k + 1));
            ++k;
        }
        nr.add(1);

        return nr;
    }
}
