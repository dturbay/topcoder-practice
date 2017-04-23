package lc.p20170324;

import java.util.HashMap;
import java.util.Map;

/**
 Given a string, find the length of the longest substring without repeating characters.
 Examples:
 Given "abcabcbb", the answer is "abc", which the length is 3.
 Given "bbbbb", the answer is "b", with the length of 1.
 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 "pwke" is a subsequence and not a substring.
 */

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int startPos = 0;
        int counter = 0;
        int max = 0;
        int currentPos = 0;
        Map<Character, Integer> previousChars = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (!previousChars.containsKey(c) || previousChars.get(c) < startPos) {
                counter++;
                if (counter > max) {
                    max = counter;
                }
            } else {
                counter = currentPos - (previousChars.get(c) + 1) + 1;
                startPos = previousChars.get(c) + 1;
            }
            previousChars.put(c, currentPos);
            currentPos++;
        }
        return max;
    }

}

