package src_apr.graph;


public class Driver {
    public static void main(String[] args) {
        Graph graph=new Graph(10);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,6);
        graph.addEdge(6,5);
        graph.addEdge(4,5);
        graph.addEdge(8,9);
        graph.addEdge(7,2);
        graph.addEdge(9,7);
        graph.addEdge(7,8);
        graph.dfs();
    }
}
