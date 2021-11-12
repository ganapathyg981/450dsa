package binarytree;

public class Btree1 {
    public static void main(String[] args) {
        Btree btree= new Btree();
        btree.root.data=10;
        btree.root.left=new Node(4);
//        btree.root.right= new Node(3);
        btree.root.left.left=new Node(4);
//        btree.root.left.right=new Node(5);
//        System.out.println(btree.levelOrder());
//        btree.inOrderRecursive();
//        btree.postOrderRecursive();
//        btree.preOrderRecursive();
//        btree.mirror().inOrderRecursive();
//        Btree mirror=(btree.mirror());
//        mirror.inOrderRecursive();
//        System.out.println(btree.levelOrderRev());
    }



}
