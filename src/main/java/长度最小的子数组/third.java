/**
    * @author 韩橹航
    * @version 1.0
*/
package 长度最小的子数组;
//使用滑动窗口进行维护
public class third {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        //此处滑动窗口通过两个指针进行维护
        int start=0,end=0;
        //通过sum进行滑动窗口内子数组总和的判断
        int sum=0;
        //以右指针为滑动窗口的右边缘依据
        while(end<n){
            sum+=nums[end];
            while(sum>=target){
                ans=Math.min(ans,end-start+1);
                sum-=nums[start];
                start++;
            }
            end++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
