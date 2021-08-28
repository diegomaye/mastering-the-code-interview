package com.codedojo;

class Node{

    int value;
    Node child;

    public Node(int value, Node link){
        this.value = value;
        this.child = link;
    }
}

public class Ex9MyNth {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        Node current = new Node(1, null);
        for (int i = 2; i < 8; i++) {
            current = new Node(i, current);
        }
        Node head = current;
        // head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)

        Node current2 = new Node(4, null);
        for (int i = 3; i > 0; i--) {
            current2 = new Node(i, current2);
        }
        Node head2 = current2;
        // head2 = 1 -> 2 -> 3 -> 4 -> (null)

        // nthFromLast(head, 1) should return 1.
        System.out.println(String.format("nthFromLast(head, 1) returns:\n%s", linkedListToString(nthFromLast(head, 1))));
        // nthFromLast(head, 5) should return 5.
        System.out.println(String.format("nthFromLast(head, 5) returns:\n%s", linkedListToString(nthFromLast(head, 5))));
        // linkedListToString(nthFromLast(head2, 2) should return 3.
        System.out.println(String.format("nthFromLast(head2, 2) returns:\n%s", linkedListToString(nthFromLast(head2, 2))));
        // nthFromLast(head2, 4) should return 1.
        System.out.println(String.format("nthFromLast(head2, 4) returns:\n%s", linkedListToString(nthFromLast(head2, 4))));
        // nthFromLast(head2, 5) should return null.
        System.out.println(String.format("nthFromLast(head2, 5) returns:\n%s", linkedListToString(nthFromLast(head2, 5))));
        // nthFromLast(null, 1) should return null.
        System.out.println(String.format("nthFromLast(null, 1) returns:\n%s", linkedListToString(nthFromLast(null, 1))));
    }

    // Implement your function below.
    public static Node nthFromLast(Node head, int n) {
        Node nodeLeft = head;
        Node nodeRight = head;
        int i = 0;
        while( i <= n && nodeRight != null){
            if (i != n) {
                nodeRight = nodeRight.child;
            }
            i++;
        }
        if (i != n && nodeRight == null) return null;
        else return goThrough(nodeLeft, nodeRight);
    }

    private static Node goThrough(Node nodeLeft, Node nodeRight){
        if(nodeRight == null)
            return nodeLeft;
        else
            return goThrough(nodeLeft.child, nodeRight.child);
    }

    //  NOTE: Feel free to use the following function for testing.
    //  It converts the given linked list into an easy-to-read string format.
    //  Example: 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
    public static String linkedListToString(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(String.valueOf(current.value));
            sb.append(" -> ");
            current = current.child;
        }
        sb.append("(null)");
        return sb.toString();
    }
}