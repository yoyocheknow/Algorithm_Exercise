package leetcode.BackTrack;

import java.util.*;

/**
 * 岛屿的数量
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 * @author zhihua on 2021/2/17
 */
class Point{
    int x, y;
    Point(int r, int c) {
        x = r;
        y = c;
    }

    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null)
            return false;
        if(o.getClass() == this.getClass()) {
            Point p1 = (Point)o;
            return this.x == p1.x && this.y == p1.y;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(x,y);
    }
}
public class Number_of_Islands {
    Set<Point> visit = new HashSet<>();
    public int numIslands(char[][] grid) {
        if(grid.length<1 || grid[0].length<1){
            return 0;
        }
        int islands = 0;

        int row = grid.length;
        int col = grid[0].length;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                Point point = new Point(r, c);
                if(grid[r][c]=='1' && !this.visit.contains(point)){
                    islands++;
                    dfs(grid,point);
                }
            }
        }
       return islands;

    }

    public void dfs(char[][] grid,Point p){
        if(isValid(p.x-1, p.y, grid)) {
            Point p1 = new Point(p.x-1,p.y);
            if(!visit.contains(p1)) {
                visit.add(p1);
                dfs(grid,p1);
            }
        }
        if(isValid(p.x+1, p.y, grid)) {
            Point p1 = new Point(p.x+1,p.y);
            if(!visit.contains(p1)) {
                visit.add(p1);
                dfs(grid,p1);
            }
        }
        if(isValid(p.x, p.y+1, grid)) {
            Point p1 = new Point(p.x,p.y+1);
            if(!visit.contains(p1)) {
                visit.add(p1);
                dfs(grid,p1);
            }
        }
        if(isValid(p.x, p.y-1, grid)) {
            Point p1 = new Point(p.x,p.y-1);
            if(!visit.contains(p1)) {
                visit.add(p1);
                dfs(grid,p1);
            }
        }
    }

    boolean isValid(int x, int y, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return x < m && x >= 0 && y >= 0 && y < n && grid[x][y] == '1';
    }

    public static void main(String[] args){
        char[][] grid=new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(new Number_of_Islands().numIslands(grid));
    }

}