package arrays;

import java.util.HashSet;
import java.util.Set;

public class Array6 {
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5};
        int arr2[]={1,2,3};
        System.out.println(union(arr1,arr2));

    }
    static int union(int[] arr1,int[] arr2){
       Set<Integer> s= new HashSet();
       for(int x:arr1){
           s.add(x);
       }
        for(int x:arr2){
            s.add(x);
        }
        return s.size();
    }
}
