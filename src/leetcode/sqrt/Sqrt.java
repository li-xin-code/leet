package leetcode.sqrt;

/**
 * @author lx
 * @date 2021/5/23
 * 实现int sqrt(int x)函数。
 * 计算并返回x的平方根，其中x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class Sqrt {
    public static void main(String[] args) {
        int x = 0;
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(x));
    }
}

class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (x / mid > mid) {
                left = mid + 1;
            } else if (x / mid == mid) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}