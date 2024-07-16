/**
    * @author 韩橹航
    * @version 1.0
    * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法
*/
package 矩阵置零;

import java.util.HashMap;

//这题使用两个标记，行标记和列标记，进行判断
public class first {
    public void setZeroes(int[][] matrix) {
        HashMap<Integer,Integer> col_map=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> row_map=new HashMap<Integer,Integer>();
        int length=matrix.length;
        int col_length=matrix[0].length;
        for(int i=0;i<length;i++){
            for(int j=0;j<col_length;j++){
                if(matrix[i][j]==0){
                    col_map.put(j,0);
                    row_map.put(i,0);
                }
            }
        }
        for(int i=0;i<length;i++){
            for(int j=0;j<col_length;j++){
                if(col_map.get(j)!=null||row_map.get(i)!=null)
                    matrix[i][j]=0;
            }
        }
    }
}
