package com.codeinterview.linkedlist;

public class LinkedListOperations {
    // This is an input class. Do not edit.
    static class LinkedList {
        public int value;
        public LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList current = linkedList;
        while(current != null){
            LinkedList nextNode = current.next;
            while(nextNode != null && nextNode.value == current.value){
                nextNode = nextNode.next;
            }
            current.next = nextNode;
            current = nextNode;
        }
        return linkedList;
    }
}
