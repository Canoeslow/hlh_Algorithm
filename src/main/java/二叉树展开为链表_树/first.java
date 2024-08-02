/**
 * @Author hanluhang
 * @Date 2021/7/16 10:42
 * @Description 二叉树展开为链表
 * 给你一棵二叉树，请你返回其展开为一个单链表所需要的节点个数。
 * 展开为链表是指，从左到右，逐层地把各层节点展开成链表。
 *
 */
package 二叉树展开为链表_树;

import 二叉树的最大深度_树.TreeNode;

//先遍历右子树，再遍历左子树
public class first {
    // 使用一个全局变量来记录前一个节点
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // 递归处理右子树
        flatten(root.right);
        // 递归处理左子树
        flatten(root.left);

        // 将当前节点的右指针指向前一个节点
        root.right = prev;
        // 将当前节点的左指针置为null
        root.left = null;
        // 更新前一个节点为当前节点
        prev = root;
    }
}
