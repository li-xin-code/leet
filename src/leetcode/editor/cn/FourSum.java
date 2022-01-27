package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18 - 4sum
 * 四数之和
 *
 * @author lixin
 * @date 2022-01-27 20:46:58
 */
public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(solution.fourSum(nums, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> q = new ArrayList<>();
            int len = nums.length;
            if (len < 4) {
                return q;
            }
            // 排序
            Arrays.sort(nums);
            for (int i = 0; i < len - 3; i++) {
                // 去重
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 如果这四数之和大于target, 往后算也必大于target
                if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                // 下面这四数之和小于target, 则nums[i]小了
                if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                for (int j = i + 1; j < len - 2; j++) {
                    // 去重
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    // 如果这四数之和大于target, 往后算也必大于target
                    if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    // 下面这四数之和小于target, 则nums[j]小了
                    if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                        continue;
                    }
                    // 接下来就是熟悉的双指针算法啦
                    int l = j + 1;
                    int r = len - 1;
                    while (l < r) {
                        int sum = nums[i] + nums[j] + nums[l] + nums[r];
                        if (sum == target) {
                            q.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l + 1]) {
                                l++;
                            }
                            while (l < r && nums[r] == nums[r - 1]) {
                                r--;
                            }
                            l++;
                            r--;
                        } else if (sum < target) {
                            // 小了就往右移
                            l++;
                        } else {
                            // 大了就往左移
                            r--;
                        }
                    }
                }
            }
            return q;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}

