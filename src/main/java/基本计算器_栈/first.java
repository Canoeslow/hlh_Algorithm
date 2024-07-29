/**
 * @Author hanluhang
 * @Date 2021/7/16 10:50
 * @Description 基本计算器
 * 实现一个基本的四则运算计算器，支持加减乘除四种运算符，并能正确处理括号。
 * 要求：
 * 1. 支持整数、小数、负数、括号等四种数据类型。
 * 2. 支持加减乘除四种运算符。
 * 3. 支持括号，括号内的运算优先级高于外层运算。
 * 4. 输出结果的精度应与输入数据类型一致。
 */
package 基本计算器_栈;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

//使用一个栈存放数据状态,就是表示当前是加号还是减号
public class first {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1); // 初始符号为正
        int sign = 1; // 当前符号
        int ret = 0; // 当前结果
        int i = 0;
        int n = s.length();

        while (i < n) {
            char c = s.charAt(i);

            if (c == ' ') {
                i++;
            } else if (c == '+') {
                sign = ops.peek(); // 取当前符号
                i++;
            } else if (c == '-') {
                sign = -ops.peek(); // 取当前符号的负值
                i++;
            } else if (c == '(') {
                ops.push(sign); // 将当前符号压入栈
                i++;
            } else if (c == ')') {
                ops.pop(); // 弹出括号前的符号
                i++;
            } else { // 处理数字
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
    }
