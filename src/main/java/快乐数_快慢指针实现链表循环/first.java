/**
 * @author: 韩橹航
 * @date: 2021-09-14 16:22
 * @description: 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 快乐数。
 * 如果可以变为 1，那么这个数就是快乐数。 如果 n 是快乐数，返回 true ；否则，返回 false 。
 */
package 快乐数_快慢指针实现链表循环;
//这道题的解法通过快慢指针实现链表循环的判断
public class first {
    public boolean isHappy(int n) {
        //使用快慢指针解决链表找环
        int slow=n,fast=squareSum(n);
        while(slow!=fast){
            slow=squareSum(slow);
            fast=squareSum(squareSum(fast));
        }
        return slow==1;
    }
    //算出每个数的位数平方和
    public int squareSum(int n){
        int sum=0;
        while(n>0){
            int index=n%10;
            sum+=index*index;
            n/=10;
        }
        return sum;
    }
}
