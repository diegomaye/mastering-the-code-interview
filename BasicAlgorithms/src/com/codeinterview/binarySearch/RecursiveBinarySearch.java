package com.codeinterview.binarySearch;

public class RecursiveBinarySearch {

    //O(log(n)) time | O(log(n)) space
    public int binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length-1);
    }

    public int binarySearch(int[] array, int value, int start, int end) {
        if (start > end) {
            return -1;
        }
        else{
            int mid = (start + end) / 2;
            if (value == array[mid]) {
                return mid;
            }
            else if (value < array[mid]) {
                return binarySearch(array, value, start, mid - 1);
            }
            else {
                return binarySearch(array, value, mid + 1, end);
            }
        }
    }
}
