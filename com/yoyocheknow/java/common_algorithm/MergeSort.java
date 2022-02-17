package common_algorithm;

import java.util.Arrays;

public class MergeSort {
    public int[] sort(int[] array){
        int[] arr = Arrays.copyOf(array,array.length);
        if(arr.length<2){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        return merge(sort(left),sort(right));
    }
    public int[] merge(int[]left,int[] right){
        int[] result = new int[left.length+right.length];
        int leftIndex=0;
        int rightIndex=0;
        int index=0;
        while(leftIndex<left.length && rightIndex<right.length){
            if(left[leftIndex]<right[rightIndex]){
                result[index]=left[leftIndex];
                index++;
                leftIndex++;
            }
            else{
                result[index]=right[rightIndex];
                index++;
                rightIndex++;
            }
        }
        while(leftIndex<left.length){
            result[index]=left[leftIndex];
            index++;
            leftIndex++;
        }
        while(rightIndex<right.length){
            result[index]=right[rightIndex];
            index++;
            rightIndex++;
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = new MergeSort().sort(new int[]{3,2,6,1,5,4});
        for(int i:arr){
            System.out.print(i+ " ");
        }
    }
}
