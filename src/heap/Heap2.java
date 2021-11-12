package heap;

public class Heap2 {


    public static void main(String[] args) {
        long arr[] = { 1, 18, 16, 17, 6, 15, 2, 13, 11, 9};
        heapSort(arr);
    }

    static void heapSort(long arr[]){
        for (int i = (arr.length/2)-1; i >=0 ; i--) {
            maxHeapify(arr,i,arr.length);
        }

        for(int i=arr.length-1;i>=0;i--){
            swap(arr,0,i);
            maxHeapify(arr,0,i);
        }

        for (long ele: arr) {
            System.out.print(ele+" ");
        }
    }

    static void maxHeapify(long [] arr,int i,int N){
        int left=2*i+1;
        int right=2*i+2;
        int max=i;
        if(left<N&& arr[left]>arr[i])
            max=left;
        if(right<N&& arr[right]>arr[max])
            max=right;
        if(max!=i){
            swap(arr,i,max);
            maxHeapify(arr,max,N);
        }
    }
    static void swap(long[] arr, int l, int r){
        long temp;
        temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
}
