package leetcode.longestvalidparentheses;

import java.util.Stack;

import javax.lang.model.element.VariableElement;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，
 * 找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 
 * 示例 2:
 * 
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 
 * @author ASUS
 *
 */
public class LongestValidParentheses {
	
	public static void main(String[] args) {
		String s = ")()())";
		Solution solution = new Solution();
		int res = solution.longestValidParentheses(s);
		System.out.println(res);
	}
	
}

class Solution {
	public int longestValidParentheses(String s) {
        if (s == null||s.length()==0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (cs[i] == ')') {
                if (cs[i - 1] == '(') {
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else {
                    int l = dp[i - 1];
                    int index = i - l - 1;
                    if (index >= 0) {
                        if (cs[index] == '(') {
                        	dp[i] = dp[i - 1] + 2;
                        	if(index>0){
                        		dp[i]+=dp[index-1];
                        	}
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
//    public int longestValidParentheses(String s) {
//    	if (s == null || s.length() < 2) return 0;
//    	int n = s.length();
//    	int max =  0;
//    	int leftmost = -1;
//    	Stack<Integer> stack = new Stack<>();
//    	for (int i = 0; i < n; i++) {
//			if (s.charAt(i) == '(') {
//				stack.push(i);
//			}else {
//				if (stack.isEmpty()) {
//					leftmost = i;
//				}else {
//					int j = stack.pop();
//					if (stack.isEmpty())
//						max = max > i-leftmost ? max : i - leftmost;
//					else
//						max = max > i-stack.peek() ? max : i-stack.peek();
//				}
//			}
//		}
//    	return max;
//    }
}