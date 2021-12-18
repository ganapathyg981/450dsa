package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
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
//        System.out.println(graph);
        Dijkstra dijkstra= new Dijkstra();
        dijkstra.dijkstra(graph,0);
    }

    int[] dijkstra(WeightedGraph graph,int start){
        int[] distance= new int[graph.V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start]=0;
        PriorityQueue<Node> queue= new PriorityQueue<>(graph.V);
        queue.add(new Node(start,0));
        while (!queue.isEmpty()){
            Node current=queue.poll();
//            System.out.println(current.node);
            for(Node neighbour:graph.adjList.get(current.node)){
//                System.out.println(graph.adjList.get(current.node));
                if(neighbour.distance+distance[current.node] <distance[neighbour.node]){
                    distance[neighbour.node]=neighbour.distance+distance[current.node];
                    queue.add(neighbour);
                }
            }
        }

        for (int distances:
             distance) {
            System.out.print(distances+" ");
        }
        return distance;
    }
}
