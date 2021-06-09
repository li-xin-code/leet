package leetcode.reverseinteger;

/**
 * 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，
 * 则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author ASUS
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int x = -120;
        int res = reverse(x);
        System.out.println(res);
    }

    public static int reverse(int x) {
        int rev = 0; //reverse
        while (x != 0) {
            int newrev = rev * 10 + x % 10;
            if ((newrev - x % 10) / 10 != rev) {
                return 0;
            }
            rev = newrev;
            x /= 10;
        }
        return rev;
    }

}
