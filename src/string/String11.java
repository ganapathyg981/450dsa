package string;

public class String11 {
    public static void main(String[] args) {
            String input="ABC";
            permute(input.toCharArray(),0,input.length()-1);
    }
    public static void permute(char[] array,int left, int right){
        if(left==right){
            System.out.println(String.valueOf(array));
            return;
        }
        else{
            for(int i=left;i<=right;i++){
                swap(array,left,i);
                permute(array,left+1,right);
                swap(array,left,i);
            }
        }
    }

    public static void swap(char[] arr,int l, int r){
        char temp;
        temp=arr[r];
        arr[r]=arr[l];
        arr[l]=temp;
    }
}
