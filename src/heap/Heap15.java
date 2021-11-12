package heap;

public class Heap15 {


   public static void main(String[] args) {
      long arr[] = {3 ,5 ,9 ,6, 8, 20, 10, 12 ,18 ,9};
      minHeapToMaxHeap(arr);
      for (long i:
           arr) {
         System.out.print(i+" ");
      }
   }
   public static void minHeapToMaxHeap(long[] arr) {
      for (int i = (arr.length/2)-1; i >=0 ; i--) {
         maxHeapify(arr,i,arr.length);
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
