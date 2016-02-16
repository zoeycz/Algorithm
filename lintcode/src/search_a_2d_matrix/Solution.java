package search_a_2d_matrix;

public class Solution {
  /**
   * @param matrix, a list of lists of integers
   * @param target, an integer
   * @return a boolean, indicate whether matrix contains target
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    int n = matrix.length;
    int m = matrix[0].length;

    int start = 0;
    int end = n - 1;
    int mid = (start + end) / 2;
    int anchor;
    /*
     * Note: infinite loop with start < end will have mid == start and start, end don't change; if
     * start = mid + 1 && end = mid - 1, will go out of boundary
     */
    while (start + 1 < end) {
      if (matrix[mid][0] <= target) {
        start = mid;
      } else {
        end = mid;
      }
      mid = (start + end) / 2;
    }

    // Note: have to check end first
    if (matrix[end][0] <= target) {
      anchor = end;
    } else {
      anchor = start;
    }

    start = 0;
    end = m - 1;
    mid = (start + end) / 2;
    while (start + 1 < end) {
      if (matrix[anchor][mid] <= target) {
        start = mid;
      } else {
        end = mid;
      }
      mid = (start + end) / 2;
    }

    if (matrix[anchor][mid] == target || matrix[anchor][end] == target
        || matrix[anchor][start] == target) {
      return true;
    }
    return false;
  }
}
