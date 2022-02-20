package com.codeinterview;

public class LongestPeek {

    public static void main(String... arg) {
        System.out.println("Devolución: " + longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}));
        System.out.println("Devolución: " + longestPeak(new int[]{1, 3, 2}));

    }
    // O(n) time | O(1) space
    public static int longestPeak(int[] array) {
        int longestPeek = 0;
        if(array.length < 3) return 0;

        for(int i = 1; i < array.length - 1; i++){
            if(array[i - 1] < array[i] && array[i] > array[i + 1]){
                int count = 1;
                int j = i - 1;
                while(j >= 0 && array[j] < array[j + 1]){
                    count++;
                    j--;
                }
                int k = i + 1;
                while(k < array.length && array[k] < array[k - 1]){
                    count++;
                    k++;
                }
                if(count > longestPeek){
                    longestPeek = count;
                }
            }
        }
        return longestPeek;
    }
}
