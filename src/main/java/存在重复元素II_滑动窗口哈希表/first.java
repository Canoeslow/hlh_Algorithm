/**
 * @Author hanluhang
 * @Date 2021/7/23 10:42 上午
 * @Description 存在重复元素II
 * 给定一个整数数组 nums 和一个整数 k，请返回该数组中是否存在两个不同的索引 i 和 j，使得 nums [i] == nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 */
package 存在重复元素II_滑动窗口哈希表;

import java.util.HashSet;
import java.util.Set;

//这道题采用活动窗口法，用一个哈希表来存储窗口内的元素，如果当前元素在哈希表中出现过，则说明窗口内存在重复元素，返回true；
public class first {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(i>k) set.remove(nums[i-k-1]);
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
