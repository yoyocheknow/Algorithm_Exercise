package SwardToOffer;

/**
 * 找到旋转数组的最小值II
 * 此螺旋数组可能包含重复值。比如[1,0,1,1,1] ,[1,1,1,0,1]
 * 此时不能按照上一条思路。因为nums[left],nums[mid],nums[right] ,都是1 ，无法得知那个是处于递增序列
 * 此时只能挨个比较
 * @author zhihua on 2021/1/3
 */
public class Find_the_Min_in_RotateArray_II {
    public int find(int[] nums){
        if(nums.length<1){
            return -1;
        }

        int left =0;
        int right = nums.length-1;
        int mid =left;
        while(nums[left]>=nums[right]){
            if(right-left==1){
                return nums[right];
            }

            mid = (left+right)/2;
            if(nums[mid]==nums[right]){
                right--;
            }else if(nums[mid]==nums[left]){
                left++;
            }else if(nums[mid]>=nums[left]){
                left=mid;
            }else if(nums[mid]<=nums[right]){
                right=mid;
            }
        }
        return nums[mid];
    }

    public static void main(String[] args){
        System.out.println(new Find_the_Min_in_RotateArray_II().find(new int[]{3,4,5,1,2}));
    }
}