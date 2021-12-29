package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Interleave {
    public static void main(String[] args) {
        Queue<Integer> queue= new LinkedList<>();

        for(int i=11;i<=20;i++){
            queue.add(i);
        }
        interleave(queue);
        System.out.println(queue);
    }

    static  void interleave(Queue<Integer> queue){
        Stack<Integer> stack= new Stack<>();
        int x=(queue.size()/2);
        for(int i=0;i<x;i++){
            stack.add(queue.poll());
        }
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
        for (int i = 0; i < queue.size()/2; i++) {
           queue.add(queue.poll());
        }
        for(int i=0;i<x;i++){
            stack.add(queue.poll());
        }

        while (!stack.isEmpty()){
            queue.add(stack.pop());
            queue.add(queue.poll());
        }

    }


}
