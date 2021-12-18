package graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MSTPrim {
    public static void main(String[] args) {
        WeightedGraph graph= new WeightedGraph(9);
        graph.addEdge(0,1,4);
        graph.addEdge(0,7,8);
        graph.addEdge(1,2,8);
        graph.addEdge(1,7,11);
        graph.addEdge(1,0,4);
        graph.addEdge(7,0,8);
        graph.addEdge(7,1,11);
        graph.addEdge(7,8,7);
        graph.addEdge(7,6,1);
        graph.addEdge(2,1,8);
        graph.addEdge(2,8,2);
        graph.addEdge(2,5,4);
        graph.addEdge(2,3,7);
        graph.addEdge(8,2,2);
        graph.addEdge(8,6,6);
        graph.addEdge(8,7,7);
        graph.addEdge(6,8,6);
        graph.addEdge(6,7,1);
        graph.addEdge(6,5,2);
        graph.addEdge(5,3,14);
        graph.addEdge(5,4,10);
        graph.addEdge(5,6,2);
        graph.addEdge(5,2,4);
        graph.addEdge(4,3,9);
        graph.addEdge(4,5,10);
        graph.addEdge(3,4,9);
        graph.addEdge(3,5,14);
        graph.addEdge(3,2,7);
        MSTPrim mstPrim= new MSTPrim();
        int[] mst=mstPrim.findMST(graph);
        for (int i = 0; i < mst.length; i++) {
            System.out.println(
                    String.format("Node %s Parent %s",i,mst[i])
            );
        }
    }

    int[] findMST(WeightedGraph graph){
        int[] parent=new int[graph.V];
        boolean[] mst=new boolean[graph.V];
        int[] key =new int[graph.V];
        Arrays.fill(key,Integer.MAX_VALUE);
        PriorityQueue<Node> queue= new PriorityQueue<>();
        parent[0]=-1;
        key[0]=0;
        queue.add(new Node(0,0));
        while(!queue.isEmpty()){
            Node current=queue.poll();
            mst[current.node]=true;
            for (Node neighbor:
                 graph.adjList.get(current.node)) {
                if(!mst[neighbor.node]&&key[neighbor.node]>neighbor.distance){
                    key[neighbor.node]= neighbor.distance;
                    queue.add(neighbor);
                    parent[neighbor.node]=current.node;
                }
            }
        }
        return  parent;
    }
}
