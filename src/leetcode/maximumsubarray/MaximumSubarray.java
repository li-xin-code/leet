package leetcode.maximumsubarray;

/**
 * @author lx
 * @date 2021/4/17
 * 最大子序和
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：nums = [-100000]
 * 输出：-100000
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums0 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums1 = {1};
        int[] nums2 = {5, 4, -1, 7, 8};
        int[] nums3 = {-1000000};
        int[] nums4 = {-2, 1};

        Solution solution = new Solution();
        int subArray = solution.maxSubArray(nums4);
        System.out.println(subArray);
    }
}

class Solution {
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        if (nums.length == 1) return nums[0];

        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int tempSum = 0;
        int k = 0;

        while (k < len) {
            tempSum = tempSum + nums[k];
            max = Math.max(tempSum, max);
            if (tempSum < 0) {
                tempSum = 0;
            }
            k++;
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length <= 0)
            return 0;
        int sum = 0;
        int max = nums[0];
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                start = i;
                break;
            }
        }
        for (int i = start; i < nums.length; ) {
            sum = nums[i];
            max = Math.max(sum, max);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(sum, max);
            }
            for (int k = ++i; k < nums.length; k++) {
                if (nums[k] > 0) {
                    i = k;
                    break;
                }
            }
        }
        return max;
    }

}
