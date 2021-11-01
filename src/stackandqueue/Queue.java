package stackandqueue;

public class Queue {
    int [] stack;
    int front;
    int rear;
    int capacity;
    public Queue(int size){
        capacity=size;
        stack=new int[size];
        rear=-1;
        front=-1;
    }
    public void enqueue(int val){
        if(front==-1)
            front=0;
        if(rear>=stack.length-1)
            System.out.println("Stack overflow");
        else
            stack[++rear]=val;
    }
    public boolean isEmpty(){
        if(rear==-1)
            return true;
        else
            return false;
    }
    public int dequeue(){
        if(front<0)
            return 0;
        else
            return stack[front++];
    }
    public int peek(){
        if(front<0)
            return 0;
        else
            return stack[front];
    }

    public void print() {
        if(front==-1) {
            System.out.println("Queue empty");
            return;
        }
        for(int i = front;i<=rear;i++){
            System.out.print(" "+ stack[i]);
        }
        System.out.println();
    }
}
