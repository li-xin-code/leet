package leetcode.implementstrstr;

/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * @author ASUS
 */
public class ImplementstrStr {

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        Solution solution = new Solution();
        int res = solution.strStr(haystack, needle);
        System.out.println(res);
    }

}

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}