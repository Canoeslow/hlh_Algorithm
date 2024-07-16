/**
    * @author 韩橹航
    * @version 1.0
    * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成如果可以，返回 true ；否则返回 false magazine 中的每个字符只能在 ransomNote 中使用一次。
*/
package 赎金信_哈希表;

import java.util.HashMap;

//这道题使用两个哈希表进行判断
public class first {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        int short_length=ransomNote.length();
        int long_length=magazine.length();
        int count=0;
        for(int i=0;i<short_length;i++){
            map.put(ransomNote.charAt(i),map.getOrDefault(ransomNote.charAt(i),0)+1);
            count++;
        }
        //根据长度进行判断
        for(int i=0;i<long_length;i++){
            if(map.get(magazine.charAt(i))!=null&&map.get(magazine.charAt(i))>0){
                int index=map.get(magazine.charAt(i));
                map.put(magazine.charAt(i),(index-1));
                count--;
            }
        }
        if(count==0) return true;
        return false;
    }
}
