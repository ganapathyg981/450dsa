package graph;

public class UndirectedCycleDFS {
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
        UndirectedCycleDFS undirectedCycleDFS=new UndirectedCycleDFS();
        nonCyclic.addEdge(4,3);
        nonCyclic.addEdge(3,4);
        System.out.println(undirectedCycleDFS.isCycle(g));
    }

    boolean isCycle(Graph graph){
        boolean[] visited= new boolean[graph.V];
        for (int i = 0; i < graph.V; i++) {
            if(!visited[i])
            return isCycle(i,visited,graph,-1);
        }
        return false;
    }

    private boolean isCycle(int i, boolean[] visited, Graph graph, int parent) {
        visited[i]=true;
        for (Integer connectedNode:
             graph.adj[i]) {
            if(!visited[connectedNode]){
                if(isCycle(connectedNode,visited,graph,i))
                    return true;
            }
            else if(connectedNode!=parent ){
                return true;
            }
        }
        return false;
    }
}
