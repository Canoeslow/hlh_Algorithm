/**
 * @Author hanluhang
 * @Date 2021/7/26 10:51
 * @Description
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：
 * 给你这个链表：1->2->3->4->5->6->7->8->null
 * 和 k = 3
 * 输出：3->2->1->6->5->4->7->8->null
 * 解释：
 * 翻转前的链表是 1->2->3->4->5->6->7->8->null
 * 翻转后得到 3->2->1->6->5->4->7->8->null
 * 第一个 3 翻转成 2，第二个 3 翻转成 1，第三个 3 翻vert成 6，依此类推。
 */
package K个一组翻转链表;

import 环形链表_链表.ListNode;

public class first {
    //递归翻转的逻辑：
    //集合测试用例来看，首先传入13，然后newNode节点为2，此时的head为tail3
    //进行递归传入3，5，newNodde为4，head为tail5
    //在进行递归返回头节点head为5
    //递归返回5
    //
    public ListNode reverseKGroup(ListNode head, int k) {
        //首先进行链表判空
        if(head==null||head.next==null){
            return head;
        }
        //到达反转位置
        ListNode tail=head;
        for(int i=0;i<k;i++){
            //当数量小于k的话，则不需要进行反转
            if(tail==null){
                return head;
            }
            tail=tail.next;
        }
        //反转前k个元素
        ListNode newHead=reverse(head,tail);
        head.next=reverseKGroup(tail,k);
        return newHead;

    }
    //翻转的逻辑：首先记录当前head头节点的下一个节点，将当前节点指向上一个保留的节点，跟新pre为当前节点，head成为下一个节点
    //比如2,3,4,首先next记录3，2指向null，更新pre为2，head头节点下移为3
    //记录next为4，3的下一个结点指向2，更新pre为3，head下移，当前为3，2，null
    //记录next为tail，4的下一个节点指向3，更新节点pre为4的节点，head节点为tail
    public ListNode reverse(ListNode head,ListNode tail){

        ListNode pre=null;
        ListNode next=null;
        while(head!=tail){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
