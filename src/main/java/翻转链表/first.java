/**
 * @Author hanluhang
 * @Date 2021/7/20 10:50 上午
 * @Description 翻转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
package 翻转链表;

import 环形链表_链表.ListNode;

//使用头插法进行创建
public class first {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        //定义一个公共的头节点方便处理
        ListNode index=new ListNode(0);
        index.next=head;
        //初始化左右指针
        ListNode g=index;
        ListNode p=index.next;
        //定位指针
        for(int i=0;i<left-1;i++){
            g=g.next; p=p.next;
        }
        //头插法,将第一个需要转换的节点向后，依次插入到对应的位置
        for(int i=0;i<right-left;i++){
            ListNode removed=p.next;
            p.next=p.next.next;
            removed.next=g.next;
            g.next=removed;
        }
        return index.next;
    }
}
