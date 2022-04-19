package src_apr.btree;

import binarytree.Btree.*;


public class Driver {

    public static void main(String[] args) {
        Btree btree= new Btree();
        btree.root.data=1;
        btree.root.left=new Node(2);
        btree.root.right= new Node(3);
        btree.root.left.left=new Node(3);
        btree.root.left.right=new Node(7);
        btree.root.right.left=new Node(9);
        btree.root.right.right=new Node(2);
        btree.root.left.left.left=new Node(4);
        btree.root.left.left.left.left=new Node(5);
        btree.recursionTry();
//        btree.inOrder();
//        btree.postOrder();
//        btree.preOrder();
//        btree.bfs();
//        btree.bottomView();
//        btree.height();
//        btree.largestSum();
//        System.out.println(btree.lca(-6,9));
//        btree.kSumPath(9);


    }

}
