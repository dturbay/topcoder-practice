package lc.p20150715;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that
 * output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does
 * not count as extra space for the purpose of space complexity analysis.)
 */
public class Product_of_array_except_self {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] leftProducts = new int[length];
        int[] rightProducts = new int[length];

        leftProducts[0] = nums[0];
        rightProducts[length - 1] = nums[length - 1];
        for (int i = 1; i < length; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i];
            rightProducts[length - i - 1] =
                    nums[length - i - 1] * rightProducts[length - i];
        }
        int[] results = new int[length];
        for (int i = 0; i < length; i++) {
            int left = i - 1 >= 0 ? leftProducts[i - 1] : 1;
            int right = i + 1 < length ? rightProducts[i + 1] : 1;
            results[i] = left * right;
        }
        return results;
    }
}
