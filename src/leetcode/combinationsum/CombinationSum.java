package leetcode.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * @author ASUS
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println(res);

    }

}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null ||
                candidates.length == 0 ||
                target <= 0) return res;
        Arrays.sort(candidates);
        helper(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int target, int index,
                        List<List<Integer>> res, List<Integer> curSeq) {
        if (target == 0) {
            res.add(new ArrayList<>(curSeq));
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] > target) break;
                curSeq.add(candidates[i]);
                helper(candidates, target - candidates[i], i, res, curSeq);
                curSeq.remove(curSeq.size() - 1);
            }
        }
    }
}