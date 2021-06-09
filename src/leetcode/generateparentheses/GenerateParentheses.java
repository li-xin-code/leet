package leetcode.generateparentheses;

import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，
 * 用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author ASUS
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> res = solution.generateParenthesis(n);
        System.out.println(res);
    }

}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper("", res, n, 0, 0);
        return res;
    }

    public void helper(String curr, List<String> res,
                       int n, int left, int right) {
        if (right == n) {
            res.add(curr);
            return;
        }
        if (left < n) {
            helper(curr + "(", res, n, left + 1, right);
        }
        if (right < left) {
            helper(curr + ")", res, n, left, right + 1);
        }
    }
}
