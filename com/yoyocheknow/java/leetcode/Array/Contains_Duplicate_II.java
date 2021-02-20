package leetcode.Array;

/**
 * 是否包含重复项II
 *  给定一个数组，和一个整数k，看看数组中重复的两个数字的下标i,j是否满足｜j-i｜<=k
 * @author zhihua on 2021/2/20
 */
public class Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<1){
            return false;
        }
        int left=0;

        while (left<nums.length-1){
            for(int i=left+1;i<=left+k && i< nums.length;i++){
                if(nums[left]==nums[i]){
                    return true;
                }
            }
            left++;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(new Contains_Duplicate_II().containsNearbyDuplicate(new int[]{1,1},3));
    }
}