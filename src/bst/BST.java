package bst;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node{
    int value;
    Node left;
    Node right;
    Node(int value){
        this.value=value;
    }
    public String toString(){

        return String.valueOf(this.value);
    }
}
public class BST {
    Node root;
    BST(int value){
        root=new Node(value);
    }
    BST (){
        root=null;
    }
    void insert(int key){
        Node node= new Node(key);
        if(this.root==null)
            this.root=node;
        else{
            Node currentNode=this.root;
            Node prev=null;
            while(currentNode!=null)
            {
                if(key<currentNode.value){
                    prev=currentNode;
                    currentNode=currentNode.left;
                }
                else{
                    prev=currentNode;
                    currentNode=currentNode.right;
                }
            }
            if(prev.value>key)
                prev.left=node;
            else
                prev.right=node;
        }
    }
    void remove(int key){
        Node prev;
        if(root.value==key)
            removeHelper(null,root);
        else{
            Node currentNode=root;
            while(currentNode!=null){
                prev=currentNode;
                if(currentNode.value<key){
                    currentNode=currentNode.right;
                }
                else
                    currentNode=currentNode.left;

                if(currentNode.value==key){

                    removeHelper(prev,currentNode);
                    break;
                }
            }
        }

    }
    void removeHelper(Node prev,Node node){
            if(node.left==null&&node.right==null && prev!=null){
                if(node.value< prev.value)
                    prev.left=null;
                else
                    prev.right=null;
            }
            else if(node.left!=null&&node.right!=null){
                Node toBeReplaced=inorderPreceder(node);
                node.value=toBeReplaced.value;
            }
            else{
                if(node.left!=null){
                    node.value=node.left.value;
                    node.left=null;
                }
                else{
                    node.value=node.right.value;
                    node.right=null;
                }
            }

    }
    void BFS_OPT(){
        Node currentNode=this.root;
        Queue<Node> q =new LinkedList();
        LinkedList<Node> list= new LinkedList<>();
        q.add(currentNode);
        while(q.size()>0){
            currentNode=q.poll();
            System.out.print(currentNode.value + " ");
            list.add(currentNode);
            if(currentNode.left!=null){
                q.add(currentNode.left);
            }
            if(currentNode.right!=null){
                q.add(currentNode.right);
            }
        }
    }
    Node inorderPreceder(Node node){
        Node currentNode=node.right;
        Node temp=null;
        if(currentNode.left==null)
            return currentNode;
        while(currentNode.left!=null){
            temp=currentNode;
                    currentNode=currentNode.left;
        }
        temp.left=null;
        return currentNode;
    }
    public void inorder(){
        Node temp=root;
        Stack<Node> stack=new Stack<>();
        while (temp!=null||!stack.isEmpty()){
            if(temp!=null){
                stack.add(temp);
                temp=temp.left;
            }
            else {
                temp=stack.pop();
                System.out.print(temp.value+" ");
                temp=temp.right;
            }
        }
    }
    void BFS_RECURSION(){
        Node currentNode=this.root;
        Queue<Node> q= new LinkedList();
        List<Integer> l = new LinkedList();
        q.add(currentNode);
        BFS_HELPER(q,l);
    }
    private void BFS_HELPER(Queue<Node> q, List<Integer> l){
        if(q.size()==0)
            return;
        Node node=q.poll();
        System.out.print(node.value+ " ");
        l.add(node.value);
        if(node.left!=null){
            q.add(node.left);
        }
        if(node.right!=null){
            q.add(node.right);
        }
        BFS_HELPER(q,l);
    }

    boolean search(int key,Node currentNode){
        if(currentNode.value==key)
            return true;
        if(key<currentNode.value&&currentNode.left!=null)
            return search(key,currentNode.left);
        if(key>currentNode.value&&currentNode.right!=null)
            return search(key,currentNode.right);
        return false;
    }

    int findMax(Node currentNode,int max){
       if(max<currentNode.value)
           max=currentNode.value;
       if(currentNode.left!=null)
           max=findMax(currentNode.left,max);
       if(currentNode.right!=null)
           max=findMax(currentNode.right,max);
       return max;
    }
    int findMin(Node currentNode,int min){
        if(min>currentNode.value)
            min=currentNode.value;
        if(currentNode.left!=null)
            min=findMin(currentNode.left,min);
        if(currentNode.right!=null)
            min=findMin(currentNode.right,min);
        return min;
    }

}
