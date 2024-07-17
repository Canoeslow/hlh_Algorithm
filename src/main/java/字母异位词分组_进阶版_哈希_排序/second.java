package 字母异位词分组_进阶版_哈希_排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//采用流式处理进行分组的方法,进行单词之间的排序，再进行分组
public class second {
    List<List<String>> list2=new ArrayList<>();
    public List<List<String>> groupAnagrams(String[] strs){
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str->{
                    //返回排序后的数组
                    //进行分组操作
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                })).values());
    }
}
