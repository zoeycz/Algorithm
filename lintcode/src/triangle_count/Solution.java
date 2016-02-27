package triangle_count;

import java.util.Arrays;

public class Solution {
  /**
   * @param S: A list of integers
   * @return: An integer
   */
  public int triangleCount(int S[]) {
    if (S == null || S.length < 3) {
      return 0;
    }
    Arrays.sort(S);
    int count = 0;

    for (int i = 2; i < S.length; i++) {
      int left = 0;
      int right = i - 1;
      while (left < right) {
        if (S[left] + S[right] > S[i]) {
          count += right - left;
          right--;
        } else {
          left++;
        }
      }
    }

    return count;
  }
}

