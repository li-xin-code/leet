package leetcode.combinationsumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * <p>
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例  2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * @author ASUS
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println(res);
    }

}

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> currList = new ArrayList<Integer>();
        if (candidates == null) return res;
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, 0, currList, res);
        return res;
    }

    private void combinationSum2Helper(int[] candidates, int target, int index, List<Integer> currList, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(currList));
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (i != index && candidates[i] == candidates[i - 1]) continue;
                currList.add(candidates[i]);
                combinationSum2Helper(candidates, target - candidates[i], i + 1, currList, res);
                currList.remove(currList.size() - 1);
            }
        }
    }
}

class Solution2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(candidates, used, new ArrayList<Integer>(), 0, target);
        return res;
    }

    private void dfs(int[] candidates, boolean[] used, ArrayList<Integer> path, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) continue;

            if (used[i]) {
                continue;
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            target = target - candidates[i];
            used[i] = true;

            dfs(candidates, used, path, i + 1, target);

            path.remove(path.size() - 1);
            target = target + candidates[i];
            used[i] = false;
        }
    }
}
