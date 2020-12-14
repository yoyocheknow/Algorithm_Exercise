package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author zhihua on 2020/12/14
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int rowTop = 0;
        int rowBottom = matrix.length-1;
        int columnLeft = 0;
        int columnRight = matrix[0].length-1;

        while(rowTop<=rowBottom && columnLeft<=columnRight){
            //向右，到头后顶部加一行
            for(int i=columnLeft;i<=columnRight;i++){
                result.add(matrix[rowTop][i]);
            }
            rowTop++;
            //向下，到头后右边减一列
            for(int i=rowTop;i<=rowBottom;i++){
                result.add(matrix[i][columnRight]);
            }
            columnRight--;

            //向左，到头后底部减一行
            //加上行边界的判断，防止过度螺旋
            if(rowTop<=rowBottom){
                for(int i=columnRight;i>=columnLeft;i--){
                    result.add(matrix[rowBottom][i]);
                }
                rowBottom--;
            }
            //向上，到头后左边加一列
            //加上列边界的判断，防止过度螺旋
            if(columnLeft<=columnRight)
            {
                for(int i=rowBottom;i>=rowTop;i--){
                    result.add(matrix[i][columnLeft]);
                }
                columnLeft++;
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.print(new SpiralMatrix().spiralOrder(matrix).toString());
    }

}