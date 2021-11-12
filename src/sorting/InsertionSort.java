package sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int [] arr={3,5,1,22,45,5,3,34};
        sort(arr);
        print(arr);
    }
    static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0; j--) {
                    if(arr[i]<arr[j]){
                        swap(arr,i,j);
                        break;
            }
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
