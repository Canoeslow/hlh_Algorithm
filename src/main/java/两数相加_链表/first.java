/**
 * @Author hanluhang
 * @Date 2021/7/20 10:50 上午
 * @Description 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *   如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *   您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
* 示例：
* 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
* 输出：7 -> 0 -> 8
 */
package 两数相加_链表;

import 环形链表_链表.ListNode;

//使用一个新的链表进行判定，将两个链表的数字逐位相加，并将结果添加到新的链表中，直到两个链表中有一方结束，然后将剩余的链表的数字添加到新的链表中。
public class first {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // 创建一个虚拟头节点
        ListNode current = dummyHead; // 指向当前节点
        int carry = 0; // 初始化进位为 0

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10; // 更新进位
            current.next = new ListNode(sum % 10); // 创建新节点并链接
            current = current.next; // 移动到下一个节点

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 如果还有进位，添加一个新节点
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next; // 返回结果链表的头节点（跳过虚拟头节点）
    }
}
