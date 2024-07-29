/**
 * @Author hanluhang
 * 算法通用Node链表节点
 */
package 随机链表的复制;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
