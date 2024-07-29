/**
 * @Author hanluhang
 * @Date 2021/7/26 10:25
 * @Description 合并两个有序链表
 * 给你两个有序链表，请你将两个链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 *         示例：
 *         输入：1->2->4, 1->3->4
 *         输出：1->1->2->3->4->4
 *
 */
package 合并两个有序链表;

import 环形链表_链表.ListNode;

public class first {
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode list=new ListNode(0);
            ListNode index=list;
            while(list1!=null&&list2!=null){
                if(list1.val<=list2.val){
                    index.next=list1;
                    list1=list1.next;

                }else{
                    index.next=list2;
                    list2=list2.next;
                }
                index=index.next;
            }
            if(list1!=null){
                index.next=list1;
            }
            if(list2!=null){
                index.next=list2;
            }
            return list.next;
        }
    }
}
