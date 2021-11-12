package heap;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
public class Heap13 {
    boolean isHeap(Node tree) {
        if(isHeapHelper(tree,countNodes(tree),0))
            return true;
        else
            return false;

    }
    boolean isHeapHelper(Node tree,int size, int level){
                if(tree==null)
                    return true;
                if(level>=size)
                    return false;
                if((tree.left!=null&&tree.data<tree.left.data))
                    return false;
                if(tree.right!=null&&tree.data<tree.right.data)
                    return false;
                return isHeapHelper(tree.left,size,(2*level)+1)&&isHeapHelper(tree.right,size,(2*level)+2);
    }
    int countNodes(Node root)
    {
        if (root == null)
            return 0;
        return (1 + countNodes(root.left)
                + countNodes(root.right));
    }


}
