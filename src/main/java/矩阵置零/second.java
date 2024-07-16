/**
    * @author 韩橹航
    * @version 1.0
*/
package 矩阵置零;
//这个方法的时间消耗更短，使用所在数组的第一行和第一列当作对应的标记位置
public class second {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;
        for(int j=0;j<col;j++){
            if(matrix[0][j] == 0){
                row0_flag = true;
                break;
            }
        }

        for(int i=0;i<row;i++){
            if(matrix[i][0] == 0){
                col0_flag = true;
                break;
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][0] == 0|| matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(row0_flag){
            for(int i=0;i<col;i++){
                matrix[0][i] = 0;
            }
        }
        if(col0_flag){
            for(int j=0;j<row;j++){
                matrix[j][0] = 0;
            }
        }

    }
}
