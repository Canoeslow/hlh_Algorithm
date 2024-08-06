/**
 * @Author hanluhang
 * @Date 2021/7/20 10:56
 * @Description
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
package 二叉树的右视图;

import 二叉树的最大深度_树.TreeNode;

import java.util.ArrayList;
import java.util.List;

//改用dfs只不过时根节点->右子树->左子树的顺序
public class second {
    List<Integer> res=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode root,int depth){
        if(root==null) return;
        if(depth==res.size()) res.add(root.val);
        depth++;
        dfs(root.right,depth);
        dfs(root.left,depth);
    }
}
