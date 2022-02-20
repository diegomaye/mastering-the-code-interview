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
public class WordSquaresBacktrackingHash {
    int N = 0;
    String[] words = null;
    HashMap<String, List<String>> prefixHashTable = null;

    public List<List<String>> wordSquares(String[] words) {
        this.words = words;
        this.N = words[0].length();

        List<List<String>> results = new ArrayList<List<String>>();
        this.buildPrefixHashTable(words);

        for (String word : words) {
            LinkedList<String> wordSquares = new LinkedList<String>();
            wordSquares.addLast(word);
            this.backtracking(1, wordSquares, results);
        }
        return results;
    }

    //O(n*26^L) time | O(n*L+n*L/2) = O(n*L) space where L is length of single word & n is the number
    //of input words
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

        for (String candidate : this.getWordsWithPrefix(prefix.toString())) {
            wordSquares.addLast(candidate);
            this.backtracking(step + 1, wordSquares, results);
            wordSquares.removeLast();
        }
    }

    protected void buildPrefixHashTable(String[] words) {
        this.prefixHashTable = new HashMap<String, List<String>>();

        for (String word : words) {
            for (int i = 1; i < this.N; ++i) {
                String prefix = word.substring(0, i);
                List<String> wordList = this.prefixHashTable.get(prefix);
                if (wordList == null) {
                    wordList = new ArrayList<String>();
                    wordList.add(word);
                    this.prefixHashTable.put(prefix, wordList);
                } else {
                    wordList.add(word);
                }
            }
        }
    }

    protected List<String> getWordsWithPrefix(String prefix) {
        List<String> wordList = this.prefixHashTable.get(prefix);
        return (wordList != null ? wordList : new ArrayList<String>());
    }
}
