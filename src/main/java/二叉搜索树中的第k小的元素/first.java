/**
 * @Author hanluhang
 * @Date 2021/7/20 10:58 上午
 * @Description 二叉搜索树中的第k小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 */
package 二叉搜索树中的第k小的元素;

import 二叉树的最大深度_树.TreeNode;

public class first {
    //写一个接受值为index
    int index=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        //那就是中序遍历倒数第k个自然就是最小的那个数
        panduan(root,k);
        return index;
    }
    public int panduan(TreeNode root,int k){
        if(root==null) return k;
        //遍历左子树
        k=panduan(root.left,k);
        if(k==1){
            index=root.val;
        }
        k--;
        //遍历右子树
        k=panduan(root.right,k);
        return k;
    }
}
