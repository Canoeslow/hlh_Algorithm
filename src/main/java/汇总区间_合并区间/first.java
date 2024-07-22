/**
 * @Author hanluhang
 * @Date 2021/7/26 10:50
 * @Description 合并区间
 * 给定一个区间的集合，请合并所有重叠的区间。
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 */
package 汇总区间_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//先按照左边索引进行排序，再通过排序进行区间合并
public class first {
    public int[][] merge(int[][] intervals) {
        //先按照数组的长度为空，返回空数组
        if(intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> mergerd=new ArrayList<int[]>();
        for(int i=0;i< intervals.length;i++){
            int L=intervals[i][0],R=intervals[i][1];
            if(mergerd.size()==0||mergerd.get(mergerd.size()-1)[1]<L){
                mergerd.add(new int[]{L,R});
            }else{
                mergerd.get(mergerd.size()-1)[1]=Math.max(mergerd.get(mergerd.size()-1)[1],R);
            }
        }
        return mergerd.toArray(new int[mergerd.size()][]);
    }
}
