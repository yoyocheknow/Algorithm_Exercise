package common_algorithm;

/**
 * 二分查找
 * array 有序
 * @author zhihua on 2020/12/29
 */
public class BinarySearch {
    public int find(int[] array,int target){
        if(array.length<1){
            return -1;
        }
        return search(array,0,array.length-1,target);
    }
    public int search(int[] array,int left,int right,int target){

        int mid = (left+right)/2;
        while(left<=right){
            if(target==array[mid]){
                return mid;
            }
            if(array[mid] < target){
                return search(array,mid+1,right,target);
            }
            if(array[mid]>target){
                return search(array,left,mid-1,target);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5,6};
        System.out.print(new BinarySearch().find(array,0));
    }
}