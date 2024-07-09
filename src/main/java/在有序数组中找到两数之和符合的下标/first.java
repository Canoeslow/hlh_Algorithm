/**
    * @author 韩橹航
    * @version 1.0
    * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
    * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
    * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
*/
package 在有序数组中找到两数之和符合的下标;
//此处使用双指针，一个放在最大一个放在最小根据情况挪动指针
public class first {
    public int[] twoSum(int[] numbers, int target) {
        //需要从中找出和为固定值的两个数组下标，一个从最大开始，一个从最小开始
        int left=0,right=numbers.length-1;
        int sum=0;
        while(left<right){
            sum=numbers[left]+numbers[right];
            if(sum==target){
                return new int[] {left+1,right+1};
            }
            if(sum<target){
                left++;
            }
            if(sum>target){
                right--;
            }
        }
        return new int[] {};
    }
}
