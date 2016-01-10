package subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
  /**
   * Source: http://www.lintcode.com/en/problem/subsets/
   * 
   * Complexity: Time: O(n*2^n) Space: O(n)
   * 
   * @param S: A set of numbers.
   * @return: A list of lists. All valid subsets.
   */
  public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    if (nums != null) {
      Arrays.sort(nums);
      int n = nums.length;

      // Add combination of all 2^n into result
      for (int i = 0; i < (1 << n); i++) {

        // A list of i length
        ArrayList<Integer> list = new ArrayList<Integer>();

        // Note: Use 'j<n' instead of 'j<i'
        for (int j = 0; j < n; j++) {

          // Check if bit j should be added
          if ((i & (1 << j)) != 0) {
            list.add(nums[j]);
          }
        }
        result.add(list);
      }
    }

    return result;
  }
}
