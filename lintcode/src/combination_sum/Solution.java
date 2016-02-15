package combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  /**
   * @param candidates: A list of integers
   * @param target:An integer
   * @return: A list of lists of integers
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (candidates == null || candidates.length == 0) {
      return res;
    }
    Arrays.sort(candidates);
    List<Integer> list = new ArrayList<Integer>();
    helper(candidates, target, res, list, 0, 0);
    return res;
  }

  private void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> list,
      int sum, int pos) {
    if (sum == target) {
      res.add(new ArrayList<Integer>(list));
      return;
    } else if (sum > target) {
      return;
    } else {
      for (int i = pos; i < candidates.length; i++) {
        list.add(candidates[i]);
        sum += candidates[i];
        helper(candidates, target, res, list, sum, i);
        sum -= candidates[i];
        list.remove(list.size() - 1);
      }
    }
  }
}
