package com.codedojo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex4MyNR {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        System.out.println(String.format("Para abcab: %c",nonRepeating("abcab"))); // should return 'c'
        System.out.println(String.format("Para abab: %c",nonRepeating("abab"))); // should return null
        System.out.println(String.format("Para aabbbc: %c",nonRepeating("aabbbc"))); // should return 'c'
        System.out.println(String.format("Para aabbdbc: %c",nonRepeating("aabbdbc"))); // should return 'd'
    }

    // Implement your solution below.
    public static Character nonRepeating(String s) {
        HashMap<Character, Integer> letterDiccionary = new HashMap<>();
        char[] letters =s.toCharArray();
        for(int i= 0; i<letters.length;i++){
            if(letterDiccionary.containsKey(letters[i])){
                letterDiccionary.put(letters[i], letterDiccionary.get(letters[i])+1);
            } else {
                letterDiccionary.put(letters[i],1);
            }
        }
        Iterator it = letterDiccionary.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Character, Integer> pair = (Map.Entry) it.next();
            if(pair.getValue() == 1)
                return pair.getKey();
        }
        return null;
    }
}
