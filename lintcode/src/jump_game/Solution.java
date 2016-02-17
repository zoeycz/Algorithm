package jump_game;

public class Solution {
  /**
   * @param A: A list of integers
   * @return: The boolean answer
   */
  public boolean canJump(int[] A) {
    if (A == null || A.length == 0) {
      return false;
    }
    int n = A.length;
    int canReach = A[0];
    if (canReach >= n - 1) {
      return true;
    }
    for (int i = 0; i <= canReach; i++) {
      canReach = Math.max(canReach, i + A[i]);
      if (canReach >= n - 1) {
        return true;
      }
    }
    return false;
  }
}

