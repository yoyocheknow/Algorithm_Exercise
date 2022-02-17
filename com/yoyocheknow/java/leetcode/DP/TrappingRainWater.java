package leetcode.DP;

public class TrappingRainWater {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int ans=0;
        int leftMax=0;
        int rightMax=0;
        while (left<right){
            //左右指针，哪一个短，那么接雨水的逻辑就在那里计算。
            if(height[left]<height[right]){
                //当前要比左边最大的还要大的话，说明这里接不了雨水，更新leftMax，然后向右走
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }else{
                    //当前要比左边挨，而且右边还有比当前大的height[right],所以这里能接雨水。累加当前雨水量
                    ans+=leftMax-height[left];
                }
                left++;
            }else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }else{
                    ans+=rightMax-height[right];
                }
                right--;
            }
        }
        return ans;
    }
    public static void main(String[] args){

    }
}
