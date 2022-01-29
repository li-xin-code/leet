package leetcode.editor.cn;

/**
 * 41 - first-missing-positive
 * 缺失的第一个正数
 *
 * @author lixin
 * @date 2022-01-29 16:32:07
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();

        int[] nums = {1,1};
        System.out.println(solution.firstMissingPositive(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; ) {
                if (nums[i] > 0 && nums[i] <= nums.length) {
                    int t = nums[i];
                    if (t == i + 1 || t == nums[t - 1]){
                        i++;
                        continue;
                    }
                    nums[i] = nums[t - 1];
                    nums[t - 1] = t;
                } else {
                    i++;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }

            return nums.length + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

