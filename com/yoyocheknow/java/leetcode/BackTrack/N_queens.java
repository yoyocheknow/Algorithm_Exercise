package leetcode.BackTrack;

import java.util.*;

/**
 * N 皇后问题
 *
 * @author zhihua on 2020/12/9
 */
public class N_queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<List<String>> temp = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<String> rowTemp = new ArrayList<>();
            temp.add(rowTemp);
        }
        Map<Integer, Integer> queens=new HashMap<>();
        backTrack(result,temp,queens,0,n);
        return result;
    }

    public void backTrack(List<List<String>> result,List<List<String>> temp ,Map<Integer, Integer> queens,int row,int n){
        if(row==n){
            result.add(buildResult(temp));
            return;
        }
        for(int col=0;col<n;col++){
            if(isValid(row,col,queens)){
                for(int i=0;i<col;i++){
                    temp.get(row).add(".");
                }
                temp.get(row).add("Q");
                for(int j=0;j<n-col-1;j++){
                    temp.get(row).add(".");
                }
                queens.put(row,col);
                backTrack(result,temp,queens,row+1,n);
                queens.remove(row);
                temp.get(row).clear();

            }
        }
    }
    //复制结果list
    public List<String> buildResult(List<List<String>> temp){
        List<String> result=new ArrayList<>();


        for(int i=0;i<temp.size();i++){
            StringBuilder row =new StringBuilder();
            for(int j=0;j<temp.get(i).size();j++){
                row.append(temp.get(i).get(j));
            }
            result.add(row.toString());
        }
        return result;
    }

    public Boolean isValid(int row,int col,Map<Integer, Integer> queens){

        for (Integer key : queens.keySet()) {
            if(row==key || col == queens.get(key) || row+col==key+queens.get(key)|| row-col == key-queens.get(key)){
                return false;
            }
        }

        return true;
    }


    public List<List<String>> solveNQueens1(int n) {
        List<List<String>> result = new ArrayList();
        boolean[][] locate= new boolean[n][n];
        backtrack1(result,locate,new ArrayList<>(),n,0);
        return result;
    }

    private void backtrack1(List<List<String>> result,boolean[][] locate,List<String> temp,int n, int row){
        if(row==n){
            makeResult(locate,temp,n);
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int k=0;k<n;k++){
            if(isAttack(locate,n,row,k)){
                locate[row][k]=true;
                backtrack1(result,locate,temp,n,row+1);
                locate[row][k]=false;
            }
        }
    }

    private void makeResult(boolean[][] locate,List<String> temp,int n){
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(locate[i][j]){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            temp.add(sb.toString());
        }
    }
    private boolean isAttack(boolean[][] locate,int n,int x,int y){
        int row =0;
        int col =0;
        //从上倒下
        while(row>=0 && row <n){

            if(locate[row][y] && row!=x ||( locate[row][row+1])){
                return false;
            }else{
                row++;
            }
        }
        //从左到右
        while(col>=0 && col <n){
            if(locate[x][col] && col!=y||( locate[n-col][col])){
                return false;
            }else{
                col++;
            }
        }
        return true;
    }
    public static void main(String[] args){
        List<List<String>> queens = new N_queens().solveNQueens1(4);
        for(int i=0;i<queens.size();i++){
            for(int j=0;j<queens.get(i).size();j++){
                System.out.print(queens.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }
}