package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 30 - substring-with-concatenation-of-all-words
 * 串联所有单词的子串
 *
 * @author lixin
 * @date 2022-01-29 16:25:21
 */
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int wl = words[0].length();
            int wn = words.length;
            List<Integer> result = new LinkedList<>();
            Map<String, Integer> wordMap = new HashMap<>(words.length);
            for (String word : words) {
                wordMap.putIfAbsent(word, wordMap.size());
            }
            short[] wordCount = new short[wordMap.size()];
            for (String word : words) {
                wordCount[wordMap.get(word)]++;
            }
            for (int i = 0; i <= s.length() - (wn * wl); i++) {
                boolean flag = true;
                short[] count = new short[wordMap.size()];
                for (int j = 0, next = i; j < wn; j++, next += wl) {
                    String word = s.substring(next, next + wl);
                    Integer index = wordMap.get(word);
                    if (!wordMap.containsKey(word) || count[index] == wordCount[index]) {
                        flag = false;
                        break;
                    }
                    count[index]++;
                }
                if (flag) {
                    result.add(i);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

