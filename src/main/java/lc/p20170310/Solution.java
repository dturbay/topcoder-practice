package lc.p20170310;

import static lc.common.BinarySearch.lowBound;
import static lc.common.BinarySearch.upperBound;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int lo = 0;
        int hi = nums1.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int leftCount = mid;
            int rightCount = nums1.length - mid - 1;
            int leftCount2;
            int midVal = nums1[mid];
            if (nums2.length > 0 && nums2[0] < midVal) {
                leftCount2 = upperBound(nums2, 0, nums2.length - 1, x -> x >= midVal) + 1;
                //12345555567
            } else {
                leftCount2 = 0;
            }
            int rightCount2;
            if (nums2.length > 0 && midVal < nums2[nums2.length - 1]) {
                rightCount2 = nums2.length - lowBound(nums2, 0, nums2.length - 1, x -> x > midVal);
                //12345555567
            } else {
                rightCount2 = 0;
            }
            int totalLeft = leftCount + leftCount2;
            int totalRight = rightCount + rightCount2;
            int equalCount = nums2.length - leftCount2 - rightCount2;
            if (Math.abs(totalLeft - totalRight) <= equalCount) {
                return midVal;
            }
            if (Math.abs(Math.abs(totalLeft - totalRight) - equalCount) == 1) {
                if (totalLeft > totalRight) {
                    int lNumber = Integer.MIN_VALUE;
                    if (mid > 0) {
                        lNumber = nums1[mid - 1];
                    }
                    if (nums2.length > 0 && nums2[0] < midVal) {
                        int ind = upperBound(nums2, 0, nums2.length - 1, x -> x >= midVal);
                        lNumber = Math.max(lNumber, nums2[ind]);
                    }
                    return (midVal + lNumber) / 2.0;
                } else {
                    int rNumber = Integer.MAX_VALUE;
                    if (mid < nums1.length - 1) {
                        rNumber = nums1[mid + 1];
                    }
                    if (nums2.length > 0 && nums2[nums2.length - 1] >= midVal) {
                        int ind = lowBound(nums2, 0, nums2.length - 1, x -> x > midVal);
                        rNumber = Math.min(rNumber, nums2[ind]);
                    }
                    return (midVal + rNumber) / 2.0;
                }
            }
            if (totalLeft > totalRight) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return findMedianSortedArrays(nums2, nums1);
    }
}
