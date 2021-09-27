package com.codeinterview.musthave.sort;
// Below implementation for mergeSort:

import java.util.HashMap;
import java.util.Map;

public class MergeSort
{
    /**
     * Merge sort is similar to queckSort, but pivot is allways the middle of the array.
     * */
    void mergeSort(int[] arr, int start, int end){

        if(start < end){

        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
/*This code is contributed by Rajat Mishra */
