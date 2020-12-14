package SwardToOffer;

/**
 * 找到数组中重复的一个数字
 * 使用hash的话，时间复杂度和空间复杂度均为o(n)
 * n 个数字，而且数字范围在0～n-1，那么可以利用坐标来排除
 * 遍历整个数组，当发现num[i] 代表的值与 i位置的值一致时，说明找到了这样一个数字
 * 如果不一致，那么交换。直到最后。
 * @author zhihua on 2020/12/14
 */
public class Find_The_Repat_Number {
    public int solution(int[] nums){
        int target = -1;
        if(nums.length<1){
            return target;
        }
        for(int i=0;i<nums.length;i++){
            while(nums[i] !=i){
                if(nums[i] == nums[nums[i]]){
                    target = nums[i];
                    return target;
                }
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return target;
    }

    public static void main(String[]args){
        System.out.print(new Find_The_Repat_Number().solution(new int[]{2,3,1,0,2,5,3}));
    }
}