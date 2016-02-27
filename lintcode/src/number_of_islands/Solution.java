package number_of_islands;

public class Solution {
  /**
   * @param grid a boolean 2D matrix
   * @return an integer
   */
  public int numIslands(boolean[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int n = grid.length;
    int m = grid[0].length;

    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j]) {
          count++;
          expand(grid, i, j);
        }
      }
    }

    return count;
  }

  private int[] dx = {1, -1, 0, 0};
  private int[] dy = {0, 0, 1, -1};

  private void expand(boolean[][] grid, int x, int y) {
    grid[x][y] = false;
    for (int k = 0; k < 4; k++) {
      if (x + dx[k] >= 0 && x + dx[k] < grid.length && y + dy[k] >= 0 && y + dy[k] < grid[0].length
          && grid[x + dx[k]][y + dy[k]]) {
        expand(grid, x + dx[k], y + dy[k]);
      }
    }
  }
}
