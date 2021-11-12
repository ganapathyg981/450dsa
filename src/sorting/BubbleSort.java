package sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr={3,5,1,22,45,5,3,34};
        sort(arr);
        print(arr);
    }
     static void sort(int[] arr){
        int endCard= arr.length-1;
        for (int i = 0; i < arr.length-1; i++,endCard--) {
            for (int j = 0; j < endCard; j++) {
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
            }
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
