package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MSTKruskal {
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
        MSTKruskal mstKruskal= new MSTKruskal();
        mstKruskal.findMST(graph);
    }
    int[] findMST(WeightedGraph graph){
        int[] parent=new int[graph.V];
        DisjointSet disjointSet= new DisjointSet(graph.V);
        PriorityQueue<Edge> queue= new PriorityQueue<>();
        for (int i = 0; i < graph.V; i++) {
            for (Node node:
                 graph.adjList.get(i)) {
                queue.add(new Edge(i,node));
            }
        }
        while(!queue.isEmpty()){
            Edge current=queue.poll();
            System.out.println(current);
        }


        return parent;
    }
}



class DisjointSet{
    int[] rank;
    int[] parent;

    DisjointSet(int i){
        rank=new int[i];
        Arrays.fill(rank,0);
        parent=new int[i];
        for (int j = 1; j < parent.length; j++) {
         parent[j]=j;
        }
    }

    int findParent(int node){
        if(node==parent[node])
        return node;
        else{
            return parent[node]=findParent(parent[node]);
        }
    }

    void union(int first,int second){

    }
}
