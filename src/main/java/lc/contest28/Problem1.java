package lc.contest28;

/**
 * You are given a string representing an attendance record for a student. The record only contains the following
 * three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.
 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than
 two continuous 'L' (late).
 You need to return whether the student could be rewarded according to his attendance record.

 Example 1:
 Input: "PPALLP"
 Output: True

 Example 2:
 Input: "PPALLL"
 Output: False
 */
public class Problem1 {
    public boolean checkRecord(String s) {
        int aCount = 0;
        boolean twoLateInRow = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                aCount++;
            }
            if (i > 1 && s.charAt(i - 2) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i) == 'L') {
                twoLateInRow = true;
            }
            if (aCount > 1 || twoLateInRow) {
                return false;
            }
        }
        return true;
    }
}
