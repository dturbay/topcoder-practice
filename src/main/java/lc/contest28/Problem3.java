package lc.contest28;

import java.util.Collections;

/**
 * Given a list of strings, you could assemble these strings together into a loop.
 * Among all the possible loops, you need to find the lexicographically biggest string
 * after cutting and making one breakpoint of the loop, which will make a looped string into a regular one.

 So, to find the lexicographically biggest string, you need to experience two phases:

 Assemble all the strings into a loop, where you can reverse some strings or not and connect them in
 the same order as given.
 Cut and make one breakpoint in any place of the loop, which will make a looped string into a regular
 string starting from the character at the cutting point.
 And your job is to find the lexicographically biggest one among all the regular strings.

 Example:
 Input: "abc", "xyz"
 Output: "zyxcba"
 Explanation: You can get the looped string "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-",
 where '-' represents the looped status.
 The answer string came from the third looped one,
 where you could cut from the middle and get "zyxcba".
 Note:
 The input strings will only contain lowercase letters.
 The total length of all the strings will not over 1000.
 */
public class Problem3 {
    public String splitLoopedString(String[] strs) {
        StringBuilder builder = new StringBuilder();
        for (String str: strs) {
            String tmp = new StringBuilder(str).reverse().toString();
            if (str.compareTo(tmp) > 0 ) {
                builder.append(str);
            } else {
                builder.append(tmp);
            }
        }
        String concatenated = builder.toString();
        int max = findMaxInd(concatenated);
        String result = concatenated.substring(max) + concatenated.substring(0, max);
        return result;
    }

    int findMaxInd(String str) {
        char max = Character.MIN_VALUE;
        int ind = -1;
        int counter = 0;
        for (char ch: str.toCharArray()) {
            if (ch > max) {
                max = ch;
                ind = counter;
            }
            counter++;
        }
        return counter;
    }
}
