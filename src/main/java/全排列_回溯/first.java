/**
 * @Author hanluhang
 * @Date 2021/7/16 10:57
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
package 全排列_回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class first {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null) return res;
        //创建一个存放三个数的缓存栈
        Deque<Integer> path=new ArrayDeque<>();
        dfs(nums,res,path,0);
        return res;
    }
    private void dfs(int[] nums,List<List<Integer>> res,Deque<Integer> path,int index){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        //遍历所有的搜索点
        for(int i=index;i<nums.length;i++){
            if(path.contains(nums[i])) continue;
            path.addLast(nums[i]);
            dfs(nums,res,path,index);
            //当一个组合搜索完成后删除缓存
            path.removeLast();
        }
    }
}
