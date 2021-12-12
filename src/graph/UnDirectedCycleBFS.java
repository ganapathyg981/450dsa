package graph;

import java.util.LinkedList;
import java.util.Queue;

public class UnDirectedCycleBFS {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 0);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(3, 3);
//        System.out.println(isCycle(g));

        Graph nonCyclic= new Graph(5);
        nonCyclic.addEdge(0,1);
        nonCyclic.addEdge(1,0);
        nonCyclic.addEdge(1,2);
        nonCyclic.addEdge(2,1);
        nonCyclic.addEdge(2,3);
        nonCyclic.addEdge(2,4);
        nonCyclic.addEdge(3,2);
        nonCyclic.addEdge(4,2);
//        nonCyclic.addEdge(4,3);
//        nonCyclic.addEdge(3,4);
        UnDirectedCycleBFS b= new UnDirectedCycleBFS();
        System.out.println(b.isCycle(nonCyclic));

    }

    boolean isCycle(Graph g){
        boolean visited[]=new boolean[g.V];
        for (int i = 0; i < g.adj.length; i++) {
                if(!visited[i])
                if(isCycleHelper(i,visited, g))
                    return true;
        }
        return false;
    }

    boolean isCycleHelper(int node, boolean[] visited, Graph g){
        System.out.println("PARENT");
        visited[node]=true;
        Queue<NodePair> queue= new LinkedList<>();
        queue.add(new NodePair(Integer.valueOf(node),Integer.valueOf(-222)));
        while(queue.size()>0){
            System.out.println("ENTRY  "+queue);
            NodePair pair= queue.remove();
            int current=pair.node;
            int parent=pair.parent;

            for (int neighbor:
                 g.adj[current]) {
                if(!visited[neighbor]) {
                    visited[neighbor]=true;
                    queue.add(new NodePair(Integer.valueOf(neighbor), Integer.valueOf(current)));
                }
                else if(neighbor!=parent ){
//                    System.out.println(neighbor+" "+parent);
                    return true;
                }
            }
            System.out.println("EXIT  "+queue);
        }
        return false;
    }


    class NodePair{
        Integer node=0;
        Integer parent=0;
        NodePair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
        public String toString(){

            return String.format("Node: %s Parent: %s",this.node,this.parent);
        }
    }

}
