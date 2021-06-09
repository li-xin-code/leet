package leetcode.searchinsertposition;

import java.time.chrono.MinguoChronology;

import javax.sound.midi.MidiChannel;

/**
 * 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author ASUS
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0, res = 0;
        Solution solution = new Solution();
        target = 5;
        res = solution.searchInsert(nums, target);
        System.out.println(res);
        target = 2;
        res = solution.searchInsert(nums, target);
        System.out.println(res);
    }

}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid;
            else right = mid;
        }
        if (nums[right] < target) return right + 1;
        else if (nums[left] >= target) return left;
        else return right;
    }
}