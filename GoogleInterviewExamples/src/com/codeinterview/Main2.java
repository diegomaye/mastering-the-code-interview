package com.codeinterview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main2 {
    public static void main(String... arr){
        System.out.println((new Main2()).lengthOfLongestSubstring("aab"));
    }

    public int lengthOfLongestSubstring(String s) {

        char[] letters = s.toCharArray();
        return subStringCounter(letters);
    }

    int subStringCounter(char[] letters){
        Set<Character> lettersSet = new HashSet<>();
        int count = 0;
        int theOtherOne = 0;
        for(int i = 0; i < letters.length; i++){
            if(lettersSet.contains(letters[i])){
                theOtherOne = subStringCounter(Arrays.copyOfRange(letters, i, letters.length));
                break;
            }
            else{
                lettersSet.add(letters[i]);
                count++;
            }
        }
        return (count>theOtherOne)?count:theOtherOne;
    }
}
