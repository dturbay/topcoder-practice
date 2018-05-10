package lc.p201805;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);
 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:

 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 */

public class ZigZagConversion {
  public String convert(String s, int numRows) {
    String[] strings = new String[numRows];
    for (int i = 0 ; i < numRows ; i++) {
      strings[i] = new String();
    }
    int ind = 0;
    int direction = 1;
    for (char ch : s.toCharArray()) {
      strings[ind] += ch;
      if (numRows > 1) {
        if (ind == 0) {
          direction = 1;
        } else if (ind == numRows - 1) {
          direction = -1;
        }
        ind += direction;
      }
    }
    String result = "";
    for (int i = 0 ; i < numRows ; i++) {
      result += strings[i];
    }
    return result;
  }
}
