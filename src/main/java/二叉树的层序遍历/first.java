/**
 * @Author hanluhang
 * @Date 2021/7/16 10:52
 * @Description 层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 */
package 二叉树的层序遍历;

import 二叉树的最大深度_树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class first {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        if(root==null) return list;
        while(!queue.isEmpty()){
            int queue_length=queue.size();
            List<Integer> index=new ArrayList<>();
            for(int i=0;i<queue_length;i++){
                TreeNode node=queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                index.add(node.val);
            }
            list.add(index);
        }
        return list;
    }
}

