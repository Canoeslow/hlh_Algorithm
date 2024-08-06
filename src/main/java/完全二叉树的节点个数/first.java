/**
 * @Author hanluhang
 * @Date 2021/7/16 10:50 上午
 * @Description 完全二叉树的节点个数
 * 给定一个完全二叉树，求出该树的节点个数。
 *
 */
package 完全二叉树的节点个数;

import 二叉树的最大深度_树.TreeNode;

public class first {
    int index=0;
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return index;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        index++;
        //遍历左子树
        dfs(root.left);
        //遍历右子树
        dfs(root.right);
        return;
    }
}
