package com.codeinterview.binarySearch;

public class IterativeBinarySearch {

    //O(log(n)) time | O(1) space
    public int binarySearch(int[] array, int value)
    {
        int low = 0, high = array.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (value == array[mid]) {
                return mid;
            }
            else if (value < array[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
