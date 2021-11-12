package heap;

public class Heap4 {

    public static void main(String[] args) {
        int arr[] = { 1, 18, 16, 17, 6, 15, 2, 13, 11, 9};
        for (int x:
             kLargest(arr,arr.length,5)) {
            System.out.print(x+" ");
        }
    }
    static int[] kLargest(int[] arr, int n, int k) {
        int[] out = new int[k];
        for (int i = (arr.length/2)-1; i >=0 ; i--) {
            maxHeapify(arr,i,arr.length);
        }
        for(int i=arr.length-1,j=0;i>=0&&j<k;i--,j++){
            out[j]=arr[0];
            swap(arr,0,i);
            maxHeapify(arr,0,i);
        }
        return out;
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
    static void swap(int[] arr, int l, int r){
        int temp;
        temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
}
