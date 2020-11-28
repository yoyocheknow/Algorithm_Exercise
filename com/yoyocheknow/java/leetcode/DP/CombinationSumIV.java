package leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和之组合IV
 *
 * @author zhihua on 2020/11/28
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
//        List<List<Integer>> result=new ArrayList<>();
//        Arrays.sort(nums);
//        backTrack(nums,target,result,new ArrayList<>(),0);
//        return result.size();
        return dp(nums,target);
    }
    /**
     * 回溯法,可以把子结果求出来
     * 但是容易超时
     */
    public void backTrack(int[] nums, int target, List<List<Integer>> result,List<Integer>temp,int sum){
        if(sum==target){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>target){
                break;
            }
            temp.add(nums[i]);
            backTrack(nums,target,result,temp,sum+nums[i]);
            temp.remove(temp.size()-1);
        }
    }

    /**
     * 动态规划
     * 类似换零钱问题
     * 给一个目标金额，看这些钱中有多少种组合。比如nums [1,2,3] target=4
     * 目标是4块钱，则可以有4-3，4-2，4-1 子目标值获得。
     * dp[4] = dp[4-nums[0]]+dp[4-nums[1]]+dp[4-num2[2]]
     */
    public int dp(int[] nums, int target){
        Arrays.sort(nums);
        int[] dp =new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target ;i++){
            for(int j=0;j<nums.length && nums[j]<=i;j++){
                dp[i]+= dp[i-nums[j]];
            }
        }

        return dp[target];
    }

    public static void main(String[] args){
        CombinationSumIV combinationSumIV = new CombinationSumIV();
        int[] array = new int[]{1,2,3};
        int target = 4;

        System.out.print(combinationSumIV.combinationSum4(array,target));


    }
}