/**
 * @Author hanluhang
 * @Version
 * @Date 2021/7/26 10:43
 * @Description 汇总区间
 * 给定一个区间的集合，请合并所有重叠的区间。
 *输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 */
package 汇总区间;

import java.util.ArrayList;
import java.util.List;

//这道题采用快慢指针进行操作
public class first {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int index_length = nums.length;

        // 处理空数组的情况
        if (index_length == 0) {
            return list;
        }

        int low = 0;
        int fast = 1;

        while (fast <= index_length) {
            // 当 fast 超过数组长度时，处理最后一个区间
            if (fast == index_length || nums[fast] != nums[fast - 1] + 1) {
                if (low == fast - 1) {
                    list.add(Integer.toString(nums[low]));
                } else {
                    list.add(nums[low] + "->" + nums[fast - 1]);
                }
                low = fast;
            }
            fast++;
        }

        return list;
    }
}
