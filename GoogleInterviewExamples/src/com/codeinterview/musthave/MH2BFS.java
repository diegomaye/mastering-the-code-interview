package com.codeinterview.musthave;

import com.codeinterview.musthave.dfs.GraphAdjList;

public class MH2BFS {
    public static void main(String... arr){
        GraphAdjList graph = new GraphAdjList(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.printAdjacencyList();
        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        graph.bfs(2);
    }
}
