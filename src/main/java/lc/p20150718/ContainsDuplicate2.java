package lc.p20150718;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there there are two distinct
 * indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer index = indexByValue.get(num);
            if (index != null) {
                if (i - index <= k) {
                    return true;
                }
            }
            indexByValue.put(num, i);
        }
        return false;
    }
}
