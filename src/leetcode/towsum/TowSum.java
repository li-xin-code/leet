package leetcode.towsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TowSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int targer = 9;
        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, targer);
        System.out.println(Arrays.toString(res));
    }

}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length <= 1) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int val = target - num;
            if (map.containsKey(val)) {
                res[0] = i;
                res[1] = (int) map.get(val);
                return res;
            } else {
                map.put(num, i);
            }
        }
        return res;
    }
}