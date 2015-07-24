package lc.p20150722;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a
 * space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.isEmpty()) {
            return wordDict.isEmpty();
        }
        boolean[] dp = new boolean[s.length()];
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            strBuilder.append(s.charAt(i));
            if (wordDict.contains(strBuilder.toString())) {
                dp[i] = true;
            } else {
                for (int k = 0; k < i; k++) {
                    if (dp[k] && wordDict.contains(s.substring(k + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
