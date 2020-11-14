package leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 射击气球
 *
 * @author zhihua on 2020/11/14
 */
public class Minimum_Number_of_Arrows_to_Burst_Balloons {
    public static int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }
        Arrays.sort(points,new Comparator<int[]>() {
            public int compare(int[] a,int []b){
                return a[0]-b[0];
            }
        });

        for(int i=0;i<points.length;i++){
            System.out.println(Arrays.toString(points[i]));
        }

        int [] intsec = points[0];
        int result=1;
        for(int i=1;i<points.length;i++){
            //没有交集则新增弓箭手
            if(points[i][0]>intsec[1] || points[i][1]<intsec[0]){
                intsec=points[i];
                result++;
                continue;

            }
            //有交集，则更新交集
            intsec[0]=Math.max(points[i][0],intsec[0]);
            intsec[1]=Math.min(points[i][1],intsec[1]);

        }
        return result;
    }
    public static void main(String[] args){
        int [][]points =new int[][]{{10,16},{2,8},{1,6},{7,12},{11,12}};
        System.out.println(findMinArrowShots(points));
    }
}