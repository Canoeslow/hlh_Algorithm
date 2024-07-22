/**
 * @Author hanluhang
 * @Date 2021/7/26 10:50
 * challenge description: 给定一个已排序的区间数组，插入一个新的区间，使得区间数组仍然是已排序的。
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 */
package 汇总区间_插入区间;

import java.util.ArrayList;
import java.util.List;

public class first {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 处理空数组的情况
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> list = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 添加所有在 newInterval 之前的区间
        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        // 合并所有与 newInterval 重叠的区间
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);

        // 添加所有在 newInterval 之后的区间
        while (i < n) {
            list.add(intervals[i]);
            i++;
        }

        // 转换为二维数组并返回
        return list.toArray(new int[list.size()][]);
    }
        }
