package longest_consequent_sequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  /**
   * @param nums: A list of integers
   * @return an integer
   */
  public int longestConsecutive(int[] num) {
    if (num == null || num.length == 0) {
      return 0;
    }
    Set<Integer> set = new HashSet<Integer>();
    for (int i : num) {
      set.add(i);
    }

    int longest = 0;
    for (int i = 0; i < num.length; i++) {
      int down = num[i] - 1;
      while (set.contains(down)) {
        set.remove(down);
        down--;
      }

      int up = num[i] + 1;
      while (set.contains(up)) {
        set.remove(up);
        up++;
      }

      longest = Math.max(longest, up - down - 1);
    }

    return longest;
  }
}
