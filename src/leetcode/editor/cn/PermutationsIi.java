package leetcode.editor.cn;

import java.util.*;

/**
 * 47 - permutations-ii
 * 全排列 II
 *
 * @author lixin
 * @date 2022-07-09 13:01:12
 */
public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] nums = {2, 2, 1, 1};
        System.out.println(solution.permuteUnique(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            List<List<Integer>> result = new ArrayList<>();
            helper(result, list, nums.length, 0);
            return result;
        }

        private void helper(List<List<Integer>> result, List<Integer> list, int len, int index) {
            if (len == index) {
                result.add(new ArrayList<>(list));
                return;
            }
            List<Integer> set = new ArrayList<>();
            for (int i = index; i < len; i++) {
                if (set.contains(list.get(i))) {
                    continue;
                }
                set.add(list.get(i));
                Collections.swap(list, index, i);
                helper(result, list, len, index + 1);
                Collections.swap(list, index, i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

