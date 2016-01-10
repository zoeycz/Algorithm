package subsetsII;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
  /**
   * Source: http://www.lintcode.com/en/problem/subsets-ii/
   * 
   * Complexity: Time: O(2^n), Space: O(n*n!)
   * 
   * @param S: A set of numbers.
   * @return: A list of lists. All valid subsets.
   */
  public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    if (S != null) {

      // Note: Collections.sort()
      Collections.sort(S);
      helper(result, new ArrayList<Integer>(), S, 0);
    }

    return result;
  }

  private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
      ArrayList<Integer> nums, int pos) {
    result.add(new ArrayList<Integer>(list));

    int n = nums.size();
    for (int i = pos; i < n; i++) {

      // Note: Key to skip duplicated list in the result
      if (i != pos && nums.get(i) == nums.get(i - 1)) {
        continue;
      }
      list.add(nums.get(i));

      // Note: 'i+1' instead of 'pos+1'
      helper(result, list, nums, i + 1);
      list.remove(list.size() - 1);
    }

  }
}

