package leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 *     [-1, 0, 1],
 *     [-1, -1, 2]
 * ]
 * @author ASUS
 *
 */
public class ThreeSum {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int nums[] = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = solution.threeSum(nums);
		System.out.println(res.size());
		res.stream().forEach((edit)->{
			System.out.print("[");
			edit.stream().forEach((n)->{
				System.out.print(n);
				if (edit.indexOf(n) != edit.size()-1) {
					System.out.print(", ");
				}
			});
			System.out.print("]");
			System.out.println();
			});
	}
	
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	ArrayList<List<Integer>> res = new ArrayList<>();
    	if (nums == null || nums.length <= 2) {
			return res;
		}
    	int n = nums.length;
    	int i = 0;
    	Arrays.sort(nums);
    	while (i < n-2) {
			int base = nums[i];
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				int sum = base + nums[left]+nums[right];
				if (sum == 0) {
					LinkedList<Integer> list = new LinkedList<>();
					list.add(base);
					list.add(nums[left]);
					list.add(nums[right]);
					res.add(list);
					left = moveRight(nums, left + 1);
					right = moveLeft(nums, right - 1);
				}else if (sum > 0) {
					right = moveLeft(nums, right - 1);
				}else {
					left = moveRight(nums, left + 1);
				}
			}
			i = moveRight(nums, i + 1);
		}
    	return res;
    }
    
    public int moveLeft(int[] nums, int right) {
		while (right == nums.length - 1 || 
				(right >= 0 && nums[right] == nums[right + 1])) {
			right--; 
		}
		return right;
	}
    
    public int moveRight(int[] nums, int left) {
    	while (left == 0 || 
				(left < nums.length && nums[left] == nums[left - 1])) {
    		left++; 
		}
		return left;
	}
    
    public List<List<Integer>> threeSum2(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int posNums = 0; // 正数的个数
        int negNums = 0; // 负数的个数
        int zeroNums = 0; // 0的个数
        for (int num : nums) {
            if (num < minVal)minVal = num;
            if (num > maxVal)maxVal = num;
            if (num == 0)zeroNums++;
            else if (num > 0)posNums++;
            else negNums++;
        }
        List<List<Integer>> result = new ArrayList<>();
        if (zeroNums>= 3) {
            result.add(Arrays.asList(0,0,0));
        }
        if (minVal >= 0 || maxVal <= 0) return result;
        if (maxVal + 2*minVal > 0)maxVal = -2*minVal;
        if (minVal + 2*maxVal < 0)minVal = -2*maxVal;
        int[] numMap = new int[maxVal-minVal+1];
        int[] posNumMap = new int[posNums];
        int[] negNumMap = new int[negNums];
        posNums = 0;
        negNums = 0;
        for (int num : nums) {
            if (num >= minVal && num <= maxVal) {
                if (numMap[num-minVal]++ == 0) {
                    if (num > 0) {
                        posNumMap[posNums++] = num;
                    } else if (num < 0) {
                        negNumMap[negNums++] = num;
                    }
                }
            }
        }
        Arrays.sort(posNumMap,0,posNums);
        Arrays.sort(negNumMap, 0, negNums);
        int posStart = 0;
        for (int i = negNums -1;i>=0;i--) {
            int nv = negNumMap[i];
            int minpv = (-nv)/2;
            while(posStart < posNums && posNumMap[posStart] < minpv)posStart++;
            for (int j = posStart;j<posNums;j++) {
                int pv = posNumMap[j];
                int ln = 0 - nv - pv;
                if (ln >= nv && ln <= pv) {
                    if (numMap[ln-minVal] == 0) continue;
                    else if (ln == nv && numMap[ln-minVal] > 1) {
                        result.add(Arrays.asList(nv,ln,pv));
                    } else if (ln == pv && numMap[ln-minVal] > 1) {
                        result.add(Arrays.asList(nv,ln,pv));
                    } else if (ln != nv && ln != pv){
                        result.add(Arrays.asList(nv,ln,pv));
                    }
                } else if (ln < nv) {
                    break;
                }
            }
        }
        return result;
        
    }
}
