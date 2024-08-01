/**
 * @Author hanluhang
 * @Date 2021/7/20 10:50 上午
 * @Description
 * 给定一个二叉树，原地将它翻转。
 */
package 翻转二叉树_树;

import 二叉树的最大深度_树.TreeNode;

//通过DFS进行递归处理
public class first {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        //左右子树之间的交换
        TreeNode tmp=root.right;
        root.right=root.left;
        root.left=tmp;
        //递归左子节点
        invertTree(root.left);
        //递归右子节点
        invertTree(root.right);
        //递归完就显示当前节点
        return root;
    }
}
