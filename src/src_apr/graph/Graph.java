package src_apr.graph;

import java.util.ArrayList;
import java.util.Collections;

public class Graph {
    int V;
    ArrayList<ArrayList<Integer>> edges;


    Graph(int V){
        this.V=V;
        if(edges==null){
            edges=new ArrayList<>();
            for(int i=0;i<V;i++){
                edges.add(i,new ArrayList<>());
            }
        }
    }

    void addEdge(int u,int v){
        if(u>V||v>V){
            System.out.println("Out of bounds");
            return;
        }
        edges.get(u).add(v);
    };

    void dfs(){
        System.out.println(edges);
        boolean[] visited= new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i])
                dfsUtil(i,visited);
        }
    }

    private void dfsUtil(int i, boolean[] visited){
            visited[i]=true;
            System.out.println(i);
            for(Integer target:edges.get(i)){
//                System.out.println(target);
                if(!visited[target])
                dfsUtil(target,visited);
            }
    }

}
