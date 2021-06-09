package leetcode.lengthoflastword;

/**
 * @author lx
 * @date 2021/4/19
 * 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = " "
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "a ";
        Solution solution = new Solution();
        int lengthOfLastWord = solution.lengthOfLastWord(s);
        System.out.println(lengthOfLastWord);
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - (s.lastIndexOf(' ') + 1);
    }
}
