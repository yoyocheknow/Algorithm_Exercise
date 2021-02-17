package leetcode.Array;

/**
 * 计算无符号二进制数字中1 的个数
 *
 * @author zhihua on 2021/2/17
 */
public class Number_of_1_Bits {
    public int hammingWeight(int n) {
        int count =0;
        for(int i=1;i<=32;i++){
            int ans = n&1;
            if(ans==1){
                count++;
            }
            n>>=1;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(new Number_of_1_Bits().hammingWeight(-3));
    }
}