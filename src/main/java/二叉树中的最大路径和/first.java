/**
 * @Author hanluhang
 * @Version
 * @Date 2021/7/16 10:51 上午
 * @Description
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 *
 */
package 二叉树中的最大路径和;

import 二叉树的最大深度_树.TreeNode;

public class first {
    int pathSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return pathSum;
    }
    public int dfs(TreeNode node){
        if(node==null) return 0;
        int left=dfs(node.left);
        int right=dfs(node.right);
        //判断当前节点适应于哪种情况，是自己还是左边或者右边
        int let=Math.max(node.val,node.val+Math.max(left,right));
        //看看是以自己为桥梁合适还是一条边合适
        pathSum=Math.max(pathSum,Math.max(let,node.val+left+right));
        return let;
    }
}
