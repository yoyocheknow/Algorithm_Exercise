package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字的补码
 *
 * @author zhihua on 2020/11/29
 */
public class NumberComplement {
    public int findComplement(int num) {
        List<Integer> binaryList=new ArrayList<>();
        List<Integer> resultList=new ArrayList<>();
        while(num!=0){
            int diff = num%2;
            num=num/2;
            binaryList.add(diff);
        }
        int result=0;
        for(int i=binaryList.size()-1;i>=0;i--){
            if(binaryList.get(i)==0){
                resultList.add(1);
            }else if(binaryList.get(i)==1) {
                resultList.add(0);
            }
        }
        int flag=0;
        for(int i=resultList.size()-1;i>=0;i--){
            result+=resultList.get(i)*Math.pow(2,flag);
            flag++;
        }
        return result;
    }

    public static void main(String[] args){
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(numberComplement.findComplement(3));
    }
}