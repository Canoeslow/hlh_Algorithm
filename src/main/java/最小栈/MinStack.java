/**
 * @Author hanluhang
 * @Date 2021/7/20 10:54 上午
 * @Description 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 */
package 最小栈;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    //初始化堆栈对象
    List<Integer> stack;
    public int index;
    public MinStack() {
        stack = new ArrayList<Integer>();
        this.index=-1;
    }
    //将元素压入堆栈
    public void push(int val) {
        stack.add(val);
        index++;
    }
    //删除堆顶端的元素
    public void pop() {
        stack.remove(stack.size()-1);
        index--;
    }
    //获取栈顶端的元素
    public int top() {
        return stack.get(stack.size()-1);
    }
    //获取栈中的最小元素,采用流式处理
    public int getMin() {
        return stack.stream().min(Integer::compare).get();
    }
}
