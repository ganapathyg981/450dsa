package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr={3,5,1,22,45,5,3,34};
        sort(arr);
        print(arr);
    }
    static void sort(int[] arr){
        int minIndex;
        for (int i = 0; i < arr.length-1; i++) {
            minIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            swap(arr,i,minIndex);
        }
    }
    static void swap(int[] arr, int l, int r){
        int temp;
        temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
    static void print(int[]arr){
        for(int x:arr)
            System.out.print(x+" ");
    }
}
