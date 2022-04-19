package src_apr.btree;

public class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    Node() {
        this.left = null;
        this.right = null;
    }

    public String toString() {
        String leftValue = this.left != null ? String.valueOf(this.left.data) : "null";
        String rightValue = this.right != null ? String.valueOf(this.right.data) : "null";
        return String.valueOf("\tD" + this.data + "    \nL" + leftValue + "     R" + rightValue + "\n");
    }
}
