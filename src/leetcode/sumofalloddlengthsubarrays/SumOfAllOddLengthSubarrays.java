package leetcode.sumofalloddlengthsubarrays;

/**
 * 所有奇数长度子数组的和
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr中 所有奇数长度子数组的和。
 * <p>
 * 示例 1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * <p>
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * <p>
 * 示例 3：
 * 输入：arr = [10,11,12]
 * 输出：66
 * <p>
 * 提示：
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 *
 * @author lx
 * @date 2021/5/10
 */
public class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        Solution solution = new Solution();
        System.out.println(solution.sumOddLengthSubarrays(arr));
    }
}

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int subSum = 0;
            for (int j = i; j < arr.length; j++) {
                subSum += arr[j];
                if ((j - i + 1) % 2 == 1)
                    sum += subSum;
            }
        }
        return sum;
    }
}