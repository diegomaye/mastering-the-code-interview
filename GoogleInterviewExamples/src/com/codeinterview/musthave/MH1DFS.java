package com.codeinterview.musthave;

import com.codeinterview.musthave.dfs.GraphAdjList;
import com.codeinterview.musthave.dfs.GraphAdjMatrix;

public class MH1DFS {
    // Driver Code
    public static void main(String args[])
    {
        GraphAdjList graphAdjList = new GraphAdjList(4);
        GraphAdjMatrix graphAdjMatrix = new GraphAdjMatrix((4));
        graphAdjList.addEdge(0, 1);
        graphAdjList.addEdge(0, 2);
        graphAdjList.addEdge(1, 2);
        graphAdjList.addEdge(2, 0);
        graphAdjList.addEdge(2, 3);
        graphAdjList.addEdge(3, 3);
        graphAdjList.printAdjacencyList();
        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        graphAdjList.dfs(2);

        graphAdjMatrix.addEdge(0, 1);
        graphAdjMatrix.addEdge(0, 2);
        graphAdjMatrix.addEdge(1, 2);
        graphAdjMatrix.addEdge(2, 0);
        graphAdjMatrix.addEdge(2, 3);
        graphAdjMatrix.addEdge(3, 3);
        graphAdjMatrix.printAdjacencyMatrix();
        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        graphAdjMatrix.dfs(2);
    }
}
