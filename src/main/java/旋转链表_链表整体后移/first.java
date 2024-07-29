/**
 * @Author hanluhang
 * @Date 2021/7/20 10:50 上午
 * @Description
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 */
package 旋转链表_链表整体后移;

import 环形链表_链表.ListNode;

//找到对应的移动到头节点的位置进行头节点的转换就行了
public class first {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0) return head;
        int length=0;
        ListNode end=null;
        for(ListNode p=head;p!=null;p=p.next){
            end=p;
            length++;
        }
        k%=length;
        ListNode p=head;
        for(int i=0;i<length-k-1;i++) p=p.next;
        end.next=head;
        head=p.next;
        p.next=null;
        return head;
    }
}
