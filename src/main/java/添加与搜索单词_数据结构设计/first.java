/**
 * @Author hanluhang
 * @Date 2021/7/20 10:59
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 */
package 添加与搜索单词_数据结构设计;

public class first {
    class Node {
        Node[] tns = new Node[26];
        boolean isWord;
    }
    Node root = new Node();
    public void addWord(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) p.tns[u] = new Node();
            p = p.tns[u];
        }
        p.isWord = true;
    }
    public boolean search(String s) {
        return dfs(s, root, 0);
    }
    boolean dfs(String s, Node p, int sIdx) {
        int n = s.length();
        if (n == sIdx) return p.isWord;
        char c = s.charAt(sIdx);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (p.tns[j] != null && dfs(s, p.tns[j], sIdx + 1)) return true;
            }
            return false;
        } else {
            int u = c - 'a';
            if (p.tns[u] == null) return false;
            return dfs(s, p.tns[u], sIdx + 1);
        }
    }
}
