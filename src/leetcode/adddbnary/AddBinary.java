package leetcode.adddbnary;

/**
 * @author lx
 * @date 2021/5/2
 * <p>
 * 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字1和0。
 * <p>
 * 示例1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        Solution solution = new Solution();
        String result = solution.addBinary(a, b);
        System.out.println(result);
    }
}

class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int aLen = a.length();
        int bLen = b.length();
        int minLen = Math.min(aLen, bLen);
        char[] maxStr = (aLen > bLen ? a : b).toCharArray();
        StringBuilder result = new StringBuilder(aLen);
        boolean carryFlag = false;
        int digit;
        for (int i = 0; i < minLen; i++) {
            digit = (a.charAt(i) - 48) + (b.charAt(i) - 48) + (carryFlag ? 1 : 0);
            carryFlag = digit > 1;
            result.append(digit % 2);
        }
        for (int i = minLen; i < maxStr.length; i++) {
            digit = (maxStr[i] - 48) + (carryFlag ? 1 : 0);
            carryFlag = digit > 1;
            result.append(digit % 2);
        }
        if (carryFlag)
            result.append("1");
        return result.reverse().toString();
    }

    public String addBinaryPlus(String a, String b) {
        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();
        int aLength = arr.length;
        int bLength = brr.length;
        int tLength = Math.max(aLength, bLength) + 1;

        char[] targetChar = new char[tLength];
        boolean toAdd = false;
        for (int i = 0; i < tLength; i++) {
            int aV = aLength > i ? arr[aLength - 1 - i] : '0';
            int bV = bLength > i ? brr[bLength - 1 - i] : '0';

            int tv = aV - '0' + bV - '0' + (toAdd ? 1 : 0);
            toAdd = tv > 1;
            targetChar[tLength - 1 - i] = (char) ((tv % 2) + '0');
        }
        String target;
        if (targetChar[0] == '0') {
            target = new String(targetChar, 1, tLength - 1);
        } else {
            target = new String(targetChar);
        }
        return target;
    }

}
