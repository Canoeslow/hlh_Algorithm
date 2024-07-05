/**
    * @author 韩橹航
    * @version 1.0
    * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
*/
package character_matching;

public class KMP_first {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle) ){
            return 0;
        }
        int len = needle.length();
        char[] str = haystack.toCharArray();
        for(int i = 0;i < str.length;i++){
            if(str[i] == needle.charAt(0)&&i + len-1 < str.length){
                if(haystack.substring(i,i + len).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}
