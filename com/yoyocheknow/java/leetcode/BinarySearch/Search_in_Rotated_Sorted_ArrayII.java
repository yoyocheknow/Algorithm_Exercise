package leetcode.BinarySearch;

/**
 * 搜索旋转数组中的target值II
 *
 * @author zhihua on 2021/1/2
 */
public class Search_in_Rotated_Sorted_ArrayII {
    public boolean search(int[] nums, int target) {
        if(nums.length<1){
            return false;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return true;
            }
            //如果左边界或者右边界等于mid，说明有重复的，进行过滤
            else if(nums[mid] == nums[right]){
                right--;
            }
            else if(nums[mid] == nums[left]){
                left++;
            }
            //左边有序
            else if(nums[left]<nums[mid]){
                if(nums[left]<=target && target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            //右边有序
            else{
                if(nums[mid]<target && target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.print(new Search_in_Rotated_Sorted_ArrayII().search(new int[]{1,3,5},5));
    }
}