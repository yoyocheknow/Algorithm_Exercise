package leetcode.BackTrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 单词搜索II
 *
 * @author zhihua on 2021/2/21
 */
public class Word_Search_II {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int row = board.length;
        if(row<1){
            return result;
        }
        int col = board[0].length;
        int [][]visit = new int[row][col];
        HashSet<String> found = new HashSet();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(String word:words){
                    if(board[i][j]==word.charAt(0) && backtrack(board,visit,i,j,word,0)){
                        found.add(word);
                    }
                }

            }
        }

        return new ArrayList<String>(found);

    }
    //这里为什么要返回boolean ，而不是用void返回类型？
    //因为在下面的backtrack时，有四个方向可以走，但是每次递归只能都其中一个方向。
    //如果是返回void，那么势必每次递归走4次，所以容易出现4 次targetIndex == word.length() 的情况
    public boolean backtrack(char[][] board, int [][]visit, int r, int c, String word,int targetIndex){

        if(targetIndex == word.length()){
            return true;
        }
        if(r<0 || r>=board.length || c<0 || c>=board[r].length || visit[r][c]==1){
            return false;
        }

        if(board[r][c] !=word.charAt(targetIndex)){
            return false;
        }


        visit[r][c] =1;
        boolean isExit = backtrack(board,visit,r-1,c,word,targetIndex+1)||
                backtrack(board,visit,r+1,c,word,targetIndex+1)||
                backtrack(board,visit,r,c-1,word,targetIndex+1)||
                backtrack(board,visit,r,c+1,word,targetIndex+1);

        visit[r][c] = 0;
        return isExit;
    }
    public static void main(String[] args){
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        String[] word = new String[] {"oath","pea","eat","rain"};
        new Word_Search_II().findWords(board,word).stream().forEach(System.out::println);
    }
}