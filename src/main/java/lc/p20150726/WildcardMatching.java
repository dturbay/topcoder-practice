package lc.p20150726;

/**
 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false

 dp[i,j] =
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()][s.length()];
        for (int i = 0 ; i < dp.length ; i++) {
        }
        return false;
    }

}
