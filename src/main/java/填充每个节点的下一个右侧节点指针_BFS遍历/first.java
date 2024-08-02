/**
 * @Author hanluhang
 * @Date 2021/7/23 10:22 上午
 * @Description 填充每个节点的下一个右侧节点指针_BFS遍历
 *
 */
package 填充每个节点的下一个右侧节点指针_BFS遍历;

import java.util.LinkedList;
import java.util.Queue;

//在BFS中完成同层节点的连接
public class first {
    public Node connect(Node root) {
        //在广度优先遍历中完成next节点的相连
        if(root==null) return root;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queue_length=queue.size();
            //用来承担每行的头节点
            Node dummy=null;
            for(int i=0;i<queue_length;i++){
                //出队
                Node node=queue.poll();
                if(dummy!=null){
                    dummy.next=node;
                }
                dummy=node;
                //将左右子节点入队
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        return root;
    }
}
