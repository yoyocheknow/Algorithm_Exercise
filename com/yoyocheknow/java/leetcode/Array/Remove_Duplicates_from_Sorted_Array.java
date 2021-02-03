package leetcode.Array;

/**
 * 从有序数组中删除重复数字
 *
 * @author zhihua on 2021/2/3
 */
public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if(nums==null){
            return 0;
        }
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]!=nums[i]){
                nums[count]=nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(new Remove_Duplicates_from_Sorted_Array().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}