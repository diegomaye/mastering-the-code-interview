package com.codeinterview.heap;

import java.util.ArrayList;
import java.util.List;
/**
 * Min Heap Construction
 * */
public class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    //O(n) time | O(1) space, buildHeap: using siftDown to build the tree then
    //it is O(log(n)) but for the majority of nodes (all nodes at the botton) time
    //complexity is O(0) since there is no computation, then total time complexity
    //for buildHeap is O(n): since algorithm needs to traverse all nodes.
    //IMPORTANT: in case of siftUp it will take O(n*log(n))
    public List<Integer> buildHeap(List<Integer> array) {
        int firstParentIdx = (array.size() - 2) / 2;
        for(int current = firstParentIdx; current >= 0; current--) {
            siftDown(current, array.size() - 1, array);
        }
        return array;
    }

    //O(log(n)) time | O(c) space since is similar to binary tree method
    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int childOneIdx = currentIdx * 2 + 1;
        while(childOneIdx <= endIdx) {
            int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
            int idxToSwap;
            if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)){
                idxToSwap = childTwoIdx;
            } else {
                idxToSwap = childOneIdx;
            }
            if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                swap(currentIdx, idxToSwap, heap);
                currentIdx = idxToSwap;
                childOneIdx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    //O(log(n)) time | O(c) space since is similar to binary tree method
    public void siftUp(int currentIdx, List<Integer> heap) {
        int parentIdx = (currentIdx - 1) / 2;
        while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
            swap(currentIdx, parentIdx, heap);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }

    public int peek() {
        return heap.get(0);
    }

    public int remove() {
        swap(0, heap.size() - 1, heap);
        int valueToRemove = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return valueToRemove;
    }

    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }

    public void swap(int i, int j, List<Integer> heap) {
        Integer temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }
}
