package graph;

import java.util.ArrayList;
import java.util.Collections;

public class WeightedGraph {
    int V;
    ArrayList<ArrayList<Node>> adjList;

    WeightedGraph(int V){
        this.V=V;
        adjList=new ArrayList<>(Collections.nCopies(V,null));
    }

    public void addEdge(int source, int target, int weight){
        if(adjList.get(source)==null){
            adjList.set(source,new ArrayList<>());
        }
        adjList.get(source).add(new Node(target,weight));
    }

    @Override
    public String toString() {
        return String.valueOf(adjList);
    }
}
class Node implements Comparable<Node>{
    int node;
    int distance;
    Node(int v, int w){
        this.node =v;
        this.distance =w;
    }
    @Override
    public int compareTo(Node o) {
        return this.distance-o.distance;
    }

    @Override
    public String toString() {
        return String.valueOf(node);
    }
}

class Edge implements Comparable<Edge>{
    int source;
    int target;
    int distance;
    Edge(int source,Node node){
        this.source=source;
        this.target=node.node;
        this.distance=node.distance;
    }

    @Override
    public int compareTo(Edge o) {
        return this.distance-o.distance;
    }
    @Override
    public String toString() {
        return String.format("src:%s   target:%s",source,target);
    }
}
