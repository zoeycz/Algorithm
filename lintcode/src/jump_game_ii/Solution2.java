package jump_game_ii;

public class Solution2 {
  /**
   * @param A: A list of lists of integers
   * @return: An integer
   */
  public int jump(int[] A) {
    if (A == null || A.length == 0) {
      return -1;
    }
    int n = A.length;
    int[] f = new int[n];
    f[0] = 0;
    int step = 0;
    int start = 0;
    int end = 0;
    int max = 0;

    while (end < n - 1) {
      step++;
      for (int i = start; i <= end; i++) {
        max = Math.max(max, i + A[i]);
      }
      start = end + 1;
      end = max;
    }

    return step;
  }
}

