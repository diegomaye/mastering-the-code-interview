package com.codedojo;

import java.util.Arrays;

public class Ex6MyMS {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] bombs1 = {{0, 2}, {2, 0}};
        System.out.println(String.format("mineSweeper(bombs1, 3, 3) returns:\n%s", printMatrix(mineSweeper(bombs1, 3, 3))));
        // mineSweeper(bombs1, 3, 3) should return:
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        System.out.println(String.format("mineSweeper(bombs2, 3, 4) returns:\n%s", printMatrix(mineSweeper(bombs2, 3, 4))));
        // mineSweeper(bombs2, 3, 4) should return:
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        System.out.println(String.format("mineSweeper(bombs3, 5, 5) returns:\n%s", printMatrix(mineSweeper(bombs3, 5, 5))));
        // mineSweeper(bombs3, 5, 5) should return:
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]
    }

    private static String printMatrix(int[][] toPrint){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i<toPrint.length;i++){
            builder.append(Arrays.toString(toPrint[i]));
            builder.append("\n");
        }
        return builder.toString();
    }

    // Implement your solution below.
    public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];
        loadMinePanel(bombs, field);
        for(int bomb = 0; bomb<bombs.length; bomb++) {
            field = mineSweeperBoomInsertion(bombs[bomb][0], bombs[bomb][1], field);
        }
        return field;
    }

    private static int[][] loadMinePanel(int[][] bombs, int[][] field){
        for(int bomb = 0; bomb<bombs.length; bomb++) {
            field[bombs[bomb][0]][bombs[bomb][1]] = -1;
        }
        return field;
    }

    private static int[][] mineSweeperBoomInsertion(int bombX, int bombY, int[][] field){
        for(int i = bombX - 1; i <= bombX + 1; i++){
            for(int j = bombY - 1; j<= bombY + 1; j++){
                if(field.length > i && i >= 0 &&
                        field[i].length > j && j >= 0 &&
                        field[i][j] != -1){
                    field[i][j] += 1;
                }
            }
        }
        return field;
    }
}
