package heap;

public class Heap {


    public static void main(String[] args) {
        int[] arr={1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        for (int i = (arr.length/2)-1; i >=0 ; i--) {
                maxHeapify(arr,i,arr.length);
        }
        for (int ele:
             arr) {
            System.out.print(ele+" ");
        }
        System.out.println();


        int [] arr1={3,1,6,5,2,4};
        for (int i = (arr1.length/2)-1; i >=0 ; i--) {
            minHeapify(arr1,i,arr1.length);
        }
        for (int ele:
                arr1) {
            System.out.print(ele+" ");
        }
    }


    static void maxHeapify(int [] arr,int i,int N){
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
    static void minHeapify(int [] arr,int i ,int N){
        int left=2*i+1;
        int right=2*i+2;
        int min=i;
        if(left<N&& arr[left]<arr[i])
            min=left;
        if(right<N&& arr[right]<arr[min])
            min=right;
        if(min!=i){
            swap(arr,i,min);
            minHeapify(arr,min,N);
        }
    }

    static void swap(int[] arr, int l, int r){
        int temp;
        temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
}
