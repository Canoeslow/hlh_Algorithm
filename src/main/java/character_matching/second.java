/**
    * @author 韩橹航
    * @version 1.0
*/
package character_matching;
//这里采用java原生的封装方法
public class second {
    //第一种方法直接调用String的方法进行
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    //第二种方法
    public int second_strStr(String haystack,String needle){
        int needle_length=needle.length();
        for(int i=0;i<haystack.length()-needle_length;i++){
            String subString=haystack.substring(i,needle_length+i);
            if (subString.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
