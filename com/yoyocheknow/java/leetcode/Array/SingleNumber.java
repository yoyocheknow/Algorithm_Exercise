package leetcode.Array;

import java.util.Arrays;

public class SingleNumber {
    //使用异或，如果有两个相同的则异或为0 ，最后剩下的值就是只存在一个
    public int singleNumber(int[] nums) {
        int a=0;
        for(int i:nums){
            a ^=i;
        }
        return a;
    }

    public static void main(String[] args){
        System.out.print(new SingleNumber().singleNumber(new int[]{4,1,2,1,2}));
    }

}
