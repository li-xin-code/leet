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
            int result = 0;
            for (int i = 1; i < height.length - 1; i++) {
                int t = Math.max(Math.min(height[i - 1], height[i + 1]) - height[i], 0);
                height[i] = t;
                result+= t;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}

