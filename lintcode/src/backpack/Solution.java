package backpack;

public class Solution {
  /**
   * @param m: An integer m denotes the size of a backpack
   * @param A: Given n items with size A[i]
   * @return: The maximum size
   */
  public int backPack(int m, int[] A) {
    if (A == null || A.length == 0 || m <= 0) {
      return 0;
    }
    int n = A.length;
    // With first i item, can I make up max weight j
    boolean[][] f = new boolean[n + 1][m + 1];
    f[0][0] = true;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        // If without current item, it can make to j;
        // with this item not included, it still can make to j
        f[i][j] = f[i - 1][j];
        // If using the rest can make up to j-A[i] weight, put i in will make it to j
        if (j >= A[i - 1] && f[i - 1][j - A[i - 1]]) {
          f[i][j] = true;
        }
      }
    }

    for (int i = m; i >= 0; i--) {
      if (f[n][i] == true) {
        return i;
      }
    }
    return 0;
  }
}
