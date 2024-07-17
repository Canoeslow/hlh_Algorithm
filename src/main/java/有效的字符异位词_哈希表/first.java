/**
    * @author 韩橹航
    * @version 1.0
    * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
*/
package 有效的字符异位词_哈希表;

import java.util.HashMap;

//采用同一个哈希表进行判断
public class first {
    public boolean isAnagram(String s, String t) {
        int s_length=s.length();
        int t_length=t.length();
        if(s_length!=t_length) return false;
        HashMap<Character,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<s_length;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            count++;
        }
        for(int i=0;i<t_length;i++){
            if(map.get(t.charAt(i))==null||map.get(t.charAt(i))==0) break;
            int change=map.get(t.charAt(i));
            map.put(t.charAt(i),change-1);
            count--;
        }
        if(count!=0) return false;
        return true;
    }
}
