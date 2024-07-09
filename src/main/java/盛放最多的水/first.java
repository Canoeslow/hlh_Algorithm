/**
    * @author 韩橹航
    * @version 1.0
    *给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    * 返回容器可以储存的最大水量。
*/
package 盛放最多的水;
//此处使用双指针加上贪心的思维进行解答
//首先双指针位于数组的两端，进行判断，将相较端的指针内移，进行判断，不断迭代能够盛水的最大值
public class first {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int index_max=0;
        int max=0;
        while(left<right){
            index_max=Math.min(height[left],height[right])*(right-left);
            max=Math.max(max,index_max);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}
