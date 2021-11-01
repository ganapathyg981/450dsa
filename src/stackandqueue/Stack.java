package stackandqueue;

public class Stack {
    int [] stack;
    int top;
    public Stack(int size){
        stack=new int[size];
        top=-1;
    }
    public void push(int val){
        if(top>=stack.length-1)
            System.out.println("Stack overflow");
        else
            stack[++top]=val;
    }
    public boolean isEmpty(){
        if(top==-1)
            return true;
        else
            return false;
    }
    public int pop(){
        if(top<0)
            return 0;
        else
        return stack[top--];
    }
    public int peek(){
        if(top<0)
            return 0;
            else
        return stack[top];
    }

    public void print() {
        for(int i = top;i>-1;i--){
            System.out.print(" "+ stack[i]);
        }
        System.out.println();
    }
}
