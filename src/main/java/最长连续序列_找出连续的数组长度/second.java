/**
 * @Author hanluhang
 * @Date 2021/7/20 16:13
 */
package 最长连续序列_找出连续的数组长度;

import java.util.HashSet;
import java.util.Set;

// 第二种解法：使用Set集合优化遍历
public class second {
    public int longestConsecutive(int[] nums) {
        //因为Set有去重机制，这样就不需要进行重复的遍历
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans=0;
        //直接对Set集合进行遍历，遍历的过程中进行最大连续数的判断
        for(int num:set){
            int cur=num;
            if(!set.contains(cur-1)){
                while(set.contains(cur+1)){
                    cur++;
                }
            }
            ans=Math.max(ans,cur-num+1);
        }
        return ans;
    }
}
