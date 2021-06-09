package leetcode.countandsay;

/**
 * 外观数列
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，
 * 序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，
 * "2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；
 * 类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，
 * 也就是 "1211"。
 *
 * @author ASUS
 */
public class CountAndSay {

    public static void main(String[] args) {
        int n = 4;
        Solution solution = new Solution();
        String res = solution.countAndSay(n);
        System.out.println(res);
    }

}

class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String res = "1";
        for (int i = 1; i < n; i++) {
            int count = 0;
            char prev = '.';
            StringBuilder sb = new StringBuilder();
            for (int idx = 0; idx < res.length(); idx++) {
                if (res.charAt(idx) == prev || prev == '.') {
                    count++;
                } else {
                    sb.append(count).append(prev);
                    count = 1;
                }
                prev = res.charAt(idx);
            }
            sb.append(count).append(prev);
            res = sb.toString();
        }
        return res;
    }
}

class Solution2 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String res = "11";
        while (n > 2) {
            res = find(res);
            n--;
        }
        return res;
    }

    private String find(String s) {
        char[] chars = s.toCharArray();
        StringBuffer buffer = new StringBuffer();
        int count = 1;
        for (int i = 1; i <= s.length() - 1; i++) {
            if (chars[i - 1] == chars[i]) {
                count++;
            } else {
                buffer.append(count).append(chars[i - 1]);
                count = 1;
            }
        }
        if (count != 0) buffer.append(count).append(chars[chars.length - 1]);
        return buffer.toString();
    }
}