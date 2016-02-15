package permutations_II;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
  /**
   * @param nums: A list of integers.
   * @return: A list of unique permutations.
   */
  public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if (nums == null || nums.size() == 0) {
      return res;
    }
    int[] visited = new int[nums.size()];
    Collections.sort(nums);
    ArrayList<Integer> list = new ArrayList<Integer>();
    permuteHelper(res, list, nums, visited);
    return res;
  }

  private void permuteHelper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list,
      ArrayList<Integer> nums, int[] visited) {
    if (list.size() == nums.size()) {
      // Note: Don't forget to create new ArrayList
      res.add(new ArrayList<Integer>(list));
      return;
    }

    for (int i = 0; i < nums.size(); i++) {
      // Note: Use visited to speed up
      if (visited[i] == 1 || (i != 0 && nums.get(i) == nums.get(i - 1) && visited[i - 1] == 0)) {
        continue;
      }
      visited[i] = 1;
      list.add(nums.get(i));
      permuteHelper(res, list, nums, visited);
      list.remove(list.size() - 1);
      visited[i] = 0;
    }
  }
}
