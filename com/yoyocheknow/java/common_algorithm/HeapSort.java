package common_algorithm;

/**
 * 堆排序
 *
 * @author zhihua on 2020/12/16
 */
public class HeapSort {
    int[] array;
    public HeapSort(int[] array){
        this.array=array;
    }
    public int[] solution(){
        //创建大顶堆
        creatHeap();
        //将大顶堆的第一个元素换到末尾，然后调整剩余的数组为大顶堆
        //这样每次调整下来，最大元素依次排到末尾，就完成了堆排序
        deletion();
        return array;
    }

    public void creatHeap(){
        for(int i=array.length-1;i>=0;i--){
            adjustHeap(i,array.length);
        }
    }
    //调整大顶堆
    public void adjustHeap(int root,int size){
        int left = leftChild(root);
        int right = rightChild(root);
        int largest = root;

        if(hasLeft(root,size) && array[root]<array[left]){
            largest = left;
        }

        if(hasRight(root,size) && array[largest]<array[right]){
            largest = right;
        }
        //如果当前节点不是最大，则交换
        if(largest!=root){
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;
            adjustHeap(largest,size);
        }
    }

    public void deletion(){

        for(int i=array.length-1;i>=1;i--){
            //将maxHeap的顶端放到结果数组的末尾。即排序。
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            //这里要从顶部开始堆排序
            adjustHeap(0,i);
        }
    }

    public int Father(int i){
        return (i-1)/2;
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
        int[]array = new int[]{10,20,15,30,40};

        int [] result = new HeapSort(array).solution();
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}