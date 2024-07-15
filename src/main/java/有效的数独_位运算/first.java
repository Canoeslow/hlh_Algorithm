/**
    * @author 韩橹航
    * @version 1.0
    *请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可
    * 数字 1-9 在每一行只能出现一次。
    * 数字 1-9 在每一列只能出现一次。
    * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
*/
package 有效的数独_位运算;
//这个题目使用一个位运算在循环中记录当前数据
public class first {
    public boolean isValidSudoku(char[][] board) {
        int[] row=new int[9];
        int[] col=new int[9];
        int[] v=new int[9];
        //遍历整个矩阵数组
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                //获取到数字对应的位置
                int num=1<<(board[i][j]-'0');
                //计算当前位置属于哪个九宫格
                int b=(i/3)*3+j/3;
                //检查当前数字在行，列，子宫格中是否存在
                if((row[i]&num)!=0||(col[j]&num)!=0||(v[b]&num)!=0){
                    return false;
                }
                row[i]=row[i]|num;
                col[j]=col[j]|num;
                v[b]=v[b]|num;
            }
        }
        return true;
    }
}
