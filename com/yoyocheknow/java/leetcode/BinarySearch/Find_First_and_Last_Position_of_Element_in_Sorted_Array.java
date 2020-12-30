package leetcode.BinarySearch;


/**
 * 找到有序数组中某个数字的初始位置和结束位置
 *
 * @author zhihua on 2020/12/30
 */
public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        if(nums.length<1){
            return new int[]{-1,-1};
        }
        int left =0;
        int right = nums.length-1;
        boolean findFlag=false;
        while(left<=right && !findFlag){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                //一旦找到，则标志为设为true，防止重复二分查找
                findFlag = true;
                first=mid;
                last = mid;

                while(first>=0 && nums[first]==target){
                    first --;
                }
                //修正first，因为每次first多减了一次1 才触及到边界
                first++;
                while(last<=nums.length-1 && nums[last]==target){
                    last ++;
                }
                last --;
            }
            else if(target<nums[mid]){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return new int[]{first,last};
    }
    public static void main(String[] args){
        int [] result = new Find_First_and_Last_Position_of_Element_in_Sorted_Array().searchRange(new int[]{1},1);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        //Arrays.asList(result).stream().forEach(System.out::print);

    }
}