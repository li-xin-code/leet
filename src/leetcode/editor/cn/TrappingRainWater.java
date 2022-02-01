package leetcode.editor.cn;

/**
 * 42 - trapping-rain-water
 * 接雨水
 *
 * @author lixin
 * @date 2022-01-31 17:18:17
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
//        [0,1,0,2,1,0,1,3,2,1,2,1]
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (height[left] < height[right]) {
                    ans += leftMax - height[left];
                    ++left;
                } else {
                    ans += rightMax - height[right];
                    --right;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}

