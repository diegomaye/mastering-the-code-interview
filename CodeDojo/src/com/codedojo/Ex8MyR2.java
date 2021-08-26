package com.codedojo;

import java.util.Arrays;

public class Ex8MyR2 {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int a1[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        // rotate(a1, 3) should return:
        // [[7, 4, 1],
        //  [8, 5, 2],
        //  [9, 6, 3]]
        System.out.println(String.format("click(field2, 4, 4, 1, 3) returns:\n%s", printMatrix(rotate(a1, 3))));
        int a2[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        // rotate(a2, 4) should return:
        // [[13, 9, 5, 1],
        //  [14, 10, 6, 2],
        //  [15, 11, 7, 3],
        //  [16, 12, 8, 4]]
        System.out.println(String.format("click(field2, 4, 4, 1, 3) returns:\n%s", printMatrix(rotate(a2, 4))));
    }

    // Implement your solution below.
    public static int[][] rotate(int[][] a, int n) {
        // NOTE: To solve it in place, write this function so that you
        // won't have to create rotated.
        int[][] rotated = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                rotated[j][Math.abs(n-1-i)] = a[i][j];
        return rotated;
    }

    private static String printMatrix(int[][] toPrint){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i<toPrint.length;i++){
            builder.append(Arrays.toString(toPrint[i]));
            builder.append("\n");
        }
        return builder.toString();
    }
}
