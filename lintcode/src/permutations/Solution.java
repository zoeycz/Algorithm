package permutations;

import java.util.ArrayList;

public class Solution {
  /**
   * Source: http://www.lintcode.com/en/problem/permutations/
   * 
   * Complexity: Time: O(n!), Space: O(n*n!)
   * 
   * @param nums: A list of integers.
   * @return: A list of permutations.
   */
  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    if (nums == null || nums.size() == 0) {
      return result;
    }

    helper(result, new ArrayList<Integer>(), nums);

    return result;
  }

  private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
      ArrayList<Integer> nums) {

    // Note: Check on size as sign of end
    if (list.size() == nums.size()) {
      result.add(new ArrayList<Integer>(list));
      return;
    }

    for (int i = 0; i < nums.size(); i++) {
      int x = nums.get(i);
      if (list.contains(x)) {
        continue;
      }
      list.add(x);
      helper(result, list, nums);
      list.remove(list.size() - 1);
    }
  }
}
