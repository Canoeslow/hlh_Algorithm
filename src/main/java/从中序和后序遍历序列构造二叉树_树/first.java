/**
 * @Author hanluhang
 * @Date 2021/7/23 10:34
 * @Description
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历。请构造并返回这棵树的根节点。
 */
package 从中序和后序遍历序列构造二叉树_树;

import 二叉树的最大深度_树.TreeNode;

//通过DFS在遍历中创建树的节点
public class first {
    //基本思路：后序遍历的最后一个节点对应的先序遍历的位置左边一定是左子树
    //在后序遍历的数组显示将所有的左子树进行遍历后进行右子树的遍历
    //所以在先序左边的数量对应后序的数组中
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //进行长度判断
        int inorder_length=inorder.length;
        int postorder_length=postorder.length;
        if(inorder_length!=postorder_length) return null;
        return create_TreeNode(inorder,0,inorder_length-1,postorder,0,postorder_length-1);
    }
    public TreeNode create_TreeNode(int[] inorder,int in_left,int in_right,int[] postorder,int pos_left,int pos_right){
        //进行出界校验
        if(in_left>in_right||pos_left>pos_right) return null;
        //创建这一时刻的头节点
        int index=postorder[pos_right];
        TreeNode root=new TreeNode(index);
        int in_index=in_left;
        while(inorder[in_index]!=index) in_index++;
        int in_index_size=in_index-in_left;
        //递归创建左子树
        root.left=create_TreeNode(inorder,in_left,in_index-1,postorder,pos_left,in_index_size+pos_left-1);
        //递归创建右子树
        root.right=create_TreeNode(inorder,in_index+1,in_right,postorder,pos_left+in_index_size,pos_right-1);
        return root;
    }
}
