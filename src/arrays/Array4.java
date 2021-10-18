package arrays;

public class Array4 {
    public static void main(String[] args) {
            int[] input={1,2,0,2,2,1,0,1,2,0,0};
            print(sort(input));
    }
    static  int[] sort(int[] arr){
        int low=0;
        int mid=0;
        int high=arr.length-1;
        for(;mid<=high;){
            if(arr[mid]==0){
                    swap(arr,low,mid);
                    low++;
                    mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                swap(arr,high,mid);
                high--;
            }
        }
        return arr;
    }
    static void print(int[]arr){
        for(int x:arr)
            System.out.print(x);
    }
    static void swap(int[] arr,int l,int r){
        int temp;
        temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
}
