package SwardToOffer;

import java.util.List;

/**
 * 找出矩阵中的数字
 * 矩阵的数字向右递增，向下递增
 * @author zhihua on 2020/12/16
 */
public class Find_the_Number_of_the_Matrix {
    Boolean result=false;

    public Boolean solution(int[][] matrix,int target){
        if(matrix.length<1){
            return false;
        }
        backTrack(0,0,matrix,target);
        //find(0,matrix[0].length-1,matrix,target);
        return result;
    }
    //回溯法
    public void backTrack(int row, int col, int[][] matrix, int target){
        if(matrix[row][col]>target){
            return ;
        }
        if(matrix[row][col]==target){
            result=true;
            return ;
        }
        for(int i=row;i<matrix.length-1;i++){
            for(int j=col;j<matrix[i].length-1;j++){
                //向下
                backTrack(i+1,j,matrix,target);
                //向右
                backTrack(i,j+1,matrix,target);
            }
        }
    }

    //非递归法
    public void find(int row, int col, int[][] matrix, int target){
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target){
                result=true;
                return;
            }else if(matrix[row][col]>target){
                col--;
            }else{
                row++;
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.print(new Find_the_Number_of_the_Matrix().solution(matrix,66));
    }
}