/**
 * @Author hanluhang
 * @Date 2021/7/20 10:59 上午
 * @Description 随机链表的复制
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 * 我们用一个由 n 个节点组成的链表来表示输入/原始链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示节点值的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 -1。
 * 我们将这个链表复制成一个深拷贝链表。在深拷贝链表中，每个节点的值都相同，但是每个节点的 random 指针都指向复制链表中的一个节点，而不是原始链表中的节点。
 * 例如，如果输入链表是 [1,2,3,4,5]，其中 1 节点的 random 指针指向 3 节点，2 节点的 random 指针指向 1 节点，3 节点的 random 指针指向 5 节点，4 节点的 random 指针指向 2 节点，5 节点的 random 指针指向 4 节点，那么复制链表就是 [1,2,3,4,5]。
 */
package 随机链表的复制;

public class first {
    class Solution {
        public Node copyRandomList(Node head) {
            if(head==null){
                return null;
            }
            Node p=head;
            //首先给每个节点后面新增一个新的节点
            while(p!=null){
                Node newNode=new Node(p.val);
                newNode.next=p.next;
                p.next=newNode;
                p=newNode.next;
            }
            p=head;
            //第二步，设置随机节点
            while(p!=null){
                if(p.random!=null){
                    p.next.random=p.random.next;
                }
                p=p.next.next;
            }
            Node dummy=new Node(-1);
            p=head;
            Node cur=dummy;
            //分离两个链表
            while(p!=null){
                cur.next=p.next;
                cur=cur.next;
                p.next=cur.next;
                p=p.next;
            }
            return dummy.next;
        }
    }
}
