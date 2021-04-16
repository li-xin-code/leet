package leetcode.containerwithmostwater;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 示例：
 * 
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 
 * @author ASUS
 *
 */
public class ContainerWithMostWater {
	
	public static void main(String[] args) {
		int height[] = {1,8,6,2,5,4,8,3,7};
		int res = maxArea(height);
		System.out.println(res);
	}
	
	public static int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int area = 0;
		int left = 0;
		int right = height.length-1;
		while (left < right) {
			int hl = height[left];
            int hr = height[right];
			area = Math.max(area,
					(right-left)*Math.min(height[left], height[right]));
			if(hl>hr){
                while(height[right]<=hr&&right>left)
                    right--;
            }else{
                while(height[left]<=hl&&right>left)
                    left++;
            }
		}
		return area;
	}
}
