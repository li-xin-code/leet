package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46 - permutations
 * 全排列
 *
 * @author lixin
 * @date 2022-07-03 23:07:25
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = {0, 1, 2};
        System.out.println(solution.permute(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> output = new ArrayList<>();
            for (int num : nums) {
                output.add(num);
            }
            int n = nums.length;
            backtrack(n, output, res, 0);
            return res;
        }

        public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
            // 所有数都填完了
            if (first == n) {
                res.add(new ArrayList<>(output));
            }
            for (int i = first; i < n; i++) {
                // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first + 1);
                // 撤销操作
                Collections.swap(output, first, i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

