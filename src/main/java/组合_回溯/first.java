/**
 * @Author hanluhang
 * @Date 2021/7/16 10:24
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
package 组合_回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class first {
    //解题思路（在循环中进行递归，符合条件的退出）
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        if(k<=0||n<k) return res;
        //从一开始
        Deque<Integer> path=new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return res;
    }
    private void dfs(int n,int k,int begin,Deque<Integer> path,List<List<Integer>> res){
        //递归终止条件是，path的长度等于k
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        //遍历可能的搜索起点
        for(int i=begin;i<=n;i++){
            path.addLast(i);
            //进行下一轮的搜索
            dfs(n,k,i+1,path,res);
            //当当前完成搜索之后进行删除缓存
            path.removeLast();
        }
    }
}
