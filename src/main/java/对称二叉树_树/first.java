/**
 * @Author hanluhang
 * @Date 2021/7/15 10:42
 * @Description
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
package 对称二叉树_树;

import 二叉树的最大深度_树.TreeNode;

//DFS进行遍历，判断对应的左节点和右节点是否对称
public class first {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        //调用递归函数比较左节点和右节点
        return bijiao(root.left,root.right);
    }
    boolean bijiao(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        if(left.val!=right.val) return false;
        return bijiao(left.left,right.right)&&bijiao(left.right,right.left);
    }
}
