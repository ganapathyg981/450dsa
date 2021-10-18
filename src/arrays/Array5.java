package arrays;

public class Array5 {
    public static void main(String[] args) {
        int [] arr={-2,2,3,4,2,1,-2,8};
         negativePush(arr);
    }
    static int[] negativePush(int[] arr){
        int low=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0){
                swap(arr,i,low);
                low++;
            }
        }
        print(arr);

        return arr;
    }
    static void swap(int[] arr,int l,int r){
        int temp;
        temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
    static void print(int[]arr){
        for(int x:arr)
            System.out.print(x);
    }
}
