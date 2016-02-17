package minimum_path_sum;

public class Solution {
  /**
   * @param grid: a list of lists of integers.
   * @return: An integer, minimizes the sum of all numbers along its path
   */
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return -1;
    }
    if (grid[0] == null || grid[0].length == 0) {
      return -1;
    }

    int m = grid.length;
    int n = grid[0].length;
    int[][] f = new int[m][n];

    // Initialize top and left
    f[0][0] = grid[0][0];
    for (int i = 1; i < m; i++) {
      f[i][0] = f[i - 1][0] + grid[i][0];
    }

    for (int i = 1; i < n; i++) {
      f[0][i] = f[0][i - 1] + grid[0][i];
    }

    // [i,j] comes from {[i-1][j], [i][j-1]}
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        f[i][j] = grid[i][j] + Math.min(f[i - 1][j], f[i][j - 1]);
      }
    }

    // Summarize
    return f[m - 1][n - 1];
  }
}

