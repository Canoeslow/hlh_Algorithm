/**
 * @Author hanluhang
 * @Date 2021/7/20 10:19 PM
 * @Description      环形链表
 * @Version 1.0
 *
 * 给定一个链表，判断链表中是否有环。
 */
package 环形链表_链表; // 确保与实际包名一致

import java.util.HashSet;

public class first {
    // 检测链表是否有环的方法
    public boolean hasCycle(ListNode head) {
        // 使用 HashSet 记录访问过的节点
        HashSet<ListNode> visitedNodes = new HashSet<>();

        // 遍历链表
        while (head != null) {
            // 如果当前节点已经在 HashSet 中，说明有环
            if (!visitedNodes.add(head)) {
                return true;
            }
            // 继续访问下一个节点
            head = head.next;
        }

        // 遍历完链表没有发现环
        return false;
    }
}