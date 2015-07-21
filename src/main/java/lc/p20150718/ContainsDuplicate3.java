package lc.p20150718;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the difference between nums[i] and nums[j] is at most t and the difference between i
 * and j is at most k.
 */
public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Queue<Integer> queue = new LinkedList<>();
        TreeSet<Integer> values = new TreeSet<>();
        int firstIndexInQueue = 0;
        if (t < 0 || k < 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            queue.add(num);
            if (i - firstIndexInQueue > k) {
                values.remove(queue.remove());
                firstIndexInQueue++;
            }
            if (!values.add(num)) {
                return true;
            }
            if (checkDistance(t, num, values.higher(num))) {
                return true;
            }
            if (checkDistance(t, num, values.lower(num))) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDistance(int t, int num, Integer nearest) {
        if (nearest != null && (Math.abs((long)nearest - (long)num) <= t)) {
            return true;
        }
        return false;
    }
}
