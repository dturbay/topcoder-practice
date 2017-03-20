package lc.p20170319;

import java.util.ArrayList;
import java.util.List;

/**
 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
    public boolean isMatch(String input, String p) {
        List<RXSymbol> pattern = parsePattern(p);
        int rows = pattern.size() + 1;
        int columns = input.length() + 1;
        boolean[][] solutions = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                solutions[i][j] = false;
            }
        }
        solutions[0][0] = true;
        for (int i = 1; i < rows; i++) {
            int j = findNext(solutions, i, 1);
            RXSymbol symbol = pattern.get(i - 1);
            if (symbol.repeat) {
                solutions[i][j - 1] = solutions[i - 1][j - 1];
            }
            while (j < columns) {
                if (symbol.repeat) {
                    solutions[i][j - 1] = true;
                    while (j < columns) {
                        if (symbol.symbol == '.' || symbol.symbol == input.charAt(j - 1)) {
                            solutions[i][j] = true;
                        } else {
                            j++;
                            break;
                        }
                        j++;
                    }
                } else if (symbol.symbol == '.' || symbol.symbol == input.charAt(j - 1)) {
                        solutions[i][j] = true;
                        j++;
                } else {
                    solutions[i][j] = false;
                    j++;
                }
                j = findNext(solutions, i, j);
            }
            if (symbol.repeat && solutions[i - 1][j - 1]) {
                solutions[i][j-1] = true;
            }
        }
        return solutions[rows - 1][columns - 1];
    }

    private int findNext(boolean[][] solutions, int i, int j) {
        int k = j;
        for (; k < solutions[i].length; k++) {
            if (solutions[i - 1][k - 1]) {
                break;
            }
        }
        return k;
    }

    private List<RXSymbol> parsePattern(String p) {
        List<RXSymbol> result = new ArrayList<>();
        for (char c: p.toCharArray()) {
            if (c == '*') {
                RXSymbol rxSymbol = result.get(result.size() - 1);
                rxSymbol.repeat = true;
            } else {
                result.add(new RXSymbol(c, false));
            }
        }
        return result;
    }

    static class RXSymbol {
        char symbol;
        boolean repeat;

        public RXSymbol(char symbol, boolean repeat) {
            this.symbol = symbol;
            this.repeat = repeat;
        }
    }
}
