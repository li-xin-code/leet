package leetcode.nextpermutation;

import java.util.Arrays;

/**
 * @author lixin
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // replace - 更换
        int replace = nums.length - 2;
        while (replace >= 0) {
            if (nums[replace] < nums[replace + 1]) {
                break;
            }
            replace--;
        }
        if (replace < 0) {
            Arrays.sort(nums);
            return;
        }
        int lgrIdx = replace + 1;
        while (lgrIdx < nums.length &&
                nums[lgrIdx] > nums[replace]) {
            lgrIdx++;
        }
        int tmp = nums[replace];
        nums[replace] = nums[lgrIdx - 1];
        nums[lgrIdx - 1] = tmp;
        Arrays.sort(nums, replace + 1, nums.length);
    }
}
