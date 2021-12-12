package graph;

public class DirectedCycleDFS {
    public static void main(String[] args) {
        Graph nonCyclic= new Graph(10);
        nonCyclic.addEdge(1,2);
        nonCyclic.addEdge(2,3);
        nonCyclic.addEdge(3,4);
        nonCyclic.addEdge(3,6);
        nonCyclic.addEdge(6,5);
        nonCyclic.addEdge(4,5);
//        nonCyclic.addEdge(8,9);
        nonCyclic.addEdge(7,2);
        nonCyclic.addEdge(9,7);
        nonCyclic.addEdge(7,8);
        DirectedCycleDFS directedCycleDFS= new DirectedCycleDFS();
        System.out.println(directedCycleDFS.isCycle(nonCyclic));
    }

    boolean isCycle(Graph g){
        boolean[] visited= new boolean[g.V];
        boolean[] dfsVisited= new boolean[g.V];
        for (int i = 0; i < g.V; i++) {
            if(!visited[i]){
                if(isCycle(i,visited,dfsVisited,g)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isCycle(int i, boolean[] visited, boolean[] dfsVisited, Graph g){

        visited[i]=true;
        dfsVisited[i]=true;
        for (Integer neighbour:
             g.adj[i]) {
            if(!visited[neighbour]){
                if(isCycle(neighbour,visited,dfsVisited,g)){
                    return true;
                }
            }
            else if(dfsVisited[neighbour]){
                System.out.println(String.format("Current:%s\tneighbour:%s",i,neighbour));
                return true;
            }
        }
        dfsVisited[i]=false;
        return false;
    }
}
