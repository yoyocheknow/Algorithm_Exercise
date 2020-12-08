package common_algorithm;

import java.util.Arrays;

/**
 * 快排
 *
 * @author zhihua on 2020/12/8
 */
public class QuickSort {
    public void quicksort(int[] array,int left,int right){
        if(left<right){
            int parti = partition(array,left,right);
            quicksort(array,left,parti-1);
            quicksort(array,parti+1,right);
        }
    }

    public int partition(int[] arr,int left,int right){
        //选取中轴元素
        int pivot = arr[left];
        int i = left + 1;
        int j = right;
        while (i<j) {
            // 向右找到第一个小于等于 pivot 的元素位置
            while (i <= j && arr[i] <= pivot) i++;
            // 向左找到第一个大于等于 pivot 的元素位置
            while(i <= j && arr[j] >= pivot ) j--;
            //交换两个元素的位置，使得左边的元素不大于pivot,右边的不小于pivot
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        arr[left] = arr[j];
        // 使中轴元素处于有序的位置
        arr[j] = pivot;
        return j;
    }

    public static void main(String[] args){
        int[] array = new int[]{8,1,3,9,4,5,4,7};
        new QuickSort().quicksort(array,0,array.length-1);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}