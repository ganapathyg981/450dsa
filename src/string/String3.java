package string;

public class String3 {
    public static void main(String[] args) {
        String input ="geeksforgeeks";
        printDuplicates(input);
    }
    static void printDuplicates(String input){
        int [] count= new int[256];
        for(int i=0;i<input.length();i++){
            count[input.charAt(i)]++;
        }
        for(int i=0;i<count.length;i++)
            if(count[i]>1)
            System.out.println((char)i+" "+count[i]);
    }
}
