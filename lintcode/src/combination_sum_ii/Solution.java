package combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  /**
   * @param num: Given the candidate numbers
   * @param target: Given the target number
   * @return: All the combinations that sum to target
   */
  public List<List<Integer>> combinationSum2(int[] num, int target) {
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    if (num == null || num.length == 0) {
      return rst;
    }
    Arrays.sort(num);
    helper(rst, new ArrayList<Integer>(), num, target, 0);
    return rst;
  }

  private void helper(List<List<Integer>> rst, List<Integer> list, int[] num, int target, int pos) {
    if (target == 0) {
      rst.add(new ArrayList<Integer>(list));
      return;
    }
    if (pos == num.length || target < num[pos]) {
      return;
    }
    for (int i = pos; i < num.length; i++) {
      if (i != pos && num[i] == num[i - 1]) {
        continue;
      }
      list.add(num[i]);
      helper(rst, list, num, target - num[i], i + 1);
      list.remove(list.size() - 1);
    }
  }
}
