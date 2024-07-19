/**
 * @Author hanluhang
 * @Date 2021/7/16 16:00
 * @Description 最长连续序列_找出连续的数组长度
 * 给定一个整数数组 nums ，找出 nums 中最长的连续子序列的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长连续子序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 */
package 最长连续序列_找出连续的数组长度;

//第一种方法，遍历数组暴力查询的方法
public class first {
    class Solution {
        public int longestConsecutive(int[] nums) {
            int n = nums.length;
            int ans = 0;
            //通过循环逐步按顺序进行查询
            for (int i = 0; i < n; i++) {
                int cur = nums[i] + 1;
                while (true) {
                    // 标识是否在数组中找到了cur
                    boolean flag = false;
                    // 在数组中找cur
                    for (int j = 0; j < n; j++) {
                        if (nums[j] == cur) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        break;
                    }
                    cur += 1;
                }
                ans = Math.max(ans, cur - nums[i]);
            }
            return ans;
        }
    }

}
