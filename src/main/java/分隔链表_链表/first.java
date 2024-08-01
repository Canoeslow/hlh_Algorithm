/**
 * @Author hanluhang
 * @Date 2021/7/20 10:59
 * @Description
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点排在大于等于 x 的节点之前。
 * 你应当保留两个分割点，第一个分割点位于链表的开头，第二个分割点位于链表的末尾。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
package 分隔链表_链表;

import 环形链表_链表.ListNode;

//分割两个节点一个存放小于k的值，一个存放大于k的值
public class first {
    public ListNode partition(ListNode head, int x) {
        //创建两个新节点分别用来存储所在的两个新节点
        ListNode xiao=new ListNode(0);
        ListNode da=new ListNode(0);
        ListNode index=da;
        ListNode dummy=xiao;
        while(head!=null){
            if(head.val<x){
                xiao.next=head;
                xiao=xiao.next;
                head=head.next;
            }
            else{
                da.next=head;
                da=da.next;
                head=head.next;
            }
        }
        xiao.next=index.next;
        da.next=null;
        return dummy.next;
    }
}
