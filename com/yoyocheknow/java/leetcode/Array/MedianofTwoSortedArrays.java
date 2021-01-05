package leetcode.Array;

/**
 * 求两个整数数组中间值
 *
 * @author zhihua on 2020/11/11
 */
public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int lp=0;
        int rp=0;
        int [] result = new int[length1+length2];
        int count =0;
        while(lp<length1 &&rp<length2){
            if(nums1[lp]<nums2[rp]){
                result[count]=nums1[lp];
                lp++;
            }else{
                result[count]=nums2[rp];
                rp++;
            }
            count++;
        }
        while(lp<length1){
            result[count]=nums1[lp];
            lp++;
            count++;
        }
        while(rp<length2){
            result[count]=nums2[rp];
            rp++;
            count++;
        }
        int mid = (length1+length2)%2;
        int realMid = (length1+length2)/2;
        if(mid==0){
            return ((double) result[realMid-1]+(double)result[realMid])/2;
        }else{
            return ((double) result[realMid]);
        }
    }
    public static void main(String[] args){
        int nums1[] = new int[]{0,0};
        int nums2[] = new int[]{0,0};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}