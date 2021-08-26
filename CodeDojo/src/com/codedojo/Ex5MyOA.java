package com.codedojo;

import java.util.ArrayList;
import java.util.List;

public class Ex5MyOA {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        System.out.println(String.format("String \"abcde\", \"abcd\" returns: %b", isOneAway("abcde", "abcd")));  // should return true
        System.out.println(String.format("String \"abde\", \"abcde\" returns: %b", isOneAway("abde", "abcde")));  // should return true
        System.out.println(String.format("String \"a\", \"a\" returns: %b", isOneAway("a", "a")));  // should return true
        System.out.println(String.format("String \"abcdef\", \"abqdef\" returns: %b", isOneAway("abcdef", "abqdef")));  // should return true
        System.out.println(String.format("String \"abcdef\", \"abccef\" returns: %b", isOneAway("abcdef", "abccef")));  // should return true
        System.out.println(String.format("String \"abcdef\", \"abcde\" returns: %b", isOneAway("abcdef", "abcde")));  // should return true
        System.out.println(String.format("String \"aaa\", \"abc\" returns: %b", isOneAway("aaa", "abc")));  // should return false
        System.out.println(String.format("String \"abcde\", \"abc\" returns: %b", isOneAway("abcde", "abc")));  // should return false
        System.out.println(String.format("String \"abc\", \"abcde\" returns: %b", isOneAway("abc", "abcde")));  // should return false
        System.out.println(String.format("String \"abc\", \"bcc\" returns: %b", isOneAway("abc", "bcc")));  // should return false
    }
    private static boolean equalEval(char[] listS1, char[] listS2){
        int count = 0;
        for(int i=0; i< listS1.length;i++){
            if (listS1[i] != listS2[i]){
                count++;
            }
        }
        if(count<=1){
            return true;
        } else {
            return false;
        }
    }

    private static boolean diffEval(char[] listS1, char[] listS2){
        int i = 0, count = 0;
        while (i < listS2.length) {
            if (listS1[i+count] != listS2[i]) {
                count++;
            } else {
                i++;
            }
        }
        if(count<=1){
            return true;
        } else {
            return false;
        }
    }

    // Implement your solution below.
    public static Boolean isOneAway(String s1, String s2) {
        char[] listS1 = s1.toCharArray();
        char[] listS2 = s2.toCharArray();
        int count = 0;
        if( listS1.length == listS2.length | Math.abs(listS1.length - listS2.length)<2 ) {
            if (listS1.length == listS2.length) {
                return equalEval(listS1, listS2);
            } else if (listS1.length > listS2.length) {
                return diffEval(listS1, listS2);
            } else if (listS1.length < listS2.length) {
                return diffEval(listS2, listS1);
            } else {
                return false;
            }
        }
        else return false;
    }

}
