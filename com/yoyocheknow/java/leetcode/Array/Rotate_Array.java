package leetcode.Array;

/**
 * 旋转数组
 *
 * @author zhihua on 2021/2/10
 */
public class Rotate_Array {
    /**
     * 翻转法：步骤如下：
     * 1 第一次翻转所有元素
     * 2 第二次翻转前k个元素
     * 3 第三次翻转后面n-k个元素
     * Original List                   : 1 2 3 4 5 6 7
     * After reversing all numbers     : 7 6 5 4 3 2 1
     * After reversing first k numbers : 5 6 7 4 3 2 1
     * After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
     */
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }
    public void reverse(int[] nums,int start,int end){
        while (start<end ) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 循环替换法
     * 每次元素都替换下一个距离k的元素，
     * 直到又替换到当前位置为止。
     * 比如 1替换到3，3替换到5，5替换到1。然后此次循环停止
     *
     */
    public void rotate1(int[] nums,int k){
        k = k% nums.length;
        int count = 0;
        for(int i=0;count<nums.length;i++){
            int current = i;
            int prev = nums[i];
            do{
                int next = (i+k)%nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                i = next;
                count++;
            }while (i!=current);
        }
    }
    public static void main(String[] args){
        int[] nums=new int[]{1,2,3,4,5,6,7};
        new Rotate_Array().rotate1(nums,2);
        for(int num:nums){
            System.out.print(num+" ");
        }
    }
}