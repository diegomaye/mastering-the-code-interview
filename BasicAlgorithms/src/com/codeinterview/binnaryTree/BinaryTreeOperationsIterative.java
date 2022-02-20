package com.codeinterview.binnaryTree;
/**
 * Below basic iterative operations for binary tree: less intuitive than recursive operations, but consumes less space.
 *  insert
 *  contains
 *  remove
 * */
public class BinaryTreeOperationsIterative {
    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        /**
         * Average: O(log(n)) time | O(1) space
         * Worst case: O(n) time | O(1) space
         * */
        public Node insert(int value) {
            Node current = this;
            while(true){
                if(value < current.value){
                    if(current.left == null){
                        current.left = new Node(value);
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if(current.right == null){
                        current.right = new Node(value);
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
            return this;
        }

        public boolean contains(int value) {
            Node current = this;
            while(current != null){
                if(value < current.value){
                    current = current.left;
                } else if (value > current.value) {
                    current = current.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        public Node remove(int value) {
            remove(value, null);
            return this;
        }

        public void remove(int value, Node parent){
            Node current = this;
            while(current != null){
                if(value < current.value){
                    parent = current;
                    current = current.left;
                } else if(value > current.value){
                    parent = current;
                    current = current.right;
                } else {
                    if(current.left != null && current.right !=null){
                        current.value = current.right.getMinValue();
                        current.right.remove(current.value, current);
                    } else if (parent == null){
                        if(current.left != null){
                            current.value = current.left.value;
                            current.right = current.left.right;
                            current.left = current.left.left;
                        } else if(current.right != null){
                            current.value = current.right.value;
                            current.left = current.right.left;
                            current.right = current.right.right;
                        } else {
                            //single-node case; do nothing
                        }
                    } else if (parent.left == current) {
                        parent.left = current.left !=null ? current.left : current.right;
                    } else if (parent.right == current) {
                        parent.right = current.left !=null ? current.left : current.right;
                    }
                    break;
                }
            }
        }

        public int getMinValue(){
            if(left == null){
                return value;
            } else {
                return left.getMinValue();
            }
        }

    }
}
