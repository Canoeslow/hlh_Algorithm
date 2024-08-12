/**
 * @Author hanluhang
 * @Date 2021/7/20 16:01
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 */
package 实现Trie_前缀树;

public class Trie {
    //创建一个TreeNode节点，用来存储字符串的和结尾标记
    class TrieNode{
        boolean end;
        TrieNode[] tns=new TrieNode[26];
    }
    //创建字符串开头节点
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    public void insert(String word) {
        TrieNode p=root;
        for(int i=0;i<word.length();i++){
            int u=word.charAt(i)-'a';
            if(p.tns[u]==null) p.tns[u]=new TrieNode();
            p=p.tns[u];
        }
        p.end=true;
    }
    //检查当前字符串是否存在
    public boolean search(String word) {
        TrieNode p=root;
        for(int i=0;i<word.length();i++){
            int u=word.charAt(i)-'a';
            if(p.tns[u]==null) return false;
            p=p.tns[u];
        }
        return p.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode p=root;
        for(int i=0;i<prefix.length();i++){
            int u=prefix.charAt(i)-'a';
            if(p.tns[u]==null) return false;
            p=p.tns[u];
        }
        return true;
    }
}
