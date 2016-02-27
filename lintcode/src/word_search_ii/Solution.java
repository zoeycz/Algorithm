package word_search_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  class TrieNode {
    char c;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;

    TrieNode() {}

    TrieNode(char c) {
      this.c = c;
    }
  }

  class TrieTree {
    TrieNode root;

    TrieTree(TrieNode root) {
      this.root = root;
    }

    void insert(String word) {
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

    boolean startWith(String prefix) {
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

    boolean contains(String word) {
      TrieNode curr = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (!curr.children.containsKey(c)) {
          return false;
        }
        curr = curr.children.get(c);
      }
      return curr.isWord;
    }
  }

  /**
   * @param board: A list of lists of character
   * @param words: A list of string
   * @return: A list of string
   */
  public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
    ArrayList<String> rst = new ArrayList<>();
    if (words == null || words.size() == 0 || board == null || board.length == 0
        || board[0].length == 0) {
      return rst;
    }

    // Construct a Trie Tree with words
    TrieNode root = new TrieNode();
    TrieTree tree = new TrieTree(root);
    for (String word : words) {
      tree.insert(word);
    }

    // Go through the board, bfs to see if there's a word
    int n = board.length;
    int m = board[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        bfs(board, i, j, tree, new StringBuilder(""), rst);
      }
    }

    return rst;
  }

  private int[] dx = {1, -1, 0, 0};
  private int[] dy = {0, 0, 1, -1};

  private void bfs(char[][] board, int x, int y, TrieTree tree, StringBuilder sb,
      ArrayList<String> rst) {
    // Note: For bfs able to track full length, append have to happen before judge
    char c = board[x][y];
    sb.append(c);
    board[x][y] = '0';

    if (!tree.startWith(sb.toString())) {
      // Note: recover before return
      board[x][y] = c;
      sb.deleteCharAt(sb.length() - 1);
      return;
    }
    if (tree.contains(sb.toString())) {
      if (!rst.contains(sb.toString())) {
        rst.add(sb.toString());
      }
    }


    for (int k = 0; k < 4; k++) {
      int i = x + dx[k];
      int j = y + dy[k];
      if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] != '0') {
        bfs(board, i, j, tree, sb, rst);
      }
    }
    board[x][y] = c;
    sb.deleteCharAt(sb.length() - 1);
  }
}
