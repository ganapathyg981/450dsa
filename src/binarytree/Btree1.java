package binarytree;

public class Btree1 {
    public static void main(String[] args) {
        Btree btree= new Btree();
        btree.root.data=1;
        btree.root.left=new Node(-2);
        btree.root.right= new Node(3);
        btree.root.left.left=new Node(4);
        btree.root.left.right=new Node(5);
        btree.root.right.left=new Node(-6);
        btree.root.right.right=new Node(2);
//        System.out.println(btree.findDist(btree.root,3,8));
//        System.out.println(btree.levelOrder());
//        btree.inOrderRecursive();
//        btree.postOrderRecursive();
//        btree.preOrderRecursive();
//        btree.mirror().inOrderRecursive();
//        Btree mirror=(btree.mirror());
//        mirror.inOrderRecursive();
//        System.out.println(btree.levelOrderRev());
//            btree.findLargestSum(btree.root);
        btree.treeFromString("4(2(3)(1))(6(5))");
    }



}
