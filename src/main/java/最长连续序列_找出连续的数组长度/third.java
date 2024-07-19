/**
 * @Author hanluhang
 * @Date 2021/7/20 10:50 上午
 */
package 最长连续序列_找出连续的数组长度;

import java.util.HashMap;
import java.util.Map;

//第三种方法
public class third {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int num:nums){
            if(!map.containsKey(num)){
                int left=map.getOrDefault(num-1,0);
                int right=map.getOrDefault(num+1,0);
                int curLen=left+right+1;
                ans=Math.max(ans,curLen);
                map.put(num,-1);
                map.put(num-left,curLen);
                map.put(num+right,curLen);
            }
        }
        return ans;
    }
}
