package leetcode.longestpalindromicsubstring;


/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author ASUS
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        Solution solution = new Solution();
        String res = solution.longestPalindrome(s);
        System.out.println(res);
    }

}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int len = s.length();
        char[] sChar = s.toCharArray();
        int start = 0;
        int length = 1;
        boolean[][] isPalindromic = new boolean[len][len];
        for (int i = 0; i < len; i++)
            isPalindromic[i][i] = true;
        for (int i = 0; i < len - 1; i++)
            if (sChar[i] == sChar[i + 1]) {
                isPalindromic[i][i + 1] = true;
                start = i;
                length = 2;
            }
        for (int i = 3; i <= len; i++)// i 是当前子串的长度
            for (int j = 0; j + i - 1 < len; j++)
                if (sChar[j] == sChar[j + i - 1] &&
                        isPalindromic[j + 1][j + i - 2]) {
                    isPalindromic[j][j + i - 1] = true;
                    start = j;
                    length = i;
                }
        return s.substring(start, start + length);
    }
}

class Solution2 {
    private int start = 0, end = 0, maxLen = 0;

    public String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() < 2) return s;
        find(s.toCharArray(), 0);
        return s.substring(start, end + 1);
    }

    private void find(char[] str, int idx) {
        int n = str.length;
        if (idx > n - 1 || (n - 1 - idx) * 2 + 1 < maxLen) return;

        int curStart = idx, curEnd = idx;

        while (curEnd + 1 < n && str[curEnd + 1] == str[idx]) curEnd++;
        idx = curEnd;

        while (curStart - 1 >= 0 && curEnd + 1 < n && str[curStart - 1] == str[curEnd + 1]) {
            curStart--;
            curEnd++;
        }

        if (curEnd - curStart > maxLen) {
            start = curStart;
            end = curEnd;
            maxLen = curEnd - curStart;
        }

        find(str, idx + 1);
    }
}