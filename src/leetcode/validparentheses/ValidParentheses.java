package leetcode.validparentheses;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，
 * 判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 *
 * @author ASUS
 */
public class ValidParentheses {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = "()[]{}";
        boolean res = solution.isValid(s);
        System.out.println(res);
    }

}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> mark = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                mark.push(c);
            else if (c == ')' || c == '}' || c == ']') {
                if (mark.isEmpty()) return false;
                char curr = mark.pop();
                if (curr == '(' && c != ')') return false;
                if (curr == '[' && c != ']') return false;
                if (curr == '{' && c != '}') return false;
            }
        }
        return mark.isEmpty();
    }
}

class Solution2 {
    public boolean isValid(String s) {
        char[] ch = new char[s.length() + 1]; // stack
        int p = 1; // cursor
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(' || str[i] == '[' || str[i] == '{') {
                ch[p] = str[i];
                p++;
            } else {
                p--;
                if (str[i] == ')' && ch[p] != '(') return false;
                if (str[i] == ']' && ch[p] != '[') return false;
                if (str[i] == '}' && ch[p] != '{') return false;
            }
        }
        return p == 1;
    }
}

