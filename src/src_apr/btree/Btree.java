package src_apr.btree;

import java.util.*;

public class Btree {
    Node root;
    Btree (){
        root= new Node();
    }


    public void inOrder(){
        inOrder(this.root);
        System.out.println();
    }
    private void inOrder(Node current){
        if(current==null){
            return;
        }
        inOrder(current.left);
        System.out.print(current.data);
        inOrder(current.right);
    }
    public void postOrder(){
        postOrder(this.root);
        System.out.println();
    }
    private void postOrder(Node current){
        if(current==null){
            return;
        }
        postOrder(current.left);
        postOrder(current.right);
        System.out.print(current.data);
    }
    public void preOrder(){
        preOrder(this.root);
        System.out.println();
    }
    private void preOrder(Node current){
        if(current==null){
            return;
        }
        System.out.print(current.data);
        preOrder(current.left);
        preOrder(current.right);
    }

    void bfs(){
        if(root==null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        LinkedList<LinkedList<Integer>> list= new LinkedList<>();
        while (!q.isEmpty()){
            LinkedList<Integer> listTemp= new LinkedList<>();
            int size= q.size();
            for (int i=0;i<size;i++) {
                Node current=q.poll();
                listTemp.add(current.data);
                if(current.left!=null)
                    q.add(current.left);
                if(current.right!=null)
                    q.add(current.right);
            }
            list.add(listTemp);

        }
        System.out.println(list);



    }

    void bottomView(){
        TreeMap<Integer,int []> map = new TreeMap<>();
        bottomView(this.root,0,map,0);
        System.out.println(map);
        for(Map.Entry<Integer,int[]> x :map.entrySet()){
            System.out.println(x.getValue()[1]);
        }
    }

    private void bottomView(Node root,int offset,TreeMap<Integer,int []> map,int depth){
        if(root==null)
            return ;
        if(!map.containsKey(offset)){
            System.out.print(root.data);
            map.put(offset, new int[]{depth, root.data});
        }
        else{
            int [] present=map.get(offset);
            if(present[0]<=depth){
                present[0]=depth;
                present[1]=root.data;
            }
            map.put(offset,present);
        }
        bottomView(root.left,offset-1,map,depth+1);
        bottomView(root.right,offset+1,map,depth+1);

    }

    void height(){
        Integer height=height(root);
        System.out.println(height);
    }

    private int height(Node root){
            if(root==null){
                return 0;
            }
            return(Math.max(height(root.left),height(root.right))+1);

    }

    void largestSum(){
        int [] sum=new int[]{Integer.MIN_VALUE};
        largestSum(root,sum);
        System.out.println(sum[0]);

    }

    private int  largestSum(Node root, int[] sum){
        if(root==null)
            return 0;


        int sumLocal= (root.data+largestSum(root.left,sum)+largestSum(root.right,sum));
        sum[0]=Math.max(sum[0],sumLocal);
        return sumLocal;
    }



    Node lca(int a,int b){
        return lca(root,a,b);
    }
    private Node lca(Node root,int a, int b){
        if(root==null||root.data==a||root.data ==b){
            return root;
        }

        Node leftSide=lca(root.left,a,b);
        Node rightSide=lca(root.right,a,b);
        if(leftSide!=null&&rightSide!=null){
            return root;
        }
        if(leftSide!=null)
            return leftSide;
        if(rightSide!=null){
            return  rightSide;
        }
        return null;

    }

    public void kSumPath(int k){
        kSumPath(this.root, new LinkedList<>(),k);
        System.out.println();
    }
    private void kSumPath(Node current, LinkedList<Integer> path,int k){
        if(current==null){
            return;
        }
        path.add(current.data);
//        System.out.print(current.data);
        kSumPath(current.left,path,k);
        kSumPath(current.right,path,k);
        System.out.println(path);
        int f = 0;
        for (int j = path.size() - 1; j >= 0; j--) {
            f += path.get(j);

            // If path sum is k, print the path
            if (f == k)
                printVector(path, j);
        }
        path.remove(path.size() - 1);
    }
    static void printVector(LinkedList<Integer> v, int i)
    {
        for (int j = i; j < v.size(); j++)
            System.out.print(v.get(j) + " ");
        System.out.println();
    }

    void recursionTry(){
        recursionTry(root);
    }

    private void recursionTry(Node root){
        if(root==null)
            return;
        System.out.println(root.data);
        recursionTry(root.left);
        System.out.println(root.data);

    }

}

