package com.codeinterview;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiralTraverse {
    public static void main(String... arr){
        System.out.println("{\n" +
                "  \"array\": [\n" +
                "    [1,   2,  3, 4],\n" +
                "    [12, 13, 14, 5],\n" +
                "    [11, 16, 15, 6],\n" +
                "    [10,  9,  8, 7]\n" +
                "  ]\n" +
                "}");
//        int[][] array = new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
//        List<Integer> inline = spiralTraverse(array);
//        System.out.println(inline);

        int[][] array = new int[][]{{1, 3, 2, 5, 4, 7, 6}};
        List<Integer> inline = spiralTraverse(array);
        System.out.println(inline);

        int[][] array2 = new int[][]{{1}};
        List<Integer> inline1 = spiralTraverse(array2);
        System.out.println(inline1);
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for(int sc= 0, ec = array[0].length-1, sr = 0, er = array.length-1;
            sc<=ec;sc++,sr++,ec--,er--){
            if(er==0){
                result.addAll(perimeter(sc,ec,sr,er,array));
                break;
            } else {
                result.addAll(perimeter(sc, ec, sr, er, array));
            }
        }
        return result;
    }

    private static List<Integer> perimeter(int startCol, int endCol, int startRow, int endRow, int[][] array){
        List<Integer> result = new ArrayList<>();
        if (startCol == endCol && startRow == endRow) {
            result.add(array[startCol][startRow]);
            return result;
        }
        int sC=startCol, sR=startRow, eC=endCol, eR=endRow;

        while(sC < endCol){
            result.add(array[startRow][sC]);
            sC++;
        }

        while(sR < endRow){
            result.add(array[sR][endCol]);
            sR++;
        }

        while(eC > startCol){
            result.add(array[endRow][eC]);
            eC--;
        }

        while(eR > startRow){
            result.add(array[eR][startCol]);
            eR--;
        }
        return result;
    }
}
