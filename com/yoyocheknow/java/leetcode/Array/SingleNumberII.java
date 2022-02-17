package leetcode.Array;

public class SingleNumberII {
    /**
     * 大致思路是：因为是int类型数字，所以最多有32位
     * 把每个数字当作一个二进制数字，比如2，2，3，2，就是
     * 2 1 0 --》bitcount位记录每一位出现的次数
     * 1 0 0
     * 1 0 0
     * 1 1 0
     * 1 0 0
     * ------
     * 4 1 0
     * 说明 2这个位置 出现了4次，1这个位置出现了1次，对位置上的次数%3取余，就能得出最终的结果
     *
     * 只有一个数字出现一次，其他数字都出现了3次，那么也就是1%3=1，1<<1+4%3=11
     * */
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int[]bitCount = new int[32];
        for(int num:nums){
            for(int i=0;i<32;i++){
                // check if the i-th bit is set or not. If yes then we increment the bit Count at i-th bit by 1.
                int value = (num&(1<<i))==0?0:1;
                bitCount[i]=bitCount[i]+value;
            }
        }
        int ans = 0;
        for(int i = 0;i<32;i++){
            // we know that there's only one element which won't have three copies, so we can eliminate the bit count for all those with three copies by doing a mod with 3.
            ans+=(bitCount[i]%3)<<i; // bitCount[i]%3 will either be 0 or 1. If i-th bit is set, we derive the value by 1<<i.
        }
        return ans;

    }

    public static void main(String[] args){
        System.out.print(new SingleNumberII().singleNumber(new int[]{2,2,3,2}));
    }
}
