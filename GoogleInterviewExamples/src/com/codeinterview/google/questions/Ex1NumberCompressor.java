package com.codeinterview.google.questions;

import java.util.*;

public class Ex1NumberCompressor {
    public static void main(String... arr){
        //System.out.println(String.format("2[2[ab]c]4[z] results in: %s", decompressor("2[2[ab]c]4[z]".length(),-1,"","2[2[ab]c]4[z]")));
        System.out.println(String.format("2[2[ab]c]4[z] results in: %s", decoder2("2[2[ab]c]4[z]")));

    }

    public static String getWord(int pos, String word){
        StringBuilder builder = new StringBuilder();

        int index = pos;
        char letter = word.charAt(pos);

        while(Character.isLetter(letter)){
            builder.append(letter);
            index++;
            letter = word.charAt(index);
        }

        return builder.toString();
    }

    public static String getNumber(int pos, char[] compressed){
        int finishIndex = pos;
        int initialIndex = finishIndex;
        String number = "";
        while(initialIndex>=0 && Character.isDigit(compressed[initialIndex])){
            number += String.valueOf(compressed[finishIndex]);
            initialIndex--;
        }
        return number;
    }

    public static String decompressor(int index, int pos, String word, String words){
        if(words.indexOf('[')==-1){
            return words;
        } else {
            index--;
            if(Character.isLetter(words.charAt(index))) {
                word += words.charAt(index);
            } else if(words.charAt(index) == ']') {
                pos = index;
            } else if(words.charAt(index) == '[') {
                String number = getNumber(index-1, words.toCharArray());
                String total = "";
                for(int i = 0; i < Integer.valueOf(number); i++){
                    total += word;
                }
                words = words.substring(0, index - number.length()) + total + words.substring(pos + 1, words.length());
                pos = -1;
                word = "";
                index = index - number.length();
            }
            return decompressor(index, pos, word, words);
        }
    }

    public class Parenthesis{
        int index;
        boolean left;

        public Parenthesis(int index, boolean left) {
            this.index = index;
            this.left = left;
        }

        public boolean isLeft(){
            return left;
        }
        public boolean isRight(){
            return !left;
        }
        public void willBeRight(){
            left = false;
        }
        public void willBeLeft(){
            left = true;
        }
    }

    public String decode(String text){
        char[] characters = text.toCharArray();
        List<Parenthesis> parenthesisList = new ArrayList<>();
        for(int i = 0; i < characters.length; i++){
            if(characters[i] == '['){
                parenthesisList.add(new Parenthesis(i,true));
            } else if(characters[i] == ']'){
                parenthesisList.add(new Parenthesis(i,false));
            }
        }
        for(int i = parenthesisList.size() - 1; i >=0; i--){

        }
        return "";
    }

    public static String decoder2(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        for(int i = 0; i < n; i++) dp[i][i] = "" + s.charAt(i);
        // j - i
        for(int len = 1; len < n; len++) {
            for(int i = 0; i + len < n; i++) {
                int j = i + len;
                // enumerate seperate k
                for(int k = i; k < j; k++) {
                    int left = dp[i][k].length();
                    int right = dp[k+1][j].length();
                    // update shortest encoded string within (i, j)
                    if(dp[i][j] == null || left + right < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k+1][j];
                    }
                }
                // update string within (i, j), encode abcabc
                String sub = s.substring(i, j + 1);
                int index = (sub + sub).indexOf(sub, 1);
                if(index < sub.length()) {
                    sub = (sub.length() / index) + "[" + dp[i][i+index-1] + "]";
                }
                if(dp[i][j] == null || dp[i][j].length() > sub.length()) {
                    dp[i][j] = sub;
                }
            }
        }
        return dp[0][n-1];
    }
}
