/**
 * @Author hanluhang
 * @Date 2021/7/20 16:23
 * @Description
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历。请你根据这两个整数数组构建并返回一个二叉树。
 *
 */
package 前序与中序遍历创建树;

import sun.reflect.generics.tree.Tree;
import 二叉树的最大深度_树.TreeNode;

//通过DFS的过程进行创建
public class firest {
    public TreeNode buildTree(int[] preorder,int[] inorder){
        //首先进行长度判断
        int preorder_length=preorder.length;
        int inorder_length=inorder.length;
        if(preorder_length!=inorder_length) return null;
        return create_TreeNode(preorder,0,preorder_length-1,inorder,0,inorder_length-1);
    }
    public TreeNode create_TreeNode(int[] preorder,int pre_left,int pre_right,int[] inorder,int in_left,int in_right){
        if(pre_left>pre_right||in_left>in_right) return null;
        //创建这一时刻的头节点
        int index_val=preorder[pre_left];
        TreeNode root=new TreeNode(index_val);
        //在中序数组中找到这个节点的位置，这个位置前面的就是这个节点对应的左子树
        int index=in_left;
        while(inorder[index]!=index_val) index++;
        //创建递归左子树
        root.left=create_TreeNode(preorder,pre_left+1,index-in_left+pre_left,inorder,in_left,index-1);
        //递归创建右子树
        root.right=create_TreeNode(preorder,index-in_left+pre_left+1,pre_right,inorder,index+1,in_right);
        return root;
    }
}
