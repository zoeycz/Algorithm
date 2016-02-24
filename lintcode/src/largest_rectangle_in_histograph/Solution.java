package largest_rectangle_in_histograph;

import java.util.Stack;

public class Solution {
  /**
   * @param height: A list of integer
   * @return: The area of largest rectangle in the histogram
   */
  public int largestRectangleArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    // Use a stack to store width
    Stack<Integer> stack = new Stack<Integer>();
    int max = 0;
    // If height increases, max is increasing, just keep push
    // If height decrease, pop() one by a time and calculate the max so far
    for (int i = 0; i <= height.length; i++) {
      int curr = i == height.length ? -1 : height[i];
      while (stack.size() > 0 && curr < height[stack.peek()]) {
        int h = height[stack.pop()];
        int w = stack.size() > 0 ? i - stack.peek() - 1 : i;
        max = Math.max(max, h * w);
      }
      stack.push(i);
    }

    return max;
  }
}

