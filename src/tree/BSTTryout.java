package tree;

public class BSTTryout {
    public static void main(String[] args) {
        BST tree= new BST();
        tree.insert(30);
        tree.insert(50);
        tree.insert(15);
        tree.insert(20);
        tree.insert(10);
        tree.insert(40);
        tree.insert(60);



//        tree.print(tree.root);
        tree.remove(50);
        tree.inorder();
        System.out.println();
        System.out.println(tree.root.value);
        System.out.println(tree.root.left.value);
        System.out.println(tree.root.right.value);

    }
}
