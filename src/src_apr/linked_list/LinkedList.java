package src_apr.linked_list;

public class LinkedList {
    Node head;


    public void add(int data){
        Node toBeAdded= new Node(data);
        if(this.head==null){
            this.head=toBeAdded;
        }
        else{
            Node temp=this.head;

            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=toBeAdded;
        }
    }

    public void reverse(){

        Node current=this.head;
        Node prev= null;
        while(current.next!=null){
            Node next=current.next;
            current.next=prev;
            prev=current;
            current=next;

        }
        head=current;
        head.next=prev;

    }



    void print(){
        Node current=this.head;
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
}


class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
    }
}
