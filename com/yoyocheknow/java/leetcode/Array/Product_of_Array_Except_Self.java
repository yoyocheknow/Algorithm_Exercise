package leetcode.Array;

/**
 * 求一个数组除自身元素的阶乘
 * 总体思想：设置两个数组L，R
 * 比如nums为 4，5，1，8，2 那么L，R如何得出呢？
 * L[0]=1,R[4]=1
 * L[1]=nums[0]*L[0] = 4;
 * L[2]=nums[1]*L[1] = 20;
 * L[3]=nums[2]*L[2] = 20;
 * L[4]=nums[3]*L[3] = 160;
 * 这样得出来的L[4],相当于是没有包含nums[4]的阶乘。
 * R[3]=nums[4]*R[4] = 2;
 * R[2]=nums[3]*R[3] = 16;
 * R[1]=nums[2]*R[2] = 16;
 * R[0]=nums[1]*R[1] = 80;
 * 最后得出来的R[0],相当于是没有包含nums[0]的阶乘。
 * 所以当L[i]*R[i]时，就是不包含nums[i]的阶乘。
 * @author zhihua on 2021/2/25
 */
public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        int[] result = new int[nums.length];
        L[0]=1;
        R[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            L[i] = nums[i-1]*L[i-1];
        }

        for(int i=nums.length-2;i>=0;i--){
            R[i] = nums[i+1]*R[i+1];
        }
        for(int i=0;i<nums.length;i++){
            result[i] = L[i]*R[i];
        }
        return result;
    }

    public static void main(String[] args){
        int [] result = new Product_of_Array_Except_Self().productExceptSelf(new int[]{4,5,1,8,2});
        for(int i:result){
            System.out.print(i+" ");
        }
    }
}