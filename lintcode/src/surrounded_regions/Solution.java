package surrounded_regions;

public class Solution {
  /**
   * @param board a 2D board containing 'X' and 'O'
   * @return void
   */
  public void surroundedRegions(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }
    int n = board.length;
    int m = board[0].length;

    // Start from four sides to free nodes
    for (int i = 0; i < m; i++) {
      free(board, 0, i);
      free(board, n - 1, i);
    }

    for (int i = 1; i < n - 1; i++) {
      free(board, i, 0);
      free(board, i, m - 1);
    }
    // Flip the non-free nodes
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 'F') {
          board[i][j] = 'O';
        } else {
          board[i][j] = 'X';
        }
      }
    }
  }

  private int[] dx = {1, -1, 0, 0};
  private int[] dy = {0, 0, 1, -1};

  private void free(char[][] board, int x, int y) {
    if (board[x][y] != 'O') {
      return;
    }

    board[x][y] = 'F';
    for (int k = 0; k < 4; k++) {
      int i = x + dx[k];
      int j = y + dy[k];
      if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
        free(board, i, j);
      }
    }
  }
}
