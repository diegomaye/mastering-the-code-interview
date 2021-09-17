package com.codeinterview.musthave.dfs;

import com.sun.source.tree.PackageTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjMatrix {
    private int vertices;

    // Adjacency Matrix Representation
    private boolean matrix[][];

    // Constructor
    public GraphAdjMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new boolean[vertices][vertices];
        for (int i = 0; i < vertices; ++i)
            for (int j = 0; j < vertices; ++j)
                matrix[i][j] = false;
    }

    public void printAdjacencyMatrix(){
        System.out.println("");
        System.out.print(" ");
        for (int i = 0; i < vertices; i++) {
            System.out.print(String.format(" %d ", i)); //change the %5d to however much space you want
        }
        System.out.println(); //Makes a new
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(row);
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(String.format(" %d ", (matrix[row][col]?1:0))); //change the %5d to however much space you want
            }
            System.out.println(); //Makes a new
        }
    }

    // Function to add an edge into the graph
    public void addEdge(int x, int y) {
        matrix[x][y] = true;
    }

    public void dfsRecursive(int vertex, boolean visited[]) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for(int i = 0; i < vertices; i++)
        {
            if(matrix[vertex][i]){
                if(!visited[i])
                    dfsRecursive(i, visited);
            }
        }
    }

    public void dfs(int vertex) {
        boolean visited[] = new boolean[vertices];
        dfsIterativo(vertex, visited);
    }

    public void dfsIterativo(int vertex, boolean[] visited){
        Stack<Integer> stack = new Stack<>();
        stack.add(vertex);
        while (!stack.isEmpty()){
            vertex = stack.pop();
            if(!visited[vertex]){
                System.out.print(vertex + " ");
                visited[vertex] = true;
                encolarVecinos(vertex, visited, stack);
            }
        }
    }

    private void encolarVecinos(int vertex, boolean[] visited, Stack<Integer> stack){
        for(int i = visited.length - 1; i >= 0; i--){
            if(matrix[vertex][i]){
                if(!visited[i]) {
                    stack.add(i);
                }
            }
        }
    }
}

