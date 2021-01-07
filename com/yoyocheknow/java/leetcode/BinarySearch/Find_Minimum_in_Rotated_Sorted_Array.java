package leetcode.BinarySearch;

/**
 * 找到旋转数组中的最小值
 *
 * @author zhihua on 2021/1/7
 */
public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public int findMin1(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(mid-1>=0 && mid+1<nums.length && nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            else if(mid==0 && nums[mid]<nums[mid+1] ){
                return nums[mid];
            }
            else if (mid==nums.length-1 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }

            if(nums[left]<=nums[mid] && nums[left]>nums[right]){
                //此部分有序,去右边找找吧
                left = mid+1;
            }
            else if(nums[left]>nums[mid]){
                //min在这部分
                right = mid-1;
            }
            else if(nums[right]>=nums[mid]){
                //此部分有序,去左边找找吧
                right = mid-1;
            }
            else{
                //min在这部分
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.print(new Find_Minimum_in_Rotated_Sorted_Array().findMin(new int[]{3,4,5,1,2}));
    }
}