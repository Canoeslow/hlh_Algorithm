/**
 * @Author hanluhang
 * @Date 2021/7/20 10:50
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
package 相同的树_树;

import 二叉树的最大深度_树.TreeNode;
//DFS进行遍历，在同时遍历中进行比较
public class first {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;
        if(p==null||q==null)
            return false;
        if(p.val!=q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
