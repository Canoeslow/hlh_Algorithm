/**
 * @Author hanluhang
 * @Date 2021/7/20 10:19 上午
 * @Description
 * @Version 1.0
 * 给你一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
package 删除链表中的倒数第N个节点;

import 环形链表_链表.ListNode;

//使用快慢指针进行创建
public class first {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        //设置快慢指针进行
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode low=dummy;
        ListNode fast=dummy;
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
        //这是快慢指针同时移动
        while(fast!=null){
            fast=fast.next;
            low=low.next;
        }
        low.next=low.next.next;
        return dummy.next;
    }
}
