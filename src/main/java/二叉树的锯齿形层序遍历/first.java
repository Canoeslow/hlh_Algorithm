/**
 * @Author hanluhang
 * @Date 2021/7/23 10:34
 * @Description
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
package 二叉树的锯齿形层序遍历;

import 二叉树的最大深度_树.TreeNode;

import java.util.*;

public class first {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        //进行翻转
        int list_length=list.size();
        for(int i=0;i<list_length;i++){
            if(i%2!=0) Collections.reverse(list.get(i));
        }
        return list;
    }
}
