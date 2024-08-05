/**
 * @Author hanluhang
 * @Date 2021/7/26 10:50 上午
 * @Description
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 */
package 求根节点到叶节点数字之和;

import 二叉树的最大深度_树.TreeNode;

import java.util.ArrayList;
import java.util.List;

//采用DFS在遍历的过程中得出每条路径的值
public class first {
    List<Integer> list=new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        int num=0;
        int sum=0;
        if(root==null) return 0;
        digui(root,num);
        //遍历完成之后进行总数的计算
        for(Integer index:list){
            sum+=index;
        }
        return sum;
    }
    public void digui(TreeNode root,int num){
        if(root==null) return;
        num=num*10+root.val;
        if(root.left==null&&root.right==null){
            list.add(num);
            return;
        }
        //遍历左子树
        digui(root.left,num);
        //遍历右子树
        digui(root.right,num);
        return;
    }
}
