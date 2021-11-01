package backtracking;

import stackandqueue.Queue;

public class BT21 {
    public static void main(String[] args) {
        Queue q = new Queue(4);

        // print Queue elements
        q.print();

        // inserting elements in the queue
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // print Queue elements
        q.print();

        // insert element in the queue
        q.enqueue(60);

        // print Queue elements
        q.print();

        q.dequeue();
        q.dequeue();
        System.out.printf("\n\nafter two node deletion\n\n");

        // print Queue elements
        q.print();

        // print front of the queue
        System.out.println(q.peek());
    }
}
