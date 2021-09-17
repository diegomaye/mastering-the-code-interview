package com.codeinterview.musthave;

import com.codeinterview.musthave.dfs.GraphAdjList;

import java.util.Stack;

public class MH3MatchingParentesis {
    public static void main(String... arr){
        String exampleChar1 = "[{(}]";
        String exampleChar2 = "(()}";
        String exampleChar3 = "[{()}]";
        String exampleChar4 = "[{";
        System.out.println(matchingParenthesis(exampleChar1));
        System.out.println(matchingParenthesis(exampleChar2));
        System.out.println(matchingParenthesis(exampleChar3));
        System.out.println(matchingParenthesis(exampleChar4));



    }

    public static boolean matchingParenthesis(String text){
        Stack<Character> stack = new Stack<>();
        char[] characters = text.toCharArray();
        for(int i = 0; i < characters.length; i++){
            if(characters[i] == '(' || characters[i] == '[' || characters[i] == '{'){
                stack.add(characters[i]);
            } else if(characters[i] == ')' || characters[i] == ']' || characters[i] == '}'){
                if(isMatching(characters[i], stack.peek()))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatching(char character, char characterToCheck){
        if(character == ')' && characterToCheck == '('){
            return true;
        } else if(character == ']' && characterToCheck == '['){
            return true;
        } else if(character == '}' && characterToCheck == '{'){
            return true;
        }
        return false;
    }
}
