package permutations;

import java.util.ArrayList;

class Solution {
  /**
   * @param nums: A list of integers.
   * @return: A list of permutations.
   */
  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    if (nums == null || nums.size() == 0) {
      return result;
    }
    // Note: Use visited to save time complexity of contains() check
    int[] visited = new int[nums.size()];
    helper(result, new ArrayList<Integer>(), nums, visited);

    return result;
  }

  private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
      ArrayList<Integer> nums, int[] visited) {
    // Note: End of recursion check
    if (list.size() == nums.size()) {
      result.add(new ArrayList<Integer>(list));
      return;
    }

    for (int i = 0; i < nums.size(); i++) {
      if (visited[i] == 1) {
        continue;
      }
      int x = nums.get(i);
      visited[i] = 1;
      list.add(x);
      helper(result, list, nums, visited);
      list.remove(list.size() - 1);
      visited[i] = 0;
    }
  }
}
