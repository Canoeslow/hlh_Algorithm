/**
 * @Author hanluhang
 * @Date 2021/7/26 10:50 上午
 * @Description 二叉搜索树的最小绝对值
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意节点的绝对值最小值。
 *
 */
package 二叉搜索树的最小绝对值;

import 二叉树的最大深度_树.TreeNode;

public class first {
    int index_min = Integer.MAX_VALUE; // 用于存储最小差值
    Integer prev = null; // 用于记录上一个节点的值

    public int getMinimumDifference(TreeNode root) {
        // 如果树为空，直接返回0
        if (root == null) return 0;

        // 进行中序遍历
        inorderTraversal(root);

        // 返回最小差值
        return index_min;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;

        // 遍历左子树
        inorderTraversal(root.left);

        // 计算当前节点与上一个节点的差值
        if (prev != null) {
            index_min = Math.min(index_min, Math.abs(root.val - prev));
        }

        // 更新上一个节点的值
        prev = root.val;

        // 遍历右子树
        inorderTraversal(root.right);
    }
}
