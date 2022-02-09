package leetcode.editor.cn;

/**
 * 45 - jump-game-ii
 * 跳跃游戏 II
 *
 * @author lixin
 * @date 2022-02-03 16:51:59
 */
public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int length = nums.length;
            int end = 0;
            int maxPosition = 0;
            int steps = 0;
            for (int i = 0; i < length - 1; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if (i == end) {
                    end = maxPosition;
                    steps++;
                }
            }
            return steps;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}

