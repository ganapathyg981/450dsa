package string;

public class String7 {
    public static void main(String[] args) {
        System.out.println(countAndSay(10));
    }
    static String countAndSay(int i){
        if(i==1)
            return "1";
        else
            return say(countAndSay(i-1));
    }

    static String say(String input){
        StringBuilder stringBuilder=new StringBuilder();
        int count=1;
        char currentChar=input.charAt(0);
        for(int i=1;i<input.length();i++){
            if(input.charAt(i)==currentChar){
                count++;
            }
            else{
                stringBuilder.append(String.valueOf(count)+ currentChar);
                currentChar=input.charAt(i);
                count=1;
            }
        }
        stringBuilder.append(String.valueOf(count)+ currentChar);
        return stringBuilder.toString();
    }
}
