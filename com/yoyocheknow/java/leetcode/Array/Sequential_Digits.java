package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class Sequential_Digits {
    public List<Integer> sequentialDigits(int low, int high) {
        int minWei = weishu(low);
        int maxWei = weishu(high);
        return generateSequentialNum(minWei,maxWei,low,high);
    }
    //计算位数
    private int weishu(int num){
        int m = 0;
        while(num!=0){
            num=num/10;
            m++;
        }
        return m;
    }

    private List<Integer> generateSequentialNum(int minWei,int maxWei,int low,int high){
        //初始化位数，从最小位数开始
        int wei = minWei;
        List<Integer> result = new ArrayList();
        //初始化第一个数字的开头的值
        int start = (int) (low/Math.pow(10, wei-1));
        //结果中，连续数字的位数肯定是从最小位数到最大位数，所以根据位数遍历
        while( wei>=minWei && wei<=maxWei){
            //连续数字初始化为0
            int digits = 0;
            //因为要计算，所以位数要用一个临时变量
            int w = wei;
            //记录起始的数字，因为这个数字会累加
            int num = start;
            //生成连续的数字
            while(w>0 && num<10){
                digits += (int) (num*Math.pow(10, w-1));
                w--;
                num++;
            }
            //生产完连续数字后，这个起始位要+1，比如生成123后，start 要从1 变为2，开始计算234
            start++;
            //当这个起始数字超过10的时候，位数就要+1了，比如计算完6789，下一个就是 7 8 9 10了，这个num已经>=10了。
            //要从第5位 重新生成，5位数字的开始必然是1 ，所以start=1
            if(num>=10){
                wei++;
                start=1;
            }
            //符合预期的结果存入结果中，只有当w<=0也就是位数计算完了，并且num<=10才能作为结果，比如8900这种就不能作为结果
            if(digits<=high && digits>=low && num<=10 && w<=0){
                result.add(digits);
            }else if(digits>high){
                //位数使用完了，就结束了
                break;
            }

        }
        return result;
    }
    public static void main(String[] args){
        Sequential_Digits sequentialDigits = new Sequential_Digits();
        List<Integer> r = sequentialDigits.sequentialDigits(58,155);
        System.out.print(r);
    }
}
