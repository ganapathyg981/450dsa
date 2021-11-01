package tree;

import java.util.Stack;

class Node{
    int value;
    Node left;
    Node right;
    Node(int value){
        this.value=value;
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
}
