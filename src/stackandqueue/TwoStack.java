package stackandqueue;

public class TwoStack {
    int [] stack;
    int top1;
    int top2;
    public TwoStack(int size){
        stack=new int[size];
        top1=0;
        top2=size-1;
    }
    public void push1(int val){
        if(top1>=stack.length/2-1)
            System.out.println("Stack overflow");
        else
            stack[++top1]=val;
    }
    public boolean isEmpty1(){
        if(top1==0)
            return true;
        else
            return false;
    }
    public int pop1(){
        if(top1<=0)
            return -1;
        else
            return stack[top1--];
    }
    public int peek1(){
        if(top1<=0)
            return -1;
        else
            return stack[top1];
    }
    public void push2(int val){
        if(top2<stack.length/2-1)
            System.out.println("Stack overflow");
        else
            stack[--top2]=val;
    }
    public boolean isEmpty2(){
        if(top2==stack.length-1)
            return true;
        else
            return false;
    }
    public int pop2(){
        if(top2>=stack.length-1)
            return -1;
        else
            return stack[top2++];
    }
    public int peek2(){
        if(top2>=stack.length-1)
            return -1;
        else
            return stack[top2];
    }

}
