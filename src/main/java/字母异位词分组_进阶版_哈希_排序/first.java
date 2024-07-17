/**
    * @author 韩橹航
    * @version 1.0
    * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
*/
package 字母异位词分组_进阶版_哈希_排序;

import java.util.*;

//首先对词语进行排序，在在Hash表中创建集合
public class first {
    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] arr=str.toCharArray();
            //排序
            Arrays.sort(arr);
            //将排序后的字符串作为key，将原字符串添加到集合中
            String key=new String(arr);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
