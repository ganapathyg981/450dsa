package bst;

public class BSTTryout {
    public static void main(String[] args) {
        BST tree= new BST();
        tree.insert(30);
        tree.insert(50);
        tree.insert(15);
        tree.insert(9999);
        tree.insert(20);
        tree.insert(10);
        tree.insert(333333333);
        tree.insert(40);
        tree.insert(60);
//        System.out.println(tree.search(30,tree.root));
        tree.BFS_OPT();
        System.out.println();
//        tree.BFS_RECURSION();
        System.out.println();
        System.out.println(tree.findMax(tree.root,tree.root.value));
        System.out.println(tree.findMin(tree.root,tree.root.value));
////        tree.print(tree.root);
//        tree.remove(50);
//        tree.inorder();
//        System.out.println(Integer.valueOf('A'));
////        System.out.println(tree.root.value);
////        System.out.println(tree.root.left.value);
////        System.out.println(tree.root.right.value);

    }
}
