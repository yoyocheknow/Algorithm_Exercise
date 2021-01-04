package SwardToOffer;

/**
 * 矩阵中的路径
 * 给一个矩阵，和一个字符串，判断此矩阵中是否有一条路径可以组成此字符串
 * 走路径时，可以向上，下，左，右，但是不能走重复路径
 * @author zhihua on 2021/1/3
 */
public class Find_the_Path_in_Matrix {
    private boolean result=false;
    public boolean pathExist(char[][] matrix,String chars){
        if(matrix.length<1 || chars.length()<1){
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        //二维boolean数组保存是否走过此路径
        boolean [][] pathPassed = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                pathPassed[i][j]=false;
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(backTrack(matrix,pathPassed,i,j,chars,0)){
                    return true;
                }
            }
        }

        return false;

    }

    public boolean backTrack(char[][] matrix,boolean[][]pathPassed,int row,int col,String chars,int index){

        if(index==chars.length()){
            return true;
        }
        boolean hasPath = false;
        if(row>=0 && col>=0 && row<matrix.length && col<matrix[row].length && !pathPassed[row][col] && matrix[row][col]==chars.charAt(index))
        {
            //向下
            pathPassed[row][col] = true;
            hasPath = backTrack(matrix,pathPassed,row+1,col,chars,index+1)||
                  backTrack(matrix,pathPassed,row-1,col,chars,index+1)||
                  backTrack(matrix,pathPassed,row,col-1,chars,index+1)||
                  backTrack(matrix,pathPassed,row,col+1,chars,index+1);

            if(!hasPath){
                pathPassed[row][col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args){
        char[][] matrix = new char[][]{
                {'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}};
        System.out.println(new Find_the_Path_in_Matrix().pathExist(matrix,"bfce"));
    }
}