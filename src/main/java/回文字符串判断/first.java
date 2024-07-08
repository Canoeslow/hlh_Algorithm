/**
    * @author 韩橹航
    * @version 1.0
    * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
    * 字母和数字都属于字母数字字符。
*/
package 回文字符串判断;
//这里首先先去除非数字字符内容
//使用双指针进行判断
public class first {
    public boolean isPalindrome(String s) {
        //先去除非数字字符内容
        StringBuffer sgood =new StringBuffer();
        int length=s.length();
        for(int i=0;i<length;i++){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n=sgood.length();
        int left=0,right=n-1;
        while(left<right){
            if(Character.toLowerCase(sgood.charAt(left))!=Character.toLowerCase(sgood.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
