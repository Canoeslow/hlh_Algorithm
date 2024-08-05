/**
 * @Author hanluhang
 * @Date 2021/7/16 16:06
 * @Description
 * 给定一个二叉搜索树，请按照中序遍历的顺序，返回一个由每层节点值组成的数组。
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 */
package 二叉搜索树迭代器;

import 二叉树的最大深度_树.TreeNode;

import java.util.ArrayList;

public class BSTIterator {
    //创建一个存放中序遍历元素的数组
    ArrayList<Integer> list=new ArrayList<>();
    //指针
    int index=0;
    //长度
    int len;
    public BSTIterator(TreeNode root) {
        //进行中序遍历初始化中序遍历数组
        zhong_fds(root);
        //初始化长度
        len=list.size();
    }

    public int next() {
        if(list.get(index)!=null){
            return list.get(index++);
        }
        return 0;
    }

    public boolean hasNext() {
        if(index<len) return true;
        return false;
    }
    public void zhong_fds(TreeNode root){
        if(root==null) return;
        //遍历左子树
        zhong_fds(root.left);
        list.add(root.val);
        //遍历右子树
        zhong_fds(root.right);
        return;
    }
}
