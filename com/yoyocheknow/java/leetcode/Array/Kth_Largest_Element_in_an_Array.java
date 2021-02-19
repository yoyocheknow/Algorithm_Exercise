package leetcode.Array;

/**
 * 寻找数组中第K大的数字
 *
 * @author zhihua on 2021/2/19
 */
public class Kth_Largest_Element_in_an_Array {
    /**
     * 思路：
     * 用一个K个大小的小顶堆，每次发现比堆顶元素大，就放进这个小顶堆，然后调整这个小顶堆。
     * 遍历一遍以后，这个小顶堆里面就是前K个最大的元素，堆顶就是第K大的元素。
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if(nums.length<1){
            return 0;
        }
        //初始化小顶堆
        int[] heapArray = new int[k];
        for(int i=0;i<k;i++){
            heapArray[i]=nums[i];
        }
        //调整为小顶堆
        for(int i=k-1;i>=0;i--){
            adjustHeap(i,k,heapArray);
        }

        for(int i=k;i<nums.length;i++){
            if(nums[i]>heapArray[0]){
                heapArray[0]=nums[i];
                adjustHeap(0,k,heapArray);

            }
        }
        return heapArray[0];
    }

    //调整小顶堆
    public void adjustHeap(int root,int size,int[] array){
        int left = leftChild(root);
        int right = rightChild(root);
        int smallest = root;

        if(hasLeft(root,size) && array[root]>array[left]){
            smallest = left;
        }

        if(hasRight(root,size) && array[smallest]>array[right]){
            smallest = right;
        }
        //如果当前节点不是最小，则交换
        if(smallest!=root){
            int temp = array[root];
            array[root] = array[smallest];
            array[smallest] = temp;
            adjustHeap(smallest,size,array);
        }
    }

    public int leftChild(int i){
        return i*2+1;
    }
    public int rightChild(int i){
        return i*2+2;
    }
    public Boolean hasLeft(int i,int size){
        return leftChild(i)<size;
    }
    public Boolean hasRight(int i,int size){
        return rightChild(i)<size;
    }

    public static void main(String[] args){
        System.out.println(new Kth_Largest_Element_in_an_Array().findKthLargest(new int[]{7,6,5,4,3,2,1},5));
    }
}