package leetcode.threesumclosest;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * @author ASUS
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        Solution solution = new Solution();
        int res = solution.threeSumClosest(nums, 1);
        System.out.println(res);
    }

}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return target;
        }
        Arrays.sort(nums);
        int delta = nums[0] + nums[1] + nums[2] - target;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int newdelta = nums[i] + nums[start] + nums[end] - target;
                if (newdelta == 0) {
                    return target;
                }

//				调用 Math类速度变慢
//				if (Math.abs(delta) > Math.abs(newdelta)) {
//					delta = newdelta;
//				}

                delta = delta * delta > newdelta * newdelta ? newdelta : delta;

                if (newdelta < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return target + delta;
    }
}
