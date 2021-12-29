package stackandqueue;

public class InfixToPrefix {
    // Driver method
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        StringBuilder exprev= new StringBuilder(exp);
        exp=exprev.reverse().toString();
        System.out.println(new StringBuilder(infixToPostfix(exp)).reverse());
    }

    private static String infixToPostfix(String exp) {
        StringBuilder stringBuilder = new StringBuilder();
        java.util.Stack<Character> stack= new java.util.Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char current= exp.charAt(i);

            if(Character.isLetterOrDigit(current)){
                stringBuilder.append(current);
            }
            else if(current==')') {
                stack.push(current);
            }
            else if(current=='('){
                while(!stack.isEmpty()&&stack.peek()!=')'){
                    stringBuilder.append(stack.pop());
                }
                if(!stack.isEmpty())
                stack.pop();
            }
            else{
                while (!stack.isEmpty()&&getPrecedence(current)<getPrecedence(stack.peek())){
                    stringBuilder.append(stack.pop());
                }
                stack.push(current);
            }
        }
        while (!stack.isEmpty()){
            if(stack.peek()==')'){
                return "INVALID EXPRESSION";
            }
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    private static int getPrecedence(char code) {
        switch (code) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
