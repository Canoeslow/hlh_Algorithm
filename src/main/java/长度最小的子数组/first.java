/**
    * @author 韩橹航
    * @version 1.0
    * 给定一个含有 n 个正整数的数组和一个正整数 target 。
    * 找出该数组中满足其总和大于等于 target 的长度最小的子数组
    *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
*/
package 长度最小的子数组;
//第一种方法，暴力解法，首先先将长度初始化设置为无穷大，依次将每一个下标作为子数组的第一个下标进行判断，逐渐迭代更新最小的子数组长度
//时间复杂度 O（n^2）
public class first {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
