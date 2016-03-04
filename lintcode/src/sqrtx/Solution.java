package sqrtx;

public class Solution {
  /**
   * Source: http://www.lintcode.com/en/problem/sqrtx/
   * 
   * Complexity: Time: O(log n), Space: O(1)
   * 
   * Type: Binary Search
   * 
   * @param x: An integer
   * @return: The stqrt of x
   */
  public int sqrt(int x) {
    if (x <= 0) {
      // Note: throw Exception in case of negative input
      return 0;
    }

    // Note: Using long instead of int
    long start = 1;
    long end = x;

    while (start + 1 < end) {
      long mid = (start + end) / 2;
      if (mid * mid <= x) {
        start = mid;
      } else {
        end = mid;
      }
    }

    if (end * end <= x) {
      // Note: convert back to int
      return (int) end;
    }

    return (int) start;
  }
}
