package leetcode.regularexpressionmatching;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * @author ASUS
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aab", p = "c*a*b";
        boolean res = isMatch(s, p);
        System.out.println(res);
    }

    /**
     * 动态规划
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                match[0][i] = match[0][i - 2];
            }
        }

        for (int si = 1; si <= s.length(); si++) {
            for (int pi = 1; pi <= p.length(); pi++) {
                if (p.charAt(pi - 1) == '.' ||
                        p.charAt(pi - 1) == s.charAt(si - 1)) {
                    match[si][pi] = match[si - 1][pi - 1];
                } else if (p.charAt(pi - 1) == '*') {
                    if (p.charAt(pi - 2) == s.charAt(si - 1) ||
                            p.charAt(pi - 2) == '.') {
                        match[si][pi] = match[si][pi - 2] || match[si - 1][pi];
                    } else {
                        match[si][pi] = match[si][pi - 2];
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
