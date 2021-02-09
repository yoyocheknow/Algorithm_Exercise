package common_algorithm;

/**
 * 正负数分离
 * 先用双指针法把 负数和非负数分离
 * 再遍历一遍，将非负数中的0 和正数分离
 * @author zhihua on 2021/2/9
 */
public class Positive_Negative_Separate {
    public void separate(int[] array){
        if(array.length<1){
            return ;
        }
        int left=0;
        int right=array.length-1;
        while(left<right){
            while(left<=right && array[left]<0){
                left++;
            }
            while(left<=right && array[right]>=0){
                right--;
            }
            if(left<right){
                int temp = array[left];
                array[left]=array[right];
                array[right]=temp;
            }

        }


        left=0;
        right=array.length-1;
        while(left<right){
            while(left<=right && array[left]<=0){
                left++;
            }
            while(left<=right && array[right]>0){
                right--;
            }
            if(left<right){
                int temp = array[left];
                array[left]=array[right];
                array[right]=temp;
            }

        }

    }

    public static void main(String[] args){
        int[]  array = new int[]{-1,-2,3,0,-2,-3,1,0,-2};
        new Positive_Negative_Separate().separate(array);
        for(int nums:array){
            System.out.print(nums +" ");
        }
    }

}