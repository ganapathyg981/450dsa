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
    int findDist(Node root, int a, int b) {
        Node lca=findLCA(root,a,b);
        return findDistHelper(lca,b,0)+findDistHelper(lca,a,0);
    }
    int findDistHelper(Node root,int key,int depth){
        if(root==null){
            return 0;
        }
        if(root.data==key){
            return depth;
        }
        int lr=findDistHelper(root.left,key,depth+1);
        int rr=findDistHelper(root.right,key,depth+1);
        if(lr>0)
            return lr;
        else
            return rr;
    }
    Node findLCA(Node root,int n1,int n2){
        if(root==null){
            return null;
        }
        if(root.data==n1||root.data==n2) {
//            System.out.println(root.data);
            return root;
        }
        Node ls=findLCA(root.left,n1,n2);
        Node rs=findLCA(root.right,n1,n2);
//        System.out.println(root+"--"+ls+"--"+ rs);
        if(ls!=null&&rs!=null) {
//            System.out.println("Came here");
            return root;
        }
        else if(ls!=null)
            return ls;
        else if(rs!=null)
            return rs;
        return null;
    }
    void findLargestSum(Node root){
        int[] max={Integer.MIN_VALUE};
        findLargestSum(root,max);
        System.out.println(max[0]);
    }

    private int findLargestSum(Node root,int[] max){
        if(root==null)
            return 0;
       int sum= root.data+
        findLargestSum(root.left,max)+findLargestSum(root.right,max);
        if(max[0]<sum)
            max[0]=sum;
        return sum;
    }

    void treeFromString(String s){
        System.out.println(s.substring(0,1));
        if(s.length()<=1)
            return;
        String children=s.substring(1);
        Stack<Character> stack= new Stack<>();
        stack.add(children.charAt(0));
        int leftEndIndex = 0;
        for (int i = 1; i < children.length(); i++) {
            if(children.charAt(i)=='(')
                stack.push('(');
            else if(children.charAt(i)==')')
                stack.pop();
            if(stack.size()==0) {
                leftEndIndex = i;
                break;
            }
        }
        treeFromString(children.substring(1,leftEndIndex));
        if(children.length()-1>leftEndIndex)
        treeFromString(children.substring(leftEndIndex+2,children.length()-1));
    }

}
