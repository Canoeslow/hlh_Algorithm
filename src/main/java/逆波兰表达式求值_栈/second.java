/**
 * @Author hanluhang
 */
package 逆波兰表达式求值_栈;

import java.util.Stack;

//第二种使用栈进行
public class second {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer a1,a2;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    a1=stack.pop();
                    a2=stack.pop();
                    stack.push(a1+a2);
                    break;
                case "-":
                    a1=stack.pop();
                    a2=stack.pop();
                    stack.push(a1-a2);
                    break;
                case "*":
                    a1=stack.pop();
                    a2=stack.pop();
                    stack.push(a1*a2);
                    break;
                case "/":
                    a1=stack.pop();
                    a2=stack.pop();
                    stack.push(a1/a2);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
