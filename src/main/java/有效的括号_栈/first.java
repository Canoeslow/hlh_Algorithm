/**
 * @Author hanluhang
 * @Date 2021/7/20 10:59 上午
 * @Description 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 */
package 有效的括号_栈;

import java.util.HashMap;
import java.util.Stack;

//通过栈进行本题的解决
public class first {
    //首先创建一个用来判断的字符集合
    private static final HashMap<Character,Character> map=new HashMap<Character,Character>(){{
        put('{','}');
        put('[',']');
        put('(',')');
        put('?','?');
    }};
    //在函数中判断初始括号
    public boolean isValid(String s) {
        if(s.length()>0&&!map.containsKey(s.charAt(0))) return false;
        //创建一个栈
        Stack<Character> stack=new Stack<Character>(){{push('?');}};
        //遍历字符串
        //进行字符串的合法性判断
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){stack.push(c);}
            else if(map.get(stack.peek())!=c){return false;}
        }
        return stack.size()==1;
    }
}
