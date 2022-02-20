package com.codeinterview.tires;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuffixTrieConstructionTest {
    @Test
    public void TestCase1() {
        var trie = new SuffixTrieConstruction.SuffixTrie("babc");
        assertTrue(trie.contains("abc"));
    }

    @Test
    public void TestCase2() {
        var trie = new SuffixTrieConstruction.SuffixTrie("babc");
        assertFalse(trie.contains("abcd"));
    }

    @Test
    public void TestCase3() {
        var trie = new SuffixTrieConstruction.SuffixTrie("pedro");
        assertTrue(trie.contains("ro"));
    }

    @Test
    public void TestCase4() {
        var trie = new SuffixTrieConstruction.SuffixTrie("maracaibo");
        assertTrue(trie.contains("caibo"));
    }
}
