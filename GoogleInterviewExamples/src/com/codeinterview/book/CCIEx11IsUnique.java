package com.codeinterview.book;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 * */

public class CCIEx11IsUnique {

    private static String prueba1 = "Holaquetal";
    private static String prueba2 = "Chao";
    private static String prueba3 = "Chachara";
    private static String prueba4 = "qwertyuiopasdfghj";

    public static void main(String[] args) {
        System.out.println(String.format("para el string Holaquetal: %b", isUniqueCharacters(prueba1)));
        System.out.println(String.format("para el string Chao: %b", isUniqueCharacters(prueba2)));
        System.out.println(String.format("para el string Chachara: %b", isUniqueCharacters(prueba3)));
        System.out.println(String.format("para el string qwertyuiopasdfghj: %b", isUniqueCharacters(prueba4)));

        System.out.println(String.format("para el string Holaquetal: %b", isUniqueBookApproach(prueba1)));
        System.out.println(String.format("para el string Chao: %b", isUniqueBookApproach(prueba2)));
        System.out.println(String.format("para el string Chachara: %b", isUniqueBookApproach(prueba3)));
        System.out.println(String.format("para el string qwertyuiopasdfghj: %b", isUniqueBookApproach(prueba4)));

    }
    /**
     * Brute force O(n^2)
     * */
    private static boolean isUniqueCharacters(String word){
        if(word.length() == 0) return true;
        char[] letters = word.toCharArray();
        int executions = 0;
        for(int i = 0; i < letters.length; i++){
            for(int j = i + 1; j < letters.length; j++){
                executions++;
                if (letters[i] == letters [j]) {
                    System.out.println(executions);
                    return false;
                }
            }
        }
        System.out.println(executions);
        return true;
    }

    /**
     * Use boolean array like hash map where indices are key value for position
     * Time complexity is O(n), Space Complexity O(1): since will be no more than 128 chars
     * We can argue that time complexity is 0(1), since the for loop will never iterate through
     * more than 128 characters.
     * O( c) time, where c is the size of the character set.
     * */
    private static boolean isUniqueBookApproach(String word){
        if(word.length() > 128) return false;
        boolean[] char_visit = new boolean[128];
        int executions = 0;

        for(int i = 0; i<word.length(); i++){
            int charAt = word.charAt(i);
            executions++;
            if(char_visit[charAt] == false) char_visit[charAt] = true;
            else {
                System.out.println(executions);
                return false;
            }
        }
        System.out.println(executions);
        return true;
    }
}
