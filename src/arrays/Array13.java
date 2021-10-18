package arrays;

import java.util.HashSet;
import java.util.Set;

public class Array13 {
    public static void main(String[] args) {
        int [] a = {1,2,3,-2,5};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    private static int maxSubArraySum(int[] a) {
        int globalMax=Integer.MIN_VALUE;
        int localMax=0;
        for (int i = 0; i < a.length; i++) {
            localMax=localMax+a[i]>a[i]?localMax+a[i]:a[i];
            if(localMax>globalMax)
                globalMax=localMax;
        }
        return globalMax;
    }

}
