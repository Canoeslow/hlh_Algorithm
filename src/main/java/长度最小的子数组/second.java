/**
    * @author 韩橹航
    * @version 1.0
*/
package 长度最小的子数组;

import java.util.Arrays;

//采取前缀和进行而二分查找进行的解答
//使用一个新的数组将原数组的每个前缀和进行计算，连续判断最小长度的数组
public class second {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        int[] sums=new int[n+1];
        sums[0]=0;
        for(int i=1;i<=n;i++){
            sums[i]=sums[i-1]+nums[i-1];
        }
        for(int i=1;i<=n;i++){
            int index=target+sums[i-1];
            int bound= Arrays.binarySearch(sums,index);
            if(bound<0){
                bound=-bound-1;
            }
            if(bound<=n){
                ans=Math.min(ans,bound-(i-1));
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
