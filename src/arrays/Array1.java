package arrays;

public class Array1 {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        reverse(arr);
        print(arr,arr.length-1);
    }
    static void reverse(int[] arr){
        int temp;
        for(int start=0,end=arr.length-1;start<(arr.length-1)/2;start++,end--){
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
    }
    static void print(int[] arr,int size){
        for(int i=0;i<=size;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
