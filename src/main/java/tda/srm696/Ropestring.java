package tda.srm696;

import java.util.*;

/**
 * Hero has a collection of ropes. You are given the s that contains an ASCII art depicting this
 * collection of ropes. Each character of s is either '-' (dash, ASCII 45) or '.' (period, ASCII 46).
 * Each dash is a rope segment, each period is an empty space. Each contiguous segment of dashes
 * represents one rope; the number of dashes is the length of the rope. For example, s = "..-..----."
 * means that Hero has two ropes: one of length 1 and one of length 4. Hero has decided to rearrange
 * his collection of ropes, using the following rules:
 Each rope that has an even length must be placed to the left of all ropes that have odd lengths.
 There must be at least one empty space between any two ropes.
 If there are multiple arrangements that satisfy the previous two rules, Hero will choose the one that
 corresponds to the lexicographically smallest string. (This is explained below.)
 Once Hero rearranges his ropes, we can encode their new placement into a new string that looks similar to s.
 (The string will have the same length as s and it will contain the same collection of ropes,
 but possibly in different places.) Given two strings of the same length, the lexicographically smaller
 one is the one that has a character with a smaller ASCII value on the first position on which they differ.
 For example, the string X = "---.-" is lexicographically smaller than the string Y = "-.---"
 because X[0] = Y[0] and X[1] < Y[1]. (Note that a dash has a smaller ASCII value than a period.)
 Construct the arrangement of ropes chosen by Hero and return the that encodes it.
 */
public class Ropestring {

  class Rope implements Comparable {
    int size;

    public Rope(int size) {
      this.size = size;
    }
    @Override
    public int compareTo(Object o) {
      Rope other = (Rope) o;
      if (size % 2 == other.size % 2) {
        if (size > other.size) {
          return -1;
        } else if (size == other.size) {
          return 0;
        } else {
          return 1;
        }
      } else {
        if (size % 2 == 0) {
          return -1;
        } else {
          return 1;
        }
      }
    }

    @Override
    public String toString() {
      StringBuilder result = new StringBuilder();
      for (int i = 0 ; i < size ; i++) {
        result.append('-');
      }
      return result.toString();
    }
  }

  public String makerope(String s) {
    int dotCount = 0;
    for (int i = 0 ; i < s.length() ; i++) {
      if (s.charAt(i) == '.') {
        dotCount++;
      }
    }

    String[] ropesStr = s.split("\\.");

    List<Rope> ropes = new ArrayList<>();
    for (String str: ropesStr) {
      if (!str.isEmpty()) {
        ropes.add(new Rope(str.length()));
      }
    }

    Collections.<Rope>sort(ropes);

    StringBuilder stringBuilder = new StringBuilder();
    for (Rope rope: ropes) {
      stringBuilder.append(rope.toString());
      if (dotCount > 0) {
        stringBuilder.append('.');
        dotCount--;
      }
    }
    while (dotCount > 0) {
      stringBuilder.append('.');
      dotCount--;
    }
    return stringBuilder.toString();
  }

}
