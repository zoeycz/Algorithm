package factor_combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> rst = new ArrayList<>();
    helper(rst, n, new ArrayList<Integer>(), n);
    return rst;
  }

  private void helper(List<List<Integer>> rst, int n, List<Integer> list, int remainder) {
    if (remainder == 1) {
      rst.add(new ArrayList<Integer>(list));
      return;
    }

    for (int i = n; i >= 2; i--) {
      if (n % i == 0) {
        list.add(i);
        helper(rst, n / i, list, n / i);
        list.remove(list.size() - 1);
      }
    }
  }
}
