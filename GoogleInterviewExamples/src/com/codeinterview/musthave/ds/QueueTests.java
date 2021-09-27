package com.codeinterview.musthave.ds;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTests {
    public static void main(String... arr){
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(5);
        System.out.println("peek " + queue.peek());
        System.out.println("poll " + queue.poll());
        System.out.println("peek " + queue.peek());
        System.out.println("remove " + queue.remove());
        System.out.println("peek " + queue.peek());
    }
}
