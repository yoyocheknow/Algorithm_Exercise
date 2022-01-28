package leetcode.BinarySearch;

/**
 * 搜索旋转有序数组中的值
 *
 * @author zhihua on 2020/12/29
 */
public class Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }

            //左半边有序
            if(nums[mid]>=nums[left] ){
                //left<=target<mid 时，在左半边二分查找，否则去右半边
                if(nums[left]<=target && target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            //右半边有序
            else{
                //mid<=target<right 时，在右半边二分查找，否则去左半边
                if(nums[mid]<target && target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }


    //此方法是o(n)的时间复杂度。不建议使用
    public int search1(int[] nums, int target) {
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


    public static void main(String[] args){
        System.out.print(new Search_in_Rotated_Sorted_Array().search(new int[]{5,1,3},3));
    }
}