package sorting;

public class Tryout {

    public static void main(String[] args) {
        int [] arr={3,5,1,22,45,5,3,34};
        BubbleSort.sort(arr);
        print(arr);
    }

    static void print(int[]arr){
        for(int x:arr)
            System.out.print(x+" ");
    }
}
