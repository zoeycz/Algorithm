package subset;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  List<List<Integer>> getAllSubsets(List<Integer> List) {
    List<List<Integer>> rst = new ArrayList<>();
    if (List == null) {
      return rst;
    }
    helper(rst, List, new ArrayList<Integer>(), 0);
    return rst;
  }

  void helper(List<List<Integer>> rst, List<Integer> list, List<Integer> subList, int pos) {
    rst.add(new ArrayList<Integer>(subList));
    if (pos == list.size()) {
      return;
    }
    for (int i = pos; i < list.size(); i++) {
      subList.add(list.get(i));
      helper(rst, list, subList, i + 1);
      subList.remove(subList.size() - 1);
    }
  }
}
