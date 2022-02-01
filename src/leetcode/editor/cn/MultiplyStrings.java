package leetcode.editor.cn;

/**
 * 43 - multiply-strings
 * 字符串相乘
 *
 * @author lixin
 * @date 2022-02-01 18:04:41
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        String num1 = "123";
        String num2 = "456";
        System.out.println(solution.multiply(num1, num2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }

            int len1 = num1.length();
            int len2 = num2.length();
            int[] resultArr = new int[len1 + len2];
            char[] num1Arr = num1.toCharArray();
            char[] num2Arr = num2.toCharArray();

            for (int i = len1 - 1; i >= 0; i--) {
                int indexX = num1Arr[i] - '0';
                for (int j = len2 - 1; j >= 0; j--) {
                    int indexY = num2Arr[j] - '0';
                    resultArr[i + j + 1] += indexX * indexY;
                }
            }

            for (int i = len1 + len2 - 1; i > 0; i--) {
                resultArr[i - 1] += resultArr[i] / 10;
                resultArr[i] = resultArr[i] % 10;
            }

            int index = resultArr[0] == 0 ? 1 : 0;
            StringBuilder sb = new StringBuilder();
            while (index < len1 + len2) {
                sb.append(resultArr[index]);
                index++;
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

