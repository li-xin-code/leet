package leetcode.palindromenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例 1:
 * 
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * 
 * 你能不将整数转为字符串来解决这个问题吗？
 * 
 * @author ASUS
 *
 */
public class PalindromeNumber {
	public static void main(String[] args) {
		int x = 13231;
		boolean res = isPalindrome(x);
		System.out.println(res);
	}
	/**
	 * 官方最优解 => 实际测试和较好差不多,而且不稳定
	 * @param x
	 * @return
	 */
	public boolean isPalindrome1(int x) {
        if(x < 0) return false;
    	if(x >= 0 && x < 10) return true;
    	
    	int reverse_x = 0;
    	int temp_x = x;
    	
    	while(temp_x > 0) {
    		reverse_x = reverse_x*10 + temp_x % 10;
    		temp_x /= 10;
    	}
    	
        return reverse_x == x;
    }
	
	/**
	 * 较好
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int div = 1;
		int num = x;
		while (num / div >= 10) {
			div *= 10;
		}
		while (num != 0) {
			int left = num / div;
			int right = num % 10;
			if (left != right) {
				return false;
			}
			num = (num - div * left)/10; //去头去尾
			div /= 100;
		}
		return true;
	}
	
	/**
	 * 自己写的=垃圾
	 * @param x
	 * @return
	 */
	@Deprecated
	public static boolean isPalindrome0(int x) {
		if (x < 0) {
			return false;
		}
		List<Integer> digits = new ArrayList<Integer>();
		while (x > 0) {
			digits.add(x%10);
			x/=10;
		}
		Integer[] digitArray =  digits.toArray(new Integer[digits.size()]);
		for (int i = 0; i < digitArray.length/2; i++) {
			if (digitArray[i] != digitArray[digitArray.length-i-1]) {
				return false;
			}
		}
		return true;
    }
	
	
}
