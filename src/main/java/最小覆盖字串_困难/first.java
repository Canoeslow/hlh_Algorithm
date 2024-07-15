/**
    * @author 韩橹航
    * @version 1.0
    * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
*/
package 最小覆盖字串_困难;

import java.util.HashMap;

//这道题目采用滑动窗口和双指针进行解答
public class first {
    public String minWindow(String s, String t) {
        //采用双指针加移动窗口解答这道题目
        HashMap<Character,Integer> hs=new HashMap<Character,Integer>();
        HashMap<Character,Integer> ht=new HashMap<Character,Integer>();
        //首先将模板串的字符添加到集合当中
        for(int i=0;i<t.length();i++){
            ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i),0)+1);
        }
        //进行字符串的滑动匹配
        String ans="";
        int len=Integer.MAX_VALUE,cnt=0;
        //使用双指针进行判断i为字符串的右指针j为字符串的左指针
        for(int i=0,j=0;i<s.length();i++){
            hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1);
            //如果ht中包含这个字符并且这个字符的出现次数小于模板中的次数
            if(ht.containsKey(s.charAt(i))&&hs.get(s.charAt(i))<=ht.get(s.charAt(i))) cnt++;
            //开始滑动左指针的区间，一但出现左指针所在位置不出现在模板中，左指针中出现的字符次数大于要求的字符次数
            while(j<i&&(!ht.containsKey(s.charAt(j))||hs.get(s.charAt(j))>ht.get(s.charAt(j)))){
                int count=hs.get(s.charAt(j))-1;
                hs.put(s.charAt(j),count);
                j++;
            }
            //迭代出现的次数
            if(cnt==t.length()&&i-j+1<len){
                len=i-j+1;
                ans=s.substring(j,i+1);
            }
        }
        return ans;
    }
}
