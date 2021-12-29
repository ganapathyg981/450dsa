package graph;


import java.util.*;

public class KosaRajuSCC {
    public static void main(String[] args) {
        WeightedGraph graph= new WeightedGraph(9);
        graph.addEdge(0,1,4);
        graph.addEdge(0,7,8);
        graph.addEdge(1,2,8);
        graph.addEdge(1,7,11);
        graph.addEdge(7,8,7);
        graph.addEdge(7,6,1);
        graph.addEdge(2,8,2);
        graph.addEdge(2,5,4);
        graph.addEdge(2,3,7);
        graph.addEdge(8,6,6);
        graph.addEdge(6,5,2);
        graph.addEdge(5,3,14);
        graph.addEdge(5,4,10);
        graph.addEdge(4,3,9);
        KosaRajuSCC kosaRajuSCC= new KosaRajuSCC();
        WeightedGraph g= new WeightedGraph(5);
        g.addEdge(1, 0,0);
        g.addEdge(0, 2,0);
        g.addEdge(2, 1,0);
        g.addEdge(0, 3,0);
        g.addEdge(3, 4,0);
        System.out.println(kosaRajuSCC.kosaRaju(g));
    }



    public ArrayList<ArrayList<Integer>> kosaRaju(WeightedGraph graph){
        ArrayList<ArrayList<Integer>> output=new ArrayList<>(graph.V);
        for (int i = 0; i <graph.V; i++) {
            output.add(null);
        }
            Stack<Integer> stack= new Stack();
            boolean[] visited = new boolean[graph.V];
        for (int i = 0; i < graph.V; i++) {
            if(!visited[i])
            topological(0,graph,stack,visited);
        }
        System.out.println(stack);

        WeightedGraph transpose=transpose(graph);

        System.out.println(transpose.adjList);


        Arrays.fill(visited,false);
        while(!stack.isEmpty()){
            int current=stack.pop();
            ArrayList<Integer> newList= new ArrayList<>();
            if(!visited[current]) {
                DFS(transpose, current, visited, output, newList);
            }
            output.set(current,newList);
        }

        return output;
    }
    public void DFS(WeightedGraph transpose, int i, boolean[] visited, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> newList){
        visited[i]=true;
        newList.add(i);
        if(transpose.adjList.get(i)!=null)
        for (Node n :
                transpose.adjList.get(i)) {
            if(!visited[n.node]){
                visited[n.node]=true;
                System.out.println();
                DFS(transpose,n.node,visited,list, newList);
            }
        }

    }

    public WeightedGraph transpose(WeightedGraph graph){
        WeightedGraph transpose = new WeightedGraph(graph.V);
        for (int i = 0; i < graph.V; i++) {
            if(graph.adjList.get(i)!=null)
            for (Node neighbor:
                graph.adjList.get(i) ) {
                transpose.addEdge(neighbor.node,i,neighbor.distance);
            }
        }
        return transpose;
    }
    public void topological(int i, WeightedGraph graph, Stack<Integer> stack, boolean[] visited){
        visited[i]=true;
        if(graph.adjList.get(i)!=null)
        for (Node neighbor:
             graph.adjList.get(i)) {
            if(!visited[neighbor.node]){
                visited[neighbor.node]=true;
                topological(neighbor.node,graph,stack,visited);
            }
        }
        stack.add(i);
    }
}
