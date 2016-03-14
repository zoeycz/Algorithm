package interval_coverage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
  class ListComparator implements Comparator<List<Integer>> {
    public int compare(List<Integer> l1, List<Integer> l2) {
      return l1.get(0) - l2.get(0);
    }
  }

  public int intervalCoverage(List<List<Integer>> list) {
    if (list == null || list.size() == 0) {
      return 0;
    }
    Collections.sort(list, new ListComparator());
    int len = list.get(0).get(1) - list.get(0).get(0);
    int end = list.get(0).get(1);
    for (int i = 1; i < list.size(); i++) {
      List<Integer> curr = list.get(i);
      if (curr.get(1) < end) {
        continue;
      } else if (curr.get(0) < end) {
        len += curr.get(1) - end;
        end = curr.get(1);
      } else {
        len += curr.get(1) - curr.get(0);
        end = curr.get(1);
      }
    }
    return len;
  }
}
