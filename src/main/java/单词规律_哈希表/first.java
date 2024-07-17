/**
    * @author 韩橹航
    * @version 1.0
    * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
*/
package 单词规律_哈希表;

import java.util.HashMap;

//我的思路，使用两个哈希表进行双向映射记录
public class first {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> pattern_index = new HashMap<>();
        HashMap<String, Character> s_index = new HashMap<>();

        String[] words_s = s.split("\\s+");
        int pattern_length = pattern.length();
        int words_length = words_s.length;

        if (pattern_length != words_length) return false;

        for (int i = 0; i < pattern_length; i++) {
            char patternChar = pattern.charAt(i);
            String word = words_s[i];

            if (pattern_index.containsKey(patternChar)) {
                if (!pattern_index.get(patternChar).equals(word)) {
                    return false;
                }
            } else {
                pattern_index.put(patternChar, word);
            }

            if (s_index.containsKey(word)) {
                if (s_index.get(word) != patternChar) {
                    return false;
                }
            } else {
                s_index.put(word, patternChar);
            }
        }

        return true;
    }
}
