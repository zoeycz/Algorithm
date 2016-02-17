package palindrome_partition_ii;

public class Solution2 {
  /**
   * @param s a string
   * @return an integer
   */
  public int minCut(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    boolean[][] isPalindrome = helper(s);
    int n = s.length();
    int[] f = new int[n + 1];
    f[0] = -1;

    for (int i = 1; i <= n; i++) {
      f[i] = i - 1;
      for (int j = 0; j < i; j++) {
        if (isPalindrome[j][i - 1]) {
          f[i] = Math.min(f[i], f[j] + 1);
        }
      }
    }

    return f[n];
  }

  private boolean[][] helper(String s) {
    int n = s.length();
    boolean[][] res = new boolean[n][n];

    // Initialize
    for (int i = 0; i < n; i++) {
      res[i][i] = true;
    }

    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        res[i][i + 1] = true;
      }
    }

    // DP
    // Note: len start from 2 because len = 1 cannot be get into this loop
    for (int len = 2; len < s.length(); len++) {
      for (int i = 0; i + len < s.length(); i++) {
        if (s.charAt(i) == s.charAt(i + len) && res[i + 1][i + len - 1]) {
          res[i][i + len] = true;
        }
      }
    }

    return res;
  }
}
