package lc.common;

import java.util.function.Predicate;

/**
 * Created by denysturbai on 3/12/17.
 */
public abstract class BinarySearch {

    // find first true
    public static int lowBound(int[] nums, int lo, int hi, Predicate<Integer> p) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (p.test(nums[mid]) == true) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (p.test(nums[lo]) == false) {
            // p(x) is false for all x in S!
            throw new IllegalArgumentException("p(x) is false for all x in S!");
        }
        return lo;         // lo is the least x for which p(x) is true
    }

    // find last false
    public static int upperBound(int[] nums, int lo, int hi, Predicate<Integer> p) {
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;    // truncate to higher number
            if (p.test(nums[mid]) == true) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        if (p.test(nums[lo]) == true) {
            throw new IllegalArgumentException("p(x) is true for all x in S!");
        }
        return lo;         // lo is the greatest x for which p(x) is false
    }
}
