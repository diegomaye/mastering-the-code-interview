package com.codeinterview.musthave.sort;
// Below implementation for quickSort:

public class QuickSortSwapFunc
{
    void quickSort(int arr[], int start, int end){
        if(start < end){
            int part = partition(arr, start, end);
            quickSort(arr, start, part - 1);
            quickSort(arr, part + 1, end);
        }
    }

    int partition(int arr[], int start, int end){
        int pivot = arr[end];
        int index = start - 1;
        for(int sectionIndex = start; sectionIndex < end; sectionIndex++){
            if(arr[sectionIndex] >= pivot){
                index++;
                swap(arr, sectionIndex, index);
            }
        }
        swap(arr, index + 1, end);
        return index + 1;
    }

    void swap(int arr[], int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
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

        QuickSortSwapFunc ob = new QuickSortSwapFunc();
        ob.quickSort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
/*This code is contributed by Rajat Mishra */
