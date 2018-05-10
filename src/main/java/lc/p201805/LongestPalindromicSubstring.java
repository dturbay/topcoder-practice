package lc.p201805;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    List<Palindrome> palindromes = new LinkedList<>();
    if (s.isEmpty()) {
      return "";
    }
    Palindrome max = new Palindrome(-1, -1, -1);
    for (int i = 0 ; i < s.length() ; i++) {
      char ch = s.charAt(i);
      Iterator<Palindrome> palindromeIterator = palindromes.iterator();
      while (palindromeIterator.hasNext()) {
        Palindrome p = palindromeIterator.next();
        if (p.start > 0 && s.charAt(p.start - 1) == ch) {
          p.start--;
          p.end++;
          p.length += 2;
        } else {
          if (p.length > max.length) {
            max = p;
          }
          palindromeIterator.remove();
        }
      }
      palindromes.add(new Palindrome(i, i, 1));
      if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
        palindromes.add(new Palindrome(i - 1, i, 2));
      }
    }
    for (Palindrome p : palindromes) {
      if (p.length > max.length) {
        max = p;
      }
    }
    return s.substring(max.start, max.end + 1);
  }
}

class Palindrome {
  int start;
  int end;
  int length;

  public Palindrome(int start, int end, int length) {
    this.start = start;
    this.end = end;
    this.length = length;
  }
}
