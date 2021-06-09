package leetcode.findmediansortedarrays;

/**
 * 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author ASUS
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * 两个有序数组中找到第K个元素
     *
     * @param nums1
     * @param i     nums1的起始位置
     * @param nums2
     * @param j     nums2的起始位置
     * @param k     中位数位置
     * @return
     */
    public static int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        //当某一个数组的起始位置大于等于其数组长度时，
        //说明其所有数字均已经被淘汰了，相当于一个空数组了，
        //那么实际上就变成了在另一个数组中找数字，直接就可以找出来了。
        if (i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if (j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        //如果K=1的话，那么我们只要比较nums1和nums2的起始位置i和j上的数字就可以了
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        // m+n中找第k => m+n-（k/2）第找 k-(k/2)  (前提是-有序)
        // 例 122334中找第4=3 => 去掉(12) 即 2334 中找第 2=3

        // 找到数组 第k/2个元素 如果数组没有第k/2个元素返回最大值
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        // 如果数组1的第k/2个元素 小于 数组2的第k/2个元素
        // 表示 数组1的前k/2个元素 为两个数列中最小的 k/2个元素 (即使不是也没关系)
        // 即使 数组中没有k/2个元素 当k比较小的时候这个数组任然会被考虑进去
        // 即使只有一个元素在k=2的时候也会被考虑进去
        // 舍去这k/2个元素 即可让找第k个元素转换为找第k-(k/2)个元素 (前提是-有序)
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
