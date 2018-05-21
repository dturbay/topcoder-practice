package lc.p201805;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

 Example:

 Input: n = 10
 Output: 12
 Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 Note:

 1 is typically treated as an ugly number.
 n does not exceed 1690.
 */
public class UglyNumber2 {
  public int nthUglyNumber(int n) {
    List<Integer> numbers = new ArrayList<>(n);
    Integer lastFound = 1;
    numbers.add(lastFound);
    for (int i = 1 ; i < n ; i++) {
      int candidate = 2 * findMinGreaterThan(numbers,(lastFound + 1) / 2.0);
      candidate = Math.min(candidate, 3 * findMinGreaterThan(numbers, (lastFound + 1) / 3.0));
      candidate = Math.min(candidate, 5 * findMinGreaterThan(numbers, (lastFound + 1) / 5.0));
      lastFound = candidate;
      numbers.add(lastFound);
    }
    return numbers.get(numbers.size() - 1);
  }

  private int findMinGreaterThan(List<Integer> numbers, double n) {
    int leftIndex = 0;
    int rightIndex = numbers.size() - 1;
    if (numbers.get(leftIndex) == n) {
      return numbers.get(leftIndex);
    }
    while (rightIndex - leftIndex > 1) {
      int middle = (rightIndex + leftIndex) / 2;
      if (numbers.get(middle) < n) {
        leftIndex = middle;
      } else {
        rightIndex = middle;
      }
    }
    return numbers.get(rightIndex);
  }

}


