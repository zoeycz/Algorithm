package add_and_search_word;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
  class TrieNode {
    char c;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;

    TrieNode() {}

    TrieNode(char c) {
      this.c = c;
    }
  }

  private TrieNode root = new TrieNode();

  // Adds a word into the data structure.
  public void addWord(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!curr.children.containsKey(c)) {
        curr.children.put(c, new TrieNode(c));
      }
      curr = curr.children.get(c);
    }
    curr.isWord = true;
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return find(word, root);
  }

  private boolean find(String word, TrieNode root) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c != '.' && !curr.children.containsKey(c)) {
        return false;
      } else if (c != '.') {
        curr = curr.children.get(c);
      } else {
        // Note: try all possibility; encounter true, return; else, return false when all false
        for (TrieNode node : curr.children.values()) {
          if (i == word.length() - 1) {
            if (node.isWord) {
              return true;
            }
          }
          if (find(word.substring(i + 1), node)) {
            return true;
          }
        }
        return false;
      }
    }
    return curr.isWord;
  }
}
