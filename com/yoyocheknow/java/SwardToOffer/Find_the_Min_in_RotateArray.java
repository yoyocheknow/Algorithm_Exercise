package SwardToOffer;

/**
 * 找到旋转数组的最小值
 * 此数组是不包含重复数字的。
 * 思路：
 * 二分查找。
 * 当nums[mid]>=nums[left],说明左边有序递增。最小值应该在后半段。将左指针右移到mid处。
 * 当nums[mid]<=nums[right],说明右边有序递增，最小值应该在前半段，将右指针左移至mid
 * 当nums[right]>=nums[left]，并且right-left=1 表示right所在位置即为最小值
 * @author zhihua on 2021/1/3
 */
public class Find_the_Min_in_RotateArray {
    public int find(int[] nums){
        if(nums.length<1){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        int mid = left;
        while(nums[left]>=nums[right]){
            if(right-left==1){
                return nums[right];
            }

            mid = (left+right)/2;
            if(nums[mid]>=nums[left]){
                left = mid;
            }else if(nums[mid]<=nums[right]){
                right = mid;
            }
        }
        return nums[mid];

    }

    public static void main(String[] args){
        System.out.println(new Find_the_Min_in_RotateArray().find(new int[]{3,4,5,1,2}));
    }
}