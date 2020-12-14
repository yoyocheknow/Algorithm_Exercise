package SwardToOffer;

/**
 * 找到数组中不重复的数字II（不修改数组）
 * n个数字，范围为1～n-1
 * 可以通过二分法的思想。
 * 比如数组长度为8，n范围为1～7，如果数组中数字范围为[1,4]的数字出现个数超过4，那么说明这个范围内有重复的数组
 * 然后继续二分查找这个数字。
 *
 * @author zhihua on 2020/12/14
 */
public class Find_The_Repat_Number_II {
    public int solution(int[] nums){
        int target = -1;
        if(nums.length<1){
            return target;
        }

        int start = 1;
        int end = nums.length-1;
        while (start<=end){
            int mid = ((end-start)>>1 )+start;
            int count = countNum(nums,start,mid);
            if(end==start){
                if(count>1){
                    return start;
                }
                else{
                    return -1;
                }
            }
            if(count>mid-start+1){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }

    public int countNum(int[] nums,int start,int end){
        if(nums.length<1){
            return 0;
        }
        int count =0 ;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=start && nums[i]<=end){
                count++;
            }
        }
        return count;
    }
    public static void main(String[]args){
        System.out.print(new Find_The_Repat_Number_II().solution(new int[]{2,3,1,4,6,5,3,6}));
    }
}