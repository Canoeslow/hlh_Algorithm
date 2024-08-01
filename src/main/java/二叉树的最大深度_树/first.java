/**
 * @Author hanluhang
 * @Version
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
package 二叉树的最大深度_树;
//DFS(深度优先搜索进行处理)
public class first {
    public int maxDepth(TreeNode root) {
        //这段代码使用递归进行处理
        //首先从左子树进行递归，不断进行深度的判断
        if(root==null){
            return 0;
        }
        else{
            int left=maxDepth(root.left);
            int right=maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }
}
