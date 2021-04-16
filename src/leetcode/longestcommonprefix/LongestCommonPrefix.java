package leetcode.longestcommonprefix;

/**
 * @author lx
 * @date 2021/4/16
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i]
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        // {"flower", "flow", "flight"}
        String[] strs = {"a","a"};
        Solution solution = new Solution();
        String result = solution.longestCommonPrefix(strs);
        System.out.println(result);
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String min = strs[0];
        for (String str : strs) {
            if (str.length() < min.length()) {
                min = str;
            }
        }
        return findMinStr(min, strs);
    }

    private String findMinStr(String min, String[] strs) {
        if (min.equals("")) {
            return "";
        }
        for (String str : strs) {
            if (!str.startsWith(min)) {
                return findMinStr(min.substring(0, min.length() - 1), strs);
            }
        }
        return min;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        int index = helper(strs, 0, 0, strs[0].charAt(0));
        return index > 0 ? strs[0].substring(0,index) : "";
    }

    private int helper(String[] strs, int sIndex, int cIndex, char c) {
        if (sIndex >= strs.length) {
            ++cIndex;
            if (strs[0].length() <= cIndex)
                return cIndex;
            return helper(strs, 0, cIndex, strs[0].charAt(cIndex));
        }
        if (strs[sIndex].length() <= cIndex)
            return cIndex;
        if (strs[sIndex].charAt(cIndex) == c)
            return helper(strs, sIndex+1, cIndex, c);
        return cIndex;
    }
}