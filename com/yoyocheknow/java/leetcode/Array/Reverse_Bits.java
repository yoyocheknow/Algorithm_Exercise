package leetcode.Array;

/**
 * 翻转bits
 * 比如n=1111 1101
 * 1, n&1=                1, n&1=                1,n&1 =
 *  1111 1101               1111 1110             1111 1111
 * &0000 0001              &0000 0001            &0000 0001
 * ==========              ==========           ===========
 *  0000 0001               0000 0000             0000 0001
 *                ---->                  ---->
 * 2,ans | n&1=          2, ans | n&1 =         2, ans | n&1 =
 *  0000 0001              0000 0010            0000 0101
 * 3,n>>=1               3,n>>=1                3,n>>=1
 * n=1111 1110            n=1111 1111           n=1111 1111
 * 4,ans<<=1             4,ans<<=1              4,ans<<=1
 * ans = 0000 0010       ans = 0000 0100        ans = 0000 1010
 * 从上面看出一顿操作后，完成了翻转的操作
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