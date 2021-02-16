package leetcode.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 判断一个数字是否是快乐数字
 *
 * @author zhihua on 2021/2/16
 */
public class Happy_Number {
    public boolean isHappy(int n) {

        Set<Integer> visit = new HashSet();

        while (!visit.contains(n)){
           visit.add(n);
           n = sumOfSquares(n);
           if(n==1){
               return true;
           }
       }
       return false;

    }
    public int sumOfSquares(int n){
        int sum=0;
        while(n>0){
            int num = n%10;
            sum+=num*num;
            n = (n-num)/10;
        }

        return sum;
    }
    public static void main(String[] args){
        System.out.println(new Happy_Number().isHappy(19));
    }
}