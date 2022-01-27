package leetcode.editor.cn;

/**
 * 12 - integer-to-roman
 * 整数转罗马数字
 *
 * @author lixin
 * @date 2022-01-27 14:56:14
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(500));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public String intToRoman(int num) {
            String[] roman = {"I", "V", "X", "L", "C", "D", "M"};
            int[] digits = new int[4];
            int cursor = 0;
            while (num > 0) {
                digits[cursor] = num % 10;
                num = num / 10;
                cursor++;
            }
            StringBuilder result = new StringBuilder();
            for (int i = digits.length - 1; i >= 0; i--) {
                int digit = digits[i];
                if (digit == 0) {
                    continue;
                }
                if (digit == 9) {
                    result.append(roman[(i + 1) * 2 - 2]);
                    result.append(roman[(i + 1) * 2]);
                    digit -= 9;
                } else if (digit >= 5) {
                    result.append(roman[(i + 1) * 2 - 1]);
                    digit -= 5;
                } else if (digit == 4) {
                    result.append(roman[(i + 1) * 2 - 2]);
                    result.append(roman[(i + 1) * 2 - 1]);
                    digit -= 4;
                }
                while (digit > 0) {
                    result.append(roman[(i + 1) * 2 - 2]);
                    digit -= 1;
                }

            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

