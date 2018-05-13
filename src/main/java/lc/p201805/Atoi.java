package lc.p201805;

import java.math.BigInteger;
import java.util.EnumSet;

/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 */

public class Atoi {

  public int myAtoi(String str) {
    // skip whitespaces
    String number = "";
    int i = 0;
    while (i < str.length()) {
      if (str.charAt(i) != ' ') {
        break;
      }
      i++;
    }
    // read sign
    if (i < str.length()) {
      char ch = str.charAt(i);
      if (ch == '+') {
        i++;
      } else if (ch == '-') {
        number = "-";
        i++;
      }
    }

    // read number
    while (i < str.length()) {
      char ch = str.charAt(i);
      if (Character.isDigit(ch)) {
        number += ch;
        i++;
      } else {
        break;
      }
    }

    if (number.isEmpty() || number.equals("-")) {
      return 0;
    }

    BigInteger bigInteger = new BigInteger(number);
    if (bigInteger.compareTo(new BigInteger(Integer.toString(Integer.MIN_VALUE))) < 0) {
      return Integer.MIN_VALUE;
    }
    if (bigInteger.compareTo(new BigInteger(Integer.toString(Integer.MAX_VALUE))) > 0) {
      return Integer.MAX_VALUE;
    }
    return Integer.valueOf(number);
  }
}
