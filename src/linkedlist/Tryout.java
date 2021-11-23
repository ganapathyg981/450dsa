package linkedlist;

public class Tryout {


    public static void main(String[] args) {
        LinkedList list= new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.print();
        System.out.println(list.getMiddle().data);

    }
}
