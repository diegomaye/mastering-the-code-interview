package com.codeinterview.book;

import java.util.Arrays;

public class CCIEx12Permutation {
    private static String prueba1 = "Holaquetal";
    private static String prueba2 = "Chao";
    private static String prueba3 = "Chachara";
    private static String prueba4 = "qwertyuiopasdfghj";

    public static void main(String... arr){
        System.out.println(String.format("son iguales: %b", isPermutation(prueba1,prueba1)));
        System.out.println(String.format("son iguales: %b", isPermutation(prueba1,prueba2)));
        System.out.println(String.format("son iguales: %b", isPermutation(prueba1,prueba3)));
        System.out.println(String.format("son iguales: %b", isPermutation(prueba4,prueba4)));

        System.out.println(String.format("son iguales: %b", isPermutationWithChar(prueba1,prueba1)));
        System.out.println(String.format("son iguales: %b", isPermutationWithChar(prueba1,prueba2)));
        System.out.println(String.format("son iguales: %b", isPermutationWithChar(prueba1,prueba3)));
        System.out.println(String.format("son iguales: %b", isPermutationWithChar(prueba4,prueba4)));
    }

    private static boolean isPermutation(String first, String second){
        if(first.length() != second.length()) return false;
        else return sort(first).equals(sort(second));
    }

    private static String sort(String word){
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    private static boolean isPermutationWithChar(String first, String second){
        if(first.length() != second.length()) return false;
        else{
            int[] letter = new int[128];//Assumption ascii 256 & 128 alphabet
            char[] firstArray = first.toCharArray();
            for(char ch: firstArray){
                letter[ch]++;
            }
            for(int i = 0; i < second.length(); i++){
                char ch = second.charAt(i);
                letter[ch]--;
                if(letter[ch]<0){
                    return false;
                }
            }
        }
        return true;
    }
}
