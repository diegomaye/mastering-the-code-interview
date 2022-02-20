package com.codeinterview.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * In this tutorial, we'll explore the Depth-first search in Java.
 * Depth-first search (DFS) is a traversal algorithm used for both Tree and Graph data structures.
 * The depth-first search goes deep in each branch before moving to explore another branch.
 * In the next sections, we'll first have a look at the implementation for a Tree and then a Graph.
 * To see how to implement these structures in Java, have a look at our previous tutorials on Binary Tree and Graph.
 * */

//Tree Depth-first Search
public class DFSAlgorithms {

    private int V; // No. of vertices

    // Array  of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    @SuppressWarnings("unchecked") DFSAlgorithms(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    class Node{
        int value;
        Node left;
        Node right;
    }
    //2.1. Preorder Traversal
    public void traversePreOrder(Node node){
        if(node!=null) {
            visit(node);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    //Preorder With Iteration
    public void traversePreorderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(current);
        while (!stack.isEmpty()){
            current = stack.pop();
            visit(current);
            if(current.left != null){
                stack.push(current.left);
            }
            if(current.right != null){
                stack.push(current.right);
            }
        }
    }

    //2.2. Inorder Traversal
    public void traverseInOrder(Node node){
        if(node!=null) {
            traversePreOrder(node.left);
            visit(node);
            traversePreOrder(node.right);
        }
    }
    //Inorder With Iteration
    public void traverseInorderWithIterative(Node root){
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(current);
        while (!stack.isEmpty()){
            while(current.left != null){
                current = current.left;
                stack.push(current);
            }
            current = stack.pop();
            visit(current);
            if(current.right != null){
                current = current.right;
                stack.push(current);
            }
        }
    }

    //2.3. Postorder Traversal
    public void traversePostorder(Node node){
        if(node!=null) {
            traversePreOrder(node.left);
            traversePreOrder(node.right);
            visit(node);
        }
    }
    //Postorder With Iteration
    public void traversePostOrderIterative(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node prev = root;
        Node current = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right ||
                    (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visit(current);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

    //3.1. Graph DFS with Recursion
    public void dfs(int start, Node root){
        boolean[] isVisited = new boolean[V];
        dfsRecursive(start, isVisited);
    }

    public void dfsRecursive(int current, boolean[] isVisited){
        isVisited[current] = true;
        visit(current);
        for(int node : adj[current]){
            if(!isVisited[node]){
                dfsRecursive(node, isVisited);
            }
        }
    }

    //3.2. Graph DFS Without Recursion
    public void dfsIterative(int start){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        stack.push(start);
        while(!stack.isEmpty()) {
            int current = stack.pop();
            if(!visited[current]){
                visited[current] = true;
                visit(current);
                for(int dest: adj[current]){
                    if(!visited[dest])
                        stack.push(dest);
                }
            }
        }
    }

    //3.4. Topological Sort
    public List<Integer> topologicalSort(int start) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        boolean[] isVisited = new boolean[V];
        topologicalSortRecursive(start, isVisited, result);
        return result;
    }

    private void topologicalSortRecursive(int current, boolean[] isVisited, LinkedList<Integer> result) {
        isVisited[current] = true;
        for (int dest : adj[current]) {
            if (!isVisited[dest])
                topologicalSortRecursive(dest, isVisited, result);
        }
        result.addFirst(current);
    }

    public void visit(Node node){
        //here the code to be traversed
    }

    public void visit(int node){
        //here the code to be traversed
    }

}
