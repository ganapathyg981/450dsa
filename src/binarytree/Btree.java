package binarytree;

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
    Node(){
        this.left=null;
        this.right=null;
    }
    public String toString(){
        String leftValue=this.left!=null? String.valueOf(this.left.data) :"null";
        String rightValue=this.right!=null? String.valueOf(this.right.data) :"null";
        return String.valueOf("\tD"+this.data+"    \nL"+leftValue+"     R"+rightValue+"\n");
    }
}
public class Btree {
    Node root;
    Btree(){
        root=new Node();
    }
    ArrayList<Integer> levelOrder(){
        Queue<Node> queue=new LinkedList();
        ArrayList<Integer> arr=new ArrayList<>();
        queue.add(this.root);
        levelOrderHelper(queue,arr);
        return arr;
    }
     private void levelOrderHelper(Queue<Node> queue, ArrayList<Integer> list){
        if(queue.size()==0)
            return;
        Node node=queue.poll();
        list.add(node.data);
        if(node.left!=null)
            queue.add(node.left);
        if(node.right!=null)
            queue.add(node.right);
        levelOrderHelper(queue,list);
        System.out.println();
    }
    public ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list= new ArrayList();
        leftViewHelper(root,0,list);
        return list;
    }

    private void leftViewHelper(Node node,int level,ArrayList<Integer> list){
        if(node==null)
            return;
        if(list.size()==level){
            list.add(node.data);
        }
        leftViewHelper(node.left,level+1,list);
        leftViewHelper(node.right,level+1,list);
    }

    void inOrderRecursive(){
        ArrayList<Integer> list= new ArrayList();
        inOrderHelper(this.root,list);
        for (int x:
             list) {
            System.out.print(x+" ");
        }
        System.out.println();
    }
    private void inOrderHelper(Node node, ArrayList arrayList){
        if(node==null)
            return;
        inOrderHelper(node.left,arrayList);
        arrayList.add(node.data);
        inOrderHelper(node.right,arrayList);
    }

    void postOrderRecursive(){
        ArrayList<Integer> list= new ArrayList();
        postOrderHelper(this.root,list);
        for (int x:
                list) {
            System.out.println(x);
        }
    }
    private void postOrderHelper(Node node, ArrayList arrayList){
        if(node==null)
            return;
        postOrderHelper(node.left,arrayList);
        postOrderHelper(node.right,arrayList);
        arrayList.add(node.data);
    }
    void preOrderRecursive(){
        ArrayList<Integer> list= new ArrayList();
        preOrderHelper(this.root,list);
        for (int x:
                list) {
            System.out.println(x);
        }
    }
    private void preOrderHelper(Node node, ArrayList arrayList){
        if(node==null)
            return;
        arrayList.add(node.data);
        preOrderHelper(node.left,arrayList);
        preOrderHelper(node.right,arrayList);

    }
    Btree mirror(){
        if(this.root==null)
            return null;
        Btree btree_mirror=new Btree();
        btree_mirror.root=new Node(this.root.data);
        mirrorHelper(this.root,btree_mirror.root);
        return btree_mirror;
    }

    private void mirrorHelper(Node btree, Node btree_mirror) {
        if(btree==null)
            return;
        if(btree.right!=null)
            btree_mirror.left=new Node(btree.right.data);
        if(btree.left!=null)
            btree_mirror.right=new Node(btree.left.data);
        mirrorHelper(btree.right,btree_mirror.left);
        mirrorHelper(btree.left,btree_mirror.right);
    }

    void reverseLevelOrder(Node node){
        if(node==null)
            return;
        reverseLevelOrder(node.left);
        reverseLevelOrder(node.right);
        System.out.print(node.data+" ");
    }

    ArrayList<Integer> levelOrderRev(){
        Queue<Node> queue=new LinkedList();
        ArrayList<Integer> arr=new ArrayList<>();
        queue.add(this.root);
        levelOrderHelperRev(queue,arr);
        Collections.reverse(arr);
        return arr;
    }
    private void levelOrderHelperRev(Queue<Node> queue, ArrayList<Integer> list){
        if(queue.size()==0)
            return;
        Node node=queue.poll();
        list.add(node.data);
        if(node.right!=null)
            queue.add(node.right);
        if(node.left!=null)
            queue.add(node.left);
        levelOrderHelperRev(queue,list);
    }
    boolean isBalanced(Node root)
    {
       if(root==null)
           return true;

        if(Math.abs(height(root.left)-height(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right))
            return true;
        else
            return false;
    }

    private int height(Node root){
        System.out.println(root);
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
}
