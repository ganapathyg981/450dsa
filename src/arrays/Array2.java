package arrays;

public class Array2 {
    public static void main(String[] args) {
            int arr[]={4,23,234,54,24,43,2,4};
            returnMaxMin(arr);
    }
    static void returnMaxMin(int[] arr){
        int max= Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max)
                max=arr[i];
            if(arr[i]<min)
                min=arr[i];
        }
        System.out.println(max+" "+min);
    }

}
