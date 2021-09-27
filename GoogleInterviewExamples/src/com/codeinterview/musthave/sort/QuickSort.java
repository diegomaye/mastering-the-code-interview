package com.codeinterview.musthave.sort;
// Below implementation for quickSort:

public class QuickSort
{
    /**
     * Partition function on quick sort: is basically in charge to determine
     * the pivot and move array to correct position (smaller than pivot, to left, greater
     * than to right).
     * */
    int partition(int arr[], int low, int high){
        int pivot = arr[high];//algorithm takes high element as pivot
        int i = low-1; // getting index of smallest element
        for (int j=low; j<high; j++){
            if (arr[j] >= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    void quickSort(int arr[], int start, int end){
        if (start < end){
            int pi = partition(arr, start, end);
            quickSort(arr, start, pi-1);
            quickSort(arr, pi+1, end);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]){
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

        QuickSort ob = new QuickSort();
        ob.quickSort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
/*This code is contributed by Rajat Mishra */
