package leetcode.BackTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数独
 *
 * @author zhihua on 2020/11/25
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        List<Map<Integer, Integer>> rowList = new ArrayList<>();
        List<Map<Integer, Integer>> colList = new ArrayList<>();
        List<Map<Integer, Integer>> boxList = new ArrayList<>();

        for(int i=0;i<board.length;i++){
            rowList.add(new HashMap<>());
            colList.add(new HashMap<>());
            boxList.add(new HashMap<>());
        }

        for(int i=0;i<board.length;i++){

            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    int num = board[i][j]-'0';

                    int boxIndex = (i/3)*3+j/3;

                    rowList.get(i).computeIfAbsent(num,k->1);
                    colList.get(j).computeIfAbsent(num,k->1);
                    boxList.get(boxIndex).computeIfAbsent(num,k->1);
                }
            }
        }
        backTrack(0,0,board,rowList,colList,boxList);

    }

    public Boolean backTrack(int row,int col,char[][]board,
                          List<Map<Integer, Integer>> rowList,
                          List<Map<Integer, Integer>> colList,
                          List<Map<Integer, Integer>> boxList){
        if(col==board[0].length){
            col=0;
            row++;
            if(row==board.length){
                return true;
            }
        }

        if(board[row][col]=='.'){
            for(int i=1;i<10;i++){
                int boxIndex = (row/3)*3+col/3;
                int rowCount = rowList.get(row).getOrDefault(i,0);
                int colCount = colList.get(col).getOrDefault(i,0);
                int boxCount = boxList.get(boxIndex).getOrDefault(i,0);
                boolean canUse = !(rowCount>0 || colCount>0||boxCount>0);
                if(canUse){
                    if(rowList.get(row).get(i)==null){
                        rowList.get(row).put(i,1);
                    }else{
                        rowList.get(row).computeIfPresent(i,(k, v) -> v + 1);
                    }

                    if(colList.get(col).get(i)==null){
                        colList.get(col).put(i,1);
                    }else{
                        colList.get(col).computeIfPresent(i,(k, v) -> v + 1);
                    }

                    if(boxList.get(boxIndex).get(i)==null){
                        boxList.get(boxIndex).put(i,1);
                    }else{
                        boxList.get(boxIndex).computeIfPresent(i,(k, v) -> v + 1);
                    }

                    board[row][col]=(char)(i+48);

                    if(backTrack(row,col+1,board,rowList,colList,boxList)){
                        return true;
                    }

                    board[row][col]='.';
                    rowList.get(row).computeIfPresent(i,(k, v) -> v - 1);
                    colList.get(col).computeIfPresent(i,(k, v) -> v - 1);
                    boxList.get(boxIndex).computeIfPresent(i,(k, v) -> v - 1);
                }
            }
        }else{
            return backTrack(row,col+1,board,rowList,colList,boxList);
        }

        return false;
    }

    public static void main(String args[]){
        char[][] board=new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver ss =new SudokuSolver();
        ss.solveSudoku(board);
        for(int i=0;i<board.length;i++){
            System.out.println(board[i]);
        }


    }
}