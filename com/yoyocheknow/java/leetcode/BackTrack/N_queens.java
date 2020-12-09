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
            result.addAll(buildResult(temp));
            return;
        }
        for(int col=0;col<n;col++){
            if(isValid(row,col,queens)){
                for(int i=0;i<col;i++){
                    temp.get(row).add("*");
                }
                temp.get(row).add("Q");
                for(int j=0;j<n-col-1;j++){
                    temp.get(row).add("*");
                }
                queens.put(row,col);
                backTrack(result,temp,queens,row+1,n);
                queens.remove(row);
                temp.get(row).clear();

            }
        }
    }
    //复制结果list
    public List<List<String>> buildResult(List<List<String>> temp){
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<temp.size();i++){
            result.add(new ArrayList<>(temp.get(i)));
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
    public static void main(String[] args){
        List<List<String>> queens = new N_queens().solveNQueens(4);
        for(int i=0;i<queens.size();i++){
            for(int j=0;j<queens.get(i).size();j++){
                System.out.print(queens.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }
}