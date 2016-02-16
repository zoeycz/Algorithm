package subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
  /**
   * Source: http://www.lintcode.com/en/problem/subsets/
   * 
   * Complexity: Time: O(n!) Space: O(2^n) Extra Space: O(n)
   * 
   * @param S: A set of numbers.
   * @return: A list of lists. All valid subsets.
   */
  public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    if (nums != null) {
      Arrays.sort(nums);
      subsetsHelper(result, new ArrayList<Integer>(), nums, 0);
    }

    return result;
  }

  // T(n) = n*T(n-1) => T(n) = O(n!)
  // S(n) = O(n) pointers + O(2^n) results
  private void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
      int[] nums, int pos) {
    // Note: Don't forget to new an array. Java is parsing in reference.
    result.add(new ArrayList<Integer>(list));

    for (int i = pos; i < nums.length; i++) {
      list.add(nums[i]);
      // Note: 'i+1' instead of 'pos+1' to make sure non-repetitive
      subsetsHelper(result, list, nums, i + 1);
      list.remove(list.size() - 1);
    }
  }
}

