package arrays;

import java.util.Arrays;

public class Array35 {
    public static void main(String[] args) {
            int[] arr={90,100,78,89,67};
            int[] arr1={56,67,30,79};
        System.out.println(findMedian(arr));
        System.out.println(findMedian(arr1));
    }
    static  int findMedian(int[] inputs){
        Arrays.sort(inputs);
        if(inputs.length%2==0){
            return (inputs[inputs.length/2]+inputs[(inputs.length/2)-1])/2;
        }
        else{
            return inputs[inputs.length/2];
        }
    }
}
