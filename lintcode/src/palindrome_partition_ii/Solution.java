package palindrome_partition_ii;

public class Solution {
  /**
   * Source: http://www.lintcode.com/en/problem/palindrome-partitioning-ii/
   * 
   * Complexity: Time: O(n^2), Space: O(n^2)
   * 
   * @param s a string
   * @return an integer
   */
  public int minCut(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int n = s.length();
    // Note: DP formula needs f[-1], so add 1 to length;
    // f[n] represents min partitions for s[0, n-1]
    int[] f = new int[n + 1];
    f[0] = 0;

    boolean[][] isPalindrome = helper(s);

    // f[i] represents end position i-1;
    for (int i = 1; i < f.length; i++) {
      // first [0, i-1], i partitions in all
      f[i] = i;
      // f[j] represents end position prior to i
      for (int j = 0; j < i; j++) {
        if (isPalindrome[j][i - 1]) {
          f[i] = Math.min(f[i], f[j] + 1);
        }
      }
    }

    // Cut = Partition - 1
    return f[n] - 1;
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
