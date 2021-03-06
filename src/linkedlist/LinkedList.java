package linkedlist;
class Node{
    int data;
    Node next;

    public Node(int a) {
        this.data=a;
        this.next=null;
    }
}
public class LinkedList {
    Node head=null;
    void add(int a){
        if(head==null)
            head=new Node(a);
        else{
            Node current=head;
            while(true){
                if(current.next==null) {
                    current.next = new Node(a);
                    break;
                }
                current=current.next;
            }
        }
    }
    void print(){
        Node current=head;
        while(true){
            System.out.print(current.data+"-->");
            if(current.next==null)
                break;
            else{
                current=current.next;
            }
        }
        System.out.println();
    }

    void reverse(){
        Node current=head;
        Node prev=null;
        Node next;
        while(current!=null){
            if(current.next==null){
                head=current;
                head.next=prev;
                break;
            }
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
    }

    Node getMiddle(){
        if(head==null||head.next==null)
            return head;
        Node slow=head;
        Node fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
