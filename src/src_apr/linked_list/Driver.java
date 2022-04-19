package src_apr.linked_list;

public class Driver {

    public static void main(String[] args) {
        LinkedList list= new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);

        list.print();
        list.reverse();
        list.print();

    }
}
