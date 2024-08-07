/**
 * @Author hanluhang
 * @Date 2021/7/20 10:12 上午
 * @Description
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 */
package 二叉树的层平均值;

import 二叉树的最大深度_树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class first {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
            double index=0;
            int queue_length=queue.size();
            for(int i=0;i<queue_length;i++){
                TreeNode node=queue.poll();
                index+=node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            double even=index/queue_length;
            list.add(even);
        }
        return list;
    }
}
