package factor_combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> rst = new ArrayList<>();
    helper(rst, n, new ArrayList<Integer>());
    return rst;
  }

  private void helper(List<List<Integer>> rst, int n, List<Integer> list) {
    if (n == 1) {
      rst.add(new ArrayList<Integer>(list));
      return;
    }

    for (int i = n; i >= 2; i--) {
      // Note: get rid of duplicates
      if (n % i == 0 && (list.size() == 0 || list.get(list.size() - 1) >= i)) {
        list.add(i);
        helper(rst, n / i, list);
        list.remove(list.size() - 1);
      }
    }
  }
}
