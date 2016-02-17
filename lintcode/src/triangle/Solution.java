package triangle;

public class Solution {
  /**
   * Source: http://www.lintcode.com/en/problem/triangle/
   * 
   * Complexity: Time: O(n^2), Space: O(n^2)
   * 
   * @param triangle: a list of lists of integers.
   * @return: An integer, minimum path sum.
   */
  public int minimumTotal(int[][] triangle) {
    if (triangle == null || triangle.length == 0) {
      return -1;
    }
    if (triangle[0] == null || triangle[0].length == 0) {
      return -1;
    }
    int n = triangle.length;
    int[][] f = new int[n][n];

    // Initialize from bottom
    for (int i = 0; i < n; i++) {
      f[n - 1][i] = triangle[n - 1][i];
    }

    // Going up
    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        f[i][j] = triangle[i][j] + Math.min(f[i + 1][j], f[i + 1][j + 1]);
      }
    }

    // Summarize
    return f[0][0];
  }
}

