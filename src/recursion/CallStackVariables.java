package recursion;

import java.util.Stack;

public class CallStackVariables {
    public static void main(String[] args) {
        Stack<Integer> stack= new Stack<>();
        for (int i = 1; i <=10 ; i++) {
         stack.push(i);
        }
        System.out.println(stack);
//        insertAtBottom(stack,44);
        reverse(stack);
        System.out.println(stack);
    }

    static  void insertAtBottom(Stack<Integer> stack, int i){
        if(stack.isEmpty()){
            stack.push(i);
        }
        else{
            System.out.println(stack);
            int data=stack.pop();
            insertAtBottom(stack,i);
            System.out.println(data);
            stack.push(data);
        }

    }

    static void reverse(Stack<Integer> stack){
        if(stack.size()>0){
            int data=stack.pop();
            reverse(stack);
            insertAtBottom(stack,data);
        }
    }


}
