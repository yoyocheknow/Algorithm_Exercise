package leetcode.BinarySearch;

/**
 * 二维矩阵的二分查找
 *
 * @author zhihua on 2020/12/31
 */
public class Search_a_2D_Matrix {
    //先在列上按照二分查找思路查找
    //如果第一行的最后一个数据还是小于target，说明应该去下一行
    //然后在下一行继续二分查找
    //时间复杂度为N log(n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length<1){
            return false;
        }
        int left =0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int row = top;
        while (left<=right && row<=bottom){
            int colMid = (left+right)/2;

            if(matrix[row][colMid]==target){
                return true;
            }
            else if(matrix[row][colMid]>target ){
                right = colMid-1;
            }else if(matrix[row][colMid]<target && matrix[row][right]<target){
                if(row<=bottom){
                    row = ++top;
                }else{
                    left = colMid+1;
                }

            }else if(matrix[row][colMid]<target && matrix[row][right]>=target){
                left = colMid+1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1},{3}};
        System.out.print(new Search_a_2D_Matrix().searchMatrix(matrix,3));
    }
}