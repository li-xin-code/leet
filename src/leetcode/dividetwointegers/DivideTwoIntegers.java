package leetcode.dividetwointegers;

/**
 * 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。
 * 将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，
 * 例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * <p>
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，
 * 其数值范围是 [−2^31,  2^31 − 1]。
 * 本题中，如果除法结果溢出，则返回 2^31 − 1。
 *
 * @author ASUS
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        int dividend = 7, divisor = -3;
        Solution solution = new Solution();
        int res = solution.divide(dividend, divisor);
        System.out.println(res);
    }

}

class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            else if (divisor == 1) return Integer.MIN_VALUE;
        }
        long divd = dividend;
        long divs = divisor;
        int sign = 1;
        if (divd < 0) {
            divd = -divd;
            sign = -sign;
        }
        if (divs < 0) {
            divs = -divs;
            sign = -sign;
        }
        int res = 0;
        while (divd >= divs) {
            int shift = 0;
            while (divd >= divs << shift) shift++;
            res += (1 << (shift - 1));
            divd -= (divs << (shift - 1));
        }

        return sign * res;
    }
}