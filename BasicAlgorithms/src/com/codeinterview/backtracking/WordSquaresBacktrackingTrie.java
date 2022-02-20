package com.codeinterview.backtracking;
/**
 * Given an array of unique strings words, return all the word squares you can build from words.
 * The same word from words can be used multiple times. You can return the answer in any order.
 * A sequence of strings forms a valid word square if the kth row and column read the same string,
 * where 0 <= k < max(numRows, numColumns).
 *
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square because each
 * word reads the same both horizontally and vertically.
 * */

/**
 * Input: words = ["area","lead","wall","lady","ball"]
 * Output: [["ball","area","lead","lady"],["wall","area","lead","lady"]]
 * Explanation:
 * The output consists of two word squares. The order of output does not matter
 * */

/**
 * Input: words = ["abat","baba","atan","atal"]
 * Output: [["baba","abat","baba","atal"],["baba","abat","baba","atan"]]
 * Explanation:
 * The output consists of two word squares. The order of output does not matter
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @link https://leetcode.com/problems/word-squares/solution/
 * */
public class WordSquaresBacktrackingTrie {
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        List<Integer> wordList = new ArrayList<Integer>();

        public TrieNode() {}
    }

    int N = 0;
    String[] words = null;
    TrieNode trie = null;

    public List<List<String>> wordSquares(String[] words) {
        this.words = words;
        this.N = words[0].length();

        List<List<String>> results = new ArrayList<List<String>>();
        this.buildTrie(words);

        for (String word : words) {
            LinkedList<String> wordSquares = new LinkedList<String>();
            wordSquares.addLast(word);
            this.backtracking(1, wordSquares, results);
        }
        return results;
    }

    //O(n*L*26^L) time | O(n*L + n*L/2) space
    protected void backtracking(int step, LinkedList<String> wordSquares,
                                List<List<String>> results) {
        if (step == N) {
            results.add((List<String>) wordSquares.clone());
            return;
        }

        StringBuilder prefix = new StringBuilder();
        for (String word : wordSquares) {
            prefix.append(word.charAt(step));
        }

        for (Integer wordIndex : this.getWordsWithPrefix(prefix.toString())) {
            wordSquares.addLast(this.words[wordIndex]);
            this.backtracking(step + 1, wordSquares, results);
            wordSquares.removeLast();
        }
    }

    protected void buildTrie(String[] words) {
        this.trie = new TrieNode();

        for (int wordIndex = 0; wordIndex < words.length; ++wordIndex) {
            String word = words[wordIndex];

            TrieNode node = this.trie;
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
                node.wordList.add(wordIndex);
            }
        }
    }

    protected List<Integer> getWordsWithPrefix(String prefix) {
        TrieNode node = this.trie;
        for (Character letter : prefix.toCharArray()) {
            if (node.children.containsKey(letter)) {
                node = node.children.get(letter);
            } else {
                // return an empty list.
                return new ArrayList<Integer>();
            }
        }
        return node.wordList;
    }
}
