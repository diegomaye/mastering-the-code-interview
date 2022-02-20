package com.codeinterview.tires;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStringSearch {

    //O(b^2 + ns) time | O(b^2 + ns) space
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        ModifySuffixTrie multi = new ModifySuffixTrie(bigString);
        List<Boolean> matchResult = new ArrayList<>();

        for(int i = 0; i < smallStrings.length; i++){
            matchResult.add(multi.contains(smallStrings[i]));
        }
        return matchResult;
    }

    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
    }


    static class ModifySuffixTrie{
        TrieNode root = new TrieNode();

        public ModifySuffixTrie(String str){
            loadStringInTrie(str);
        }

        //O(b^2)
        public void loadStringInTrie(String str){
            for(int i = 0; i < str.length(); i++) {
                insertSubstringInTrieAt(i, str);
            }
        }

        public void insertSubstringInTrieAt(int i, String str){
            TrieNode node = root;
            for(int j = i; j < str.length(); j++){
                char letter = str.charAt(j);
                if(!node.children.containsKey(letter)){
                    TrieNode newTrieNode = new TrieNode();
                    node.children.put(letter, newTrieNode);
                }
                node = node.children.get(letter);
            }
        }

        //O(ns)
        public boolean contains(String str) {
            TrieNode current = root;
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!current.children.containsKey(letter)) {
                    return false;
                }
                current = current.children.get(letter);
            }
            return true;
        }
    }
}
