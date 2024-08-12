/**
 * @Author hanluhang
 * @Date 2021/7/20 10:50 上午
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
package 组合总和;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class first {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(candidates, target, 0, res, path);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<List<Integer>> res, Deque<Integer> path) {
        int sum = path.stream().mapToInt(Integer::intValue).sum();
        if (sum > target) return; // 如果和大于目标，剪枝

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, target, i, res, path); // 允许重复使用当前元素
            path.removeLast(); // 回溯，移除最后添加的元素
        }
    }
}
