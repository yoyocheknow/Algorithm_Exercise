package leetcode.Array;

/**
 * 从有序数组中删除重复数字II
 * 重复数字最多出现两次
 * @author zhihua on 2021/2/3
 */
public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        if(nums.length<1){
            return 0;
        }

        int count=1;
        int repeat=1;
        for(int i=1;i<nums.length;i++){

            if(repeat<2 && nums[i-1]==nums[i]){
                nums[count] = nums[i];
                count++;
                repeat++;
            }
            else if(nums[i-1]==nums[i]){
                repeat++;
            }
            if(nums[i-1]!=nums[i]){
                nums[count] = nums[i];
                count++;
                repeat=1;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] array = new int[]{1,1,1,1,2,2,3};
        System.out.println(new Remove_Duplicates_from_Sorted_Array_II().removeDuplicates(array));
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}