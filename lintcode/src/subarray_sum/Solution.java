package subarray_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  /**
   * @param nums: A list of integers
   * @return: A list of integers includes the index of the first number and the index of the last
   *          number
   */
  public ArrayList<Integer> subarraySum(int[] nums) {
    ArrayList<Integer> rst = new ArrayList<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Initialization
    int sum = 0;
    map.put(sum, -1);

    // Iteration
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      // If I see the same again, it means the sum between is 0
      if (map.get(sum) != null) {
        rst.add(map.get(sum) + 1);
        rst.add(i);
        return rst;
      }
      map.put(sum, i);
    }

    return rst;
  }
}
