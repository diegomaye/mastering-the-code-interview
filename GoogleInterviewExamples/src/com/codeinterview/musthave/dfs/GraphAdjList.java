package com.codeinterview.musthave.dfs;

import java.util.*;

public class GraphAdjList {
    private int vertices; // No. of vertices

    // Adjacency List Representation
    private LinkedList<Integer> list[];

    // Constructor
    public GraphAdjList(int v) {
        vertices = v;
        list = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            list[i] = new LinkedList();
    }

    public void printAdjacencyList(){
        for (int row = 0; row < list.length; row++)//Cycles through rows
            for(Integer val: list[row])
                System.out.println(row + " -> " + val); //change the %5d to however much space you want
    }

    public void addEdge(int v, int w) {
        list[v].add(w); // Add w to v's list.
    }

    // A function used by dfsUtil
    public void dfsUtil(int start, boolean visited[]) {//|V|+|A|
        visited[start] = true;
        System.out.print(start + " ");
        for (Integer vertex : list[start]){
            if (!visited[vertex])
                dfsUtil(vertex, visited);
        }
    }

    public void dfs(int v) {
        boolean visited[] = new boolean[vertices];
        dfsUtil(v, visited);
    }

    public void bfs(int vertex)
    {
        boolean visited[] = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[vertex] = true;
        queue.add(vertex);
        while (queue.size() != 0) {
            vertex = queue.poll();
            System.out.print(vertex + " ");
            Iterator<Integer> i = list[vertex].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

}