package max_palindrome_subset;

public class Solution {
  public int maxPalindromeLength(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    int n = arr.length;
    // Note: f is used to avoid duplicated calculation
    int[][] f = new int[n][n];
    return helper(arr, 0, arr.length - 1, 0, f);
  }

  private int helper(int[] arr, int start, int end, int rst, int[][] f) {
    if (f[start][end] != 0) {
      return f[start][end];
    }
    if (start > end) {
      return rst;
    }
    if (start == end) {
      f[start][end] = rst + 1;
      return rst + 1;
    }
    if (arr[start] == arr[end]) {
      return helper(arr, start + 1, end - 1, rst + 2, f);
    }

    int x = helper(arr, start + 1, end, rst, f);
    int y = helper(arr, start, end - 1, rst, f);

    f[start][end] = Math.max(x, y);
    return Math.max(x, y);
  }
}
