package com.codeinterview.binnaryTree;
/**
 * Below basic recursive operations for binary tree: more intuitive, less code, but consume extra space
 * because the stack produced by the system to stack each recursion call.
 *  insert
 *  contains
 *  remove
 * */
public class BinaryTreeOperationsRecursive {
    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        /**
         * Average: O(log(n)) time | O(log(n)) space
         * Worst case: O(n) time | O(n) space
         * */
        public Node insert(int value) {
            if(value < this.value){
                if(this.left == null){
                    this.left = new Node(value);
                } else {
                    left.insert(value);
                }
            } else {
                if(this.right == null){
                    this.right = new Node(value);
                } else {
                    right.insert(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            if(value < this.value){
                if(left == null){
                    return false;
                } else {
                    return left.contains(value);
                }
            } else if(value > this.value){
                if(right == null){
                    return false;
                } else {
                    return right.contains(value);
                }
            } else {
                return true;
            }
        }

        public Node remove(int value) {
            remove(value, null);
            return this;
        }

        public void remove(int value, Node parent) {
            if(value < this.value){
                if(left != null){
                    left.remove(value, this);
                }
            } else if(value > this.value){
                if(right != null) {
                    right.remove(value, this);
                }
            } else {
                if(left != null && right != null){
                    this.value = right.getMinValue();
                    right.remove(this.value, this);
                } else if(parent == null) {
                    if(left != null){
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    } else if (right != null){
                        this.value = right.value;
                        left = right.left;
                        right = right.right;
                    } else {
                        //single-node tree; do nothing
                    }
                } else if (parent.left == this){
                    parent.left = left != null ? left : right;
                } else if (parent.right == this){
                    parent.right = left != null ? left : right;
                }
            }
        }

        public int getMinValue(){
            if(left == null){
                return this.value;
            } else {
                return left.getMinValue();
            }
        }

    }
}
