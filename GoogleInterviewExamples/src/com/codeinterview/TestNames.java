package com.codeinterview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TestNames {

    String[] values = new String[]{"Como funcionan los cohetes?",
            "Hello LeetCoder",
            "Mario Baracus",
            "Maxi Lopez",
            "Patineta Voladora",
            "Como funcionan los cohetes?",
            "Hello LeetCoder",
            "Hello LeetCoder",
            "Patineta Voladora",
            "Como funcionan los cohetes?",
            "Hello LeetCoder",
            "Como funcionan los cohetes?"};


    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low --> Starting index,
    high --> Ending index */
    static void qSort(int arr[], int low, int high)
    {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
            now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            qSort(arr, low, pi - 1);
            qSort(arr, pi + 1, high);
        }
    }
}
