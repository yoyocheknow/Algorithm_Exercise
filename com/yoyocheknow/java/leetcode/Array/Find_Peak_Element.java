package leetcode.Array;

/**
 * 找到数组中 的一个山顶元素
 *
 * @author zhihua on 2021/2/1
 */
public class Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        if(nums.length<3){
            if(nums[0]<nums[1]) return 1;
            else return 0;
        }

        for(int i=0;i<nums.length;i++){
            if(i==0){
                if(nums[i]>nums[i+1]){
                    return i;
                }else continue;

            }
            else if(i==nums.length-1 && nums[i]>nums[i-1]){
                return i;
            }
            else if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(new Find_Peak_Element().findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}