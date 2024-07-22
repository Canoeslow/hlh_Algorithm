/**
 * @Author hanluhang
 * @Date 2021/7/26 10:50
 * @Description 用最少的箭引爆气球
 * 给你一个整数数组 points ，其中 points[i] 表示第 i 个气球的位置，返回需要射出多少箭才能引爆所有气球。
 * 你可以假设所有气球都在一个平面上，用整数 x 轴表示，且所有气球的位置都互不相同。
 * 一个箭的射程为 x 轴上从任意点出发最多可以射出的距离。
 * 你可以选择任意数量的箭，并可以将它们在同一时间射出。
 * 请返回用最少数量的箭引爆所有气球。
输入：points = [[10,16],[2,8],[1,6],[7,12]]
输出：2
解释：气球可以用2支箭来爆破:
 */
package 汇总区间_用最少数量的箭引爆气球;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 就是计算最大的重叠区间
public class first {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;

        // 按照气球的结束点排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // 至少需要一支箭
        int end = points[0][1]; // 结束点初始化为第一个气球的结束点

        for (int i = 1; i < n; i++) {
            if (points[i][0] > end) { // 如果当前气球的起点在上一个气球的结束点之后，需要新的箭头
                arrows++;
                end = points[i][1]; // 更新结束点为当前气球的结束点
            }
        }

        return arrows;
    }
}
