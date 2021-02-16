package leetcode.Array;

/**
 * 翻转bits
 *
 * @author zhihua on 2021/2/16
 */
public class Reverse_Bits {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans = ans | (n & 1);
            n >>= 1;
        }
        return ans;
    }


    public static void main(String[] args){
        int n = -3;
        System.out.print(new Reverse_Bits().reverseBits(n));

    }
}