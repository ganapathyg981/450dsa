package backtracking;
import stackandqueue.Stack;

public class BT20 {
    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("Top element is :" + s.peek());
        System.out.print("Elements present in stack :");
        s.print();
        System.out.println(s.isEmpty());
    }
}
