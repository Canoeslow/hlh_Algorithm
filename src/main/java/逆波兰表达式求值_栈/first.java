/**
 * @Author hanluhang
 * @Date 2021/7/20 10:56
 * @Description 逆波兰表达式求值
 *      逆波兰表达式是一种后缀表达式，它的运算符在表达式的末尾，而操作数则在其前面。
 *      例如：1 + 2 * 3 - 4 / 5，它的逆波兰表达式为：5 2 * 3 + 1 -。
 *      逆波兰表达式求值算法的基本思路是：
 */
package 逆波兰表达式求值_栈;

import java.util.Stack;

//通过数栈进行存储
public class first {
    public int evalRPN(String[] tokens) {
        int[] stack=new int[tokens.length/2+1];
        int index=0;
        for(String token:tokens){
            switch(token){
                case "+": stack[index-2]+=stack[--index]; break;
                case "-": stack[index-2]-=stack[--index]; break;
                case "*": stack[index-2]*=stack[--index]; break;
                case "/": stack[index-2]/=stack[--index]; break;
                default:
                    stack[index++]=Integer.parseInt(token);
                    break;
            }
        }
        return stack[0];
    }
}
