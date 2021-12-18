package graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalDFS {
    LinkedList<Integer> list=new LinkedList();
    public static void main(String[] args) {
        Graph graph=new Graph(6);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(4,1);
        graph.addEdge(4,0);
        graph.addEdge(5,0);
        graph.addEdge(5,2);
        TopologicalDFS topologicalDFS= new TopologicalDFS();
        System.out.println(topologicalDFS.topological(graph));
        System.out.println(topologicalDFS.list);
    }


    Stack<Integer> topological(Graph graph){
        Stack<Integer> stack= new Stack<>();
        boolean[] visited= new boolean[graph.V];
        for (int i = 0; i < graph.V; i++) {
            if(!visited[i])
                dfs(i, stack, graph,visited);
        }
        return stack;
    }

    private void dfs(int current, Stack<Integer> stack, Graph graph, boolean[] visited) {
        visited[current]=true;
        for (Integer neighbor:
             graph.adj[current]) {
            if(!visited[neighbor]){
                dfs(neighbor,stack,graph,visited);
            }
        }
        this.list.add(current);
        stack.add(current);
    }
}
