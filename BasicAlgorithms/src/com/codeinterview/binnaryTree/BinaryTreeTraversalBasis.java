package com.codeinterview.binnaryTree;

import java.util.List;

/**
 *
 * When it comes to binary trees, there are several different types of traversals that can be done recursively.
 * They're written in the order they're referenced then visited (L=Left child, V = visit that node, R = right child).
 *
 *  - In-order traversal (LVR)
 *  - Reverse order traversal (RVL)
 *  - Preorder traversal (VLR)
 *  - Postorder traversal (LRV)
 * */
public class BinaryTreeTraversalBasis {

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String... arr){

    }

    // Academic
    public void traverse (Node root){ // Each child of a tree is a root of its subtree.
        if (root.left != null){
            traverse (root.left);
        }
        System.out.println(root.value);
        if (root.right != null){
            traverse (root.right);
        }
    }

    //Inorder: First left, then the tree root and finish with right
    // O(n) time | O(n) space
    public static List<Integer> inOrderTraverse(Node tree, List<Integer> array) {
        if(tree.left != null){
            inOrderTraverse(tree.left, array);
        }
        array.add(tree.value);
        if(tree.right != null){
            inOrderTraverse(tree.right, array);
        }
        return array;
    }
    //Preorder: First tree root, then left and finish with right.
    //O(n) time | O(n) space
    public static List<Integer> preOrderTraverse(Node tree, List<Integer> array) {
        array.add(tree.value);
        if(tree.left != null){
            preOrderTraverse(tree.left, array);
        }
        if(tree.right != null){
            preOrderTraverse(tree.right, array);
        }
        return array;
    }

    //Postorder: First left then right finishing with root
    //O(n) time | O(n) space
    public static List<Integer> postOrderTraverse(Node tree, List<Integer> array) {

        if(tree.left != null){
            postOrderTraverse(tree.left, array);
        }
        if(tree.right != null){
            postOrderTraverse(tree.right, array);
        }
        array.add(tree.value);
        return array;
    }
}
