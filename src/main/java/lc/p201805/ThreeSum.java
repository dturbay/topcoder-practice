package lc.p201805;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    Map<Integer, List<Pair>> summByPairs = new HashMap<>();
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int summ = nums[i] + nums[j];
        List<Pair> pairList = summByPairs.getOrDefault(summ, new ArrayList<>());
        pairList.add(new Pair(i, j));
        summByPairs.put(summ, pairList);
      }
    }
    Set<Set<Integer>> result = new HashSet<>();
    for (int i = 0 ; i < nums.length ; i++) {
      if (summByPairs.containsKey(-nums[i])) {
        List<Pair> pairs = summByPairs.get(-nums[i]);
        for (Pair p : pairs) {
          if (i != p.ind1 && i != p.ind2) {
            result.add(new HashSet<>(Arrays.asList(i, p.ind1, p.ind2)));
          }
        }
      }
    }
    return result.stream().map(
            s -> s.stream().map(ind -> nums[ind]).sorted().collect(Collectors.toList()))
        .distinct()
        .collect(Collectors.toList());
  }
}

class Pair {
  int ind1;
  int ind2;

  public Pair(int ind1, int ind2) {
    this.ind1 = ind1;
    this.ind2 = ind2;
  }
}
