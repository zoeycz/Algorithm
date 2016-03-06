package container_with_most_water;

public class Solution {
  /**
   * @param heights: an array of integers
   * @return: an integer
   */
  public int maxArea(int[] heights) {
    if (heights == null || heights.length < 2) {
      return 0;
    }
    int max = 0;
    for (int left = 0, right = heights.length - 1; left < right;) {
      max = Math.max(max, (right - left) * Math.min(heights[left], heights[right]));
      if (heights[left] < heights[right]) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }
}
