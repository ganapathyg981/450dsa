package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartiteBFS {
    public static void main(String[] args) {
        Graph bipartite= new Graph(10);
        bipartite.addEdge(1,2);
        bipartite.addEdge(2,1);
        bipartite.addEdge(2,3);
        bipartite.addEdge(3,2);
        bipartite.addEdge(3,4);
        bipartite.addEdge(3,5);
        bipartite.addEdge(4,3);
        bipartite.addEdge(4,6);
        bipartite.addEdge(5,3);
        bipartite.addEdge(5,8);
        bipartite.addEdge(6,8);
        bipartite.addEdge(6,4);
//        bipartite.addEdge(7,8);
//        bipartite.addEdge(7,5);
        bipartite.addEdge(8,6);
        bipartite.addEdge(8,5);
//        bipartite.addEdge(8,7);
        bipartite.addEdge(8,9);
        bipartite.addEdge(9,8);
        BiPartiteBFS biPartiteBFS= new BiPartiteBFS();

        System.out.println(biPartiteBFS.isBipartite(bipartite));

    }


    boolean isBipartite(Graph graph){
        int[] color=new int[graph.V];
        Arrays.fill(color,-1);
        /**
         * -1 unvisited
         * 0 red
         * 1 blue
         */

        for (int i = 0; i <graph.V ; i++) {
            if(color[i]==-1)
                if(!isBipartite(i,graph,color))
                    return false;
        }
        return true;
    }

    private boolean isBipartite(int i, Graph graph, int[] color) {
        int currentColor=0;
        color[i]=currentColor;
        Queue<Integer> queue= new LinkedList<>();
        queue.add(i);

        while(!queue.isEmpty()){
            int current=queue.poll();
            if(color[current]==1){
                currentColor=0;
            }
            else if(color[current]==0){
                currentColor=1;
            }
            for (Integer neighbor:
                    graph.adj[current]) {
                if(color[neighbor]==-1){
                    color[neighbor]=currentColor;
                    queue.add(neighbor);
                }
                else if(color[neighbor]==color[current]) {
                    System.out.println(String.format("Current %s Neighbor %s",current,neighbor));
                    return false;
                }
            }
        }
        return true;
    }
}
