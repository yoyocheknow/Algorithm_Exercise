package leetcode.BinarySearch;

/**
 * 二维矩阵的二分查找
 *
 * @author zhihua on 2020/12/31
 */
public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length<1){
            return false;
        }
        int left =0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;

        while (left<=right && top<=bottom){

            int colMid = (left+right)/2;
            while(top<=bottom){

                int rowMid = (top+bottom)/2;
                if(matrix[rowMid][colMid]==target){
                    return true;
                }
                else if(matrix[rowMid][colMid]<target){
                    top = rowMid+1;
                }else{
                    bottom = rowMid-1;
                }
            }
            if(matrix[top][colMid]==target){
                return true;
            }
            else if(matrix[top][colMid]<target){
                top ++;
            }else{
                bottom --;
            }

        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.print(new Search_a_2D_Matrix().searchMatrix(matrix,60));
    }
}