package implement_trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Your Trie object will be instantiated and called as such: Trie trie = new Trie();
 * trie.insert("lintcode"); trie.search("lint"); will return false trie.startsWith("lint"); will
 * return true
 */
class TrieNode {
  char c;
  Map<Character, TrieNode> children = new HashMap<>();
  boolean isString = false;

  public TrieNode() {}

  public TrieNode(char c) {
    this.c = c;
  }
}


public class Solution {
  private TrieNode root;

  public Solution() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!curr.children.containsKey(c)) {
        curr.children.put(c, new TrieNode(c));
      }
      curr = curr.children.get(c);
    }
    curr.isString = true;
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!curr.children.containsKey(c)) {
        return false;
      }
      curr = curr.children.get(c);
    }
    return curr.isString;
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String prefix) {
    TrieNode curr = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (!curr.children.containsKey(c)) {
        return false;
      }
      curr = curr.children.get(c);
    }
    return true;
  }
}
