package graph;
import java.sql.SQLOutput;
import java.util.*;

// This class represents a
// directed graph using adjacency
// list representation
class Graph {
     int V; // No. of vertices

    // Array of lists for
    // Adjacency List Representation
     LinkedList<Integer> adj[];

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this
        // vertex

        for(Integer n:adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive
    // DFSUtil()
    void DFS()
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS
        // traversal starting from all vertices one by one
        for (int i = 0; i < V; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited);
    }

    LinkedList<Integer> BFS(int start){
        LinkedList<Integer> list= new LinkedList<>();
        Queue<Integer> queue= new LinkedList<>();
        HashSet<Integer> set=new HashSet<>();
        queue.add(start);
        set.add(start);
        while(!queue.isEmpty()){
            Integer current= queue.poll();
            list.add(current);

            for(Integer child:this.adj[current]){
                if(!set.contains(child)) {
                    queue.add(child);
                    set.add(child);
                }
            }
        }
        return list;

    }

    // Driver Code
    public static void main(String args[])
    {
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
        System.out.println("Following is the BFS");
        System.out.println(g.BFS(0));
        System.out.println("Following is the DFS");
        g.DFS();

    }
}
// This code is contributed by Aakash
