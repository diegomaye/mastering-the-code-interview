package com.codeinterview.binnaryTree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
public class BinaryTreeTraversalBasisTest {

    @Test
    public void TestCase1() {
        var root = new BinaryTreeTraversalBasis.Node(10);
        root.left = new BinaryTreeTraversalBasis.Node(5);
        root.left.left = new BinaryTreeTraversalBasis.Node(2);
        root.left.left.left = new BinaryTreeTraversalBasis.Node(1);
        root.left.right = new BinaryTreeTraversalBasis.Node(5);
        root.right = new BinaryTreeTraversalBasis.Node(15);
        root.right.right = new BinaryTreeTraversalBasis.Node(22);

        List<Integer> inOrder = Arrays.asList(new Integer[] {1, 2, 5, 5, 10, 15, 22});
        List<Integer> preOrder = Arrays.asList(new Integer[] {10, 5, 2, 1, 5, 15, 22});
        List<Integer> postOrder = Arrays.asList(new Integer[] {1, 2, 5, 5, 22, 15, 10});

        assertTrue(BinaryTreeTraversalBasis.inOrderTraverse(root, new ArrayList<Integer>()).equals(inOrder));
        assertTrue(BinaryTreeTraversalBasis.preOrderTraverse(root, new ArrayList<Integer>()).equals(preOrder));
        assertTrue(BinaryTreeTraversalBasis.postOrderTraverse(root, new ArrayList<Integer>()).equals(postOrder));
    }
}
