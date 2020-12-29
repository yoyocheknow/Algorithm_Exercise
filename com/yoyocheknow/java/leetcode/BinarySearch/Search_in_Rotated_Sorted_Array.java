package leetcode.BinarySearch;

/**
 * 搜索旋转有序数组中的值
 *
 * @author zhihua on 2020/12/29
 */
public class Search_in_Rotated_Sorted_Array {
    //此方法是o(n)的时间复杂度。不建议使用
    public int search(int[] nums, int target) {
        //先找到旋转点的idnex值
        int index = findPivotIndex(nums);
        //以index值为中心，分成两半，各自做二分查找
        int result1 = find(nums,0,index-1,target);
        int result2 = find(nums,index,nums.length-1,target);
        if(result1!=-1){
            return result1;
        }else{
            return result2;
        }
    }

    public int find(int[]nums,int left,int right,int target){

        while(left<=right){
            int mid = (left+right)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(target<nums[mid]){
                return find(nums,left,mid-1,target);
            }
            if(target>nums[mid]){
                return find(nums,mid+1,right,target);
            }
        }
        return -1;
    }
    public int findPivotIndex(int[] nums){
        if(nums.length==1){
            return 0;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                return i;
            }
        }
        return 0;
    }


    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                //target<nums[mid]则应该去左半边
                //如果mid大于左边说明左半边有序
                if(nums[mid]>nums[left]){
                    right = mid-1;

                }
                //否则的话去右半边
                else{
                    left = mid+1;
                }
            }
            if(nums[mid]<target){
                if(nums[mid+1]<nums[right]){
                    left = mid+1;
                }
                else{

                }
            }
        }
    }

    public static void main(String[] args){
        System.out.print(new Search_in_Rotated_Sorted_Array().search(new int[]{4,5,6,7,0,1,2},0));
    }
}