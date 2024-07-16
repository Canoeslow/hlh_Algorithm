/**
    * @author 韩橹航
    * @version 1.0
    * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。如果可以，返回 true ；否则返回 false 。magazine 中的每个字符只能在 ransomNote 中使用一次。
*/
package 赎金信_哈希表;
//这题使用一个26位的支付数组记录存在的字符所在的位置，通过尽力字符存在的位置判断是否成功
public class second {
    public boolean canConstruct(String ransomNote, String magazine) {
        //这种方法使用
        int[] pos=new int[26];
        char[] chars=ransomNote.toCharArray();
        for(char c:chars){
            int start=pos[c-'a'];
            start=magazine.indexOf(c,start);
            if(start==-1){
                return false;
            }
            pos[c-'a']=start+1;
        }
        return true;
    }
}
