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
        //存储各行的数字，map中key代表num，value代表此num出现的次数
        List<Map<Integer, Integer>> rowList = new ArrayList<>();
        //存储各列的数字
        List<Map<Integer, Integer>> colList = new ArrayList<>();
        //存储各个子box的数字
        List<Map<Integer, Integer>> boxList = new ArrayList<>();

        for(int i=0;i<board.length;i++){
            rowList.add(new HashMap<>());
            colList.add(new HashMap<>());
            boxList.add(new HashMap<>());
        }
        //先把board里面的数字初始化到各个list里面
        for(int i=0;i<board.length;i++){

            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    int num = board[i][j]-'0';
                    //根据i，j计算子方块的下标
                    int boxIndex = (i/3)*3+j/3;

                    rowList.get(i).putIfAbsent(num, 1);
                    colList.get(j).putIfAbsent(num, 1);
                    boxList.get(boxIndex).putIfAbsent(num, 1);
                }
            }
        }
        backTrack(0,0,board,rowList,colList,boxList);

    }

    public Boolean backTrack(int row,int col,char[][]board,
                          List<Map<Integer, Integer>> rowList,
                          List<Map<Integer, Integer>> colList,
                          List<Map<Integer, Integer>> boxList){
        //到结尾了，则返回true
        if(col==board[0].length){
            col=0;
            row++;
            if(row==board.length){
                return true;
            }
        }
        //需要装填数字的位置
        if(board[row][col]=='.'){
            //从1到9开始遍历回溯
            for(int i=1;i<10;i++){
                int boxIndex = (row/3)*3+col/3;
                //获取将要填写的数字，在各行、各列、各子块出现的次数，默认为0
                int rowCount = rowList.get(row).getOrDefault(i,0);
                int colCount = colList.get(col).getOrDefault(i,0);
                int boxCount = boxList.get(boxIndex).getOrDefault(i,0);
                //判断此数字是否可用
                boolean canUse = !(rowCount>0 || colCount>0||boxCount>0);
                if(canUse){
                    //如果可用，将使用次数更新在行、列、子块的统计当中
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
                    //填补此num到目前位置
                    board[row][col]=(char)(i+48);
                    //进行回溯，开始下一列
                    if(backTrack(row,col+1,board,rowList,colList,boxList)){
                        return true;
                    }
                    //回溯完后，重置此位置，将出现的次数-1
                    board[row][col]='.';
                    rowList.get(row).computeIfPresent(i,(k, v) -> v - 1);
                    colList.get(col).computeIfPresent(i,(k, v) -> v - 1);
                    boxList.get(boxIndex).computeIfPresent(i,(k, v) -> v - 1);
                }
            }
        }else{
            //不需要装填数字，则进行下一列
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