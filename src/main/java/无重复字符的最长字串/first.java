/**
    * @author 韩橹航
    * @version 1.0
    *给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
*/
package 无重复字符的最长字串;

import java.util.HashSet;
import java.util.Set;

//使用滑动窗口进行判断
//使用集合Set进行子数组中是否重复的判断
public class first {
    public int lengthOfLongestSubstring(String s) {
        int length=s.length();
        if(length==0){
            return 0;
        }
        int right=-1,ans=0;
        Set<Character> occ=new HashSet<Character>();
        for(int i=0;i<length;i++){
            if(i!=0){
                occ.remove(s.charAt(i-1));
            }
            while(right+1<length&&!occ.contains(s.charAt(right+1))){
                occ.add(s.charAt(right+1));
                right++;
            }
            ans=Math.max(ans,right-i+1);
        }
        return ans;
    }
}
