/**
 * @Author hanluhang
 * @Date 2021/7/20 10:59 上午
 * @Description 验证是不是二叉搜索树
 */
package 验证是不是二叉搜索树;

import 二叉树的最大深度_树.TreeNode;

import java.util.ArrayList;
import java.util.List;
//执行时间2ms
public class first {
    //中序遍历
    List<Integer> list=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        //先序遍历进行一个判断
        //if(root.left!=null) return root.val>root.left.val?true:false;
        //if(root.right!=null) return root.val<root.right.val?true:false;
        //return isValidBST(root.left)&&isValidBST(root.right);
        huoqu(root);
        //检查顺序是否一致;
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)) return false;
        }
        return true;
    }
    public void huoqu(TreeNode root){
        if(root==null) return;
        //中序遍历获取节点
        huoqu(root.left);
        list.add(root.val);
        huoqu(root.right);
        return;
    }
}
