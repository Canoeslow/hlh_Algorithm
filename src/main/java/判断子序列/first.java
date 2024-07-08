/**
    * @author 韩橹航
    * @version 1.0
    * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
    * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
*/
package 判断子序列;
//我的理解，使用双指针进行判断

public class first {
    public boolean isSubsequence(String s, String t) {
        int index_s = s.length();
        int index_t = t.length();
        int left = 0, right = 0;

        while (left < index_t && right < index_s) {
            if (s.charAt(right) == t.charAt(left)) {
                right++;
            }
            left++; // 无论如何，left 指针都应该向前移动
        }

        return right == index_s;
    }
}
