package leetcode.searchforarange;import java.time.chrono.MinguoChronology;
import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，
 * 和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 * @author ASUS
 *
 */
public class SearchForARange {

	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		Solution solution = new Solution();
		int[] res = solution.searchRange(nums, target);
		for (int i : res) {
			System.out.println(i);
		}
	}

}

class Solution {
    public int[] searchRange(int[] nums, int target) {
    	int[] res = {-1,-1};
    	if (nums == null || nums.length == 0) return res;
    	int st_point = -1, end_point = -1;
    	int start = 0 , end = nums.length - 1;
    	while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] >= target) end = mid;
			else start = mid;
		}
    	if (nums[start] == target) st_point = start;
    	else if (nums[end] == target) st_point = end;
    	if (st_point == -1)	return res;
    	start = 0;
    	end = nums.length - 1;
    	while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > target) end = mid;
			else start = mid;
		}
    	if (nums[end] == target) end_point = end;
    	else if (nums[start] == target) end_point = start;
    	res[0] = st_point;
    	res[1] = end_point;
    	return res;
    }
}

//内存占用少
class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];
       
        if(nums.length == 0){
            result[0] = -1;
            result[1] = -1;
            return  result;
        } 
        result[0] = findFirst(nums, nums.length, target);
        result[1] = findLast(nums, nums.length, target);
       return result;
    }
    
    public int findFirst(int [] a, int len, int key) {
	    if (len < 1) return - 1;
	    int low = 0;
	    int high = len - 1;
	    while(low <= high)
	    {
	        int mid = (low + high)/2;
	        if (a[mid] == key && (mid - 1 < 0 || a[mid - 1] != key))
	        	return mid;
	        else if (a[mid] >= key)
	        	high = mid - 1;
	        else
	            low = mid + 1;
	    }
	    return -1;
	}
    public int findLast(int [] a, int len, int key) {
    	if (len < 1) return - 1;
    	int low = 0;
    	int high = len - 1;
    	while(low <= high) {
	        int mid = (low + high)/2;
	        if (a[mid] == key && (mid + 1 >= len || a[mid + 1] != key))
	        	return mid;
	        else if (a[mid] <= key)
	        	low = mid + 1;
	        else
	        	high = mid - 1;
    	}
        return -1;
    }
}