package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵II
 *
 * @author zhihua on 2020/12/14
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        List<Integer> result = new ArrayList<>();
        int rowTop = 0;
        int rowBottom = n-1;
        int columnLeft = 0;
        int columnRight = n-1;
        int start =1 ;
        //初始矩阵
        for(int i=0;i<n;i++){
            int [] row = new int[n];
            matrix[i]=row;
        }
        while(rowTop<=rowBottom && columnLeft<=columnRight){
            //向右，到头后顶部加一行
            for(int i=columnLeft;i<=columnRight;i++){
                matrix[rowTop][i]=start++;
            }
            rowTop++;
            //向下，到头后右边减一列
            for(int i=rowTop;i<=rowBottom;i++){
                matrix[i][columnRight]=start++;
            }
            columnRight--;

            //向左，到头后底部减一行
            //加上行边界的判断，防止过度螺旋
            if(rowTop<=rowBottom){
                for(int i=columnRight;i>=columnLeft;i--){
                    matrix[rowBottom][i]=start++;
                }
                rowBottom--;
            }
            //向上，到头后左边加一列
            //加上列边界的判断，防止过度螺旋
            if(columnLeft<=columnRight)
            {
                for(int i=rowBottom;i>=rowTop;i--){
                    matrix[i][columnLeft]=start++;
                }
                columnLeft++;
            }
        }

        return matrix;
    }

    public static void main(String[] args){
        int[][] matrix =new SpiralMatrixII().generateMatrix(1) ;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}