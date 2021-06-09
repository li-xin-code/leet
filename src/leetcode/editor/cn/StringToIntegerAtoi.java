package leetcode.editor.cn;
 
 /**
 * 8 - string-to-integer-atoi
 * 字符串转换整数 (atoi)
 *
 * @author  lixin
 * @date 2022-01-27 14:42:40
 */
public class StringToIntegerAtoi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("  -42"));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int myAtoi(String s) {
        char[] chars = s.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int start = 0;
        if (chars[0] == '+' || chars[0] == '-') {
            start = 1;
        }
        boolean sign = true;
        if (start == 1) {
            sign = chars[0] != '-';
        }
        int cursor = start;
        for (; cursor < chars.length &&
                chars[cursor] > 47 &&
                chars[cursor] < 58
                ; cursor++) {
            if (chars[cursor] == '0' && cursor == start) {
                start++;
            }
        }
        int end = cursor;
        if (start >= end) {
            return 0;
        }
        if (end - start > 10) {
            if (sign) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        int result = chars[start] - 48;
        if (!sign) {
            result = -result;
        }
        for (int i = start + 1; i < end; i++) {
            int t = result * 10 + ((chars[i] - 48) * (sign ? 1 : -1));
            if (t/10 == result) {
                result = t;
            } else {
                if (sign) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

