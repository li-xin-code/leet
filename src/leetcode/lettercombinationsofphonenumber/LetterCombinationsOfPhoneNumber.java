package leetcode.lettercombinationsofphonenumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 * @author ASUS
 *
 */
public class LetterCombinationsOfPhoneNumber {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String digits;
		digits = "235";
		List<String> res = solution.letterCombinations(digits);
		System.out.println(res);
	}
}

class Solution {
    public List<String> letterCombinations(String digits) {
    	// dfs/bfs
    	List<String> res = new LinkedList<String>();
    	if (digits == null || digits.length() == 0) {
    		return res;
		}
    	HashMap<Character, char[]> map = new HashMap<Character, char[]>(8);
    	map.put('2', new char[] {'a', 'b', 'c'});
    	map.put('3', new char[] {'d', 'e', 'f'});
    	map.put('4', new char[] {'g', 'h', 'i'});
    	map.put('5', new char[] {'j', 'k', 'l'});
    	map.put('6', new char[] {'m', 'n', 'o'});
    	map.put('7', new char[] {'p', 'q', 'r', 's'});
    	map.put('8', new char[] {'t', 'u', 'v'});
    	map.put('9', new char[] {'w', 'x', 'y', 'z'});
    	
    	helper("", 0, digits, res, map);
    	
    	return res;
    }
    
    //dfs
    public void helper(String curr, int currIdx, String digits,
    		List<String> res, HashMap<Character, char[]> map) {
    	if (currIdx == digits.length()) {
			res.add(curr);
		}else {
			char c = digits.charAt(currIdx);
			if (map.containsKey(c)) {
				for (char ch : map.get(c)) {
					helper(curr + ch, currIdx + 1, digits, res, map);
				}
			}
		}
	}
}

class Solution2 {
    private static final char alpha[][] = {
          {'a','b','c'},//2
          {'d','e','f'},//3
          {'g','h','i'},//4
          {'j','k','l'},//5
          {'m','n','o'},//6
          {'p','q','r','s'},//7
          {'t','u','v'},//8
          {'w','x','y','z'},//9
  };
  //再使用一个一维数组记录下标

  public List<String> letterCombinations(String digits) {
      int length = digits.length();
      if(length == 0){
          return new ArrayList<>(0);
      }

      //计算容量，避免扩容
      int size = 1;
      int [] indexes = new int[length];
      for(int i = 0; i < length; i++){
          int c = digits.charAt(i) - '2';
          indexes[i] = c;
          if(c == 5 || c == 7){
              size = size << 2;
          } else {
              size *= 3;
          }
      }

      //缓存
      char [] cache = new char[length];
      //结果集
      List<String> list = new ArrayList<>(size);
      next(indexes,0,cache,list);

      return list;
  }

  private static void next(int[] indexes, int i, char[] cache, List<String> list) {
      if(i == indexes.length){
          list.add(new String(cache));
          return;
      }

      char [] temp = alpha[indexes[i]];
      for(char tmp : temp){//每一个号码对应的所有字母都加入结果串,递归一遍
          cache[i] = tmp;
          next(indexes,i+1,cache,list);
      }
  }
}