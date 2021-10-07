package string;

public class String20 {
    public static String[] keypad={"2","22","222","3",
            "33","333","4","44","444"
            ,"5","55","555","6","66","666"
            ,"7","77","777","7777","8","88","888",
            "9","99","999","9999"};
    public static void main(String[] args) {
        System.out.println(printKeypad("gEEKS FOR GEEKS"));
    }

    public static String printKeypad(String input){
        int offset;
        StringBuilder stringBuilder= new StringBuilder();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==' ')
                stringBuilder.append('0');
            else{
                if(input.charAt(i)>96)
                    offset=97;
                else
                    offset=65;
                stringBuilder.append(keypad[input.charAt(i)-offset]);
            }

        }
        return stringBuilder.toString();
    }

}
